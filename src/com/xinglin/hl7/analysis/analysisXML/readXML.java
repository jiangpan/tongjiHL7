package com.xinglin.hl7.analysis.analysisXML;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.VO.ANTIBIOTICS;
import com.VO.BASICINFO;
import com.VO.DIAGNOSIS;
import com.VO.LISREPORT;
import com.VO.OPERATIONS;
import com.VO.TEMPERATURE;
import com.VO.XRAY;
import com.factory.DAOFactory;
import com.xinglin.hl7.listener.HL7_listener;

public class readXML
{
    private static Logger logger = Logger.getLogger( readXML.class.getName() );

    /**
     * @param args
     * @throws Throwable
     */
    public static void main( String[] args ) throws Throwable
    {
        insertXMl();
    }

    public static boolean MoveFile( File filesource, String filedns )
    {
        boolean flag = false;
        try
        {
            if( filesource.renameTo( new File( filedns + filesource.getName() ) ) )
            {
                flag = true;
            }
        }
        catch( Exception e )
        {
            logger.error( "【readXML】【MoveFile】", e );
        }
        return flag;
    }

    public static void insertXMl() throws Throwable
    {
        // SimpleDateFormat df = new SimpleDateFormat( "yyyyMMdd" );
        // String nowDay = df.format( new Date() );

        long startTime = System.currentTimeMillis();
        String sour = "d:/runtime/hl7/rerun/xml/";
        String dns = "d:/runtime/hl7/rerun/finished/";
        File folder = new File( sour );
        File[] files = folder.listFiles();
        if( files.length != 0 )
        {
            logger.info( "路径下文件共有" + files.length + "个" );
            // int i = 0;

            Stream.of( files )
                    .parallel()
                    .forEach( file -> {
                        try
                        {
                            // i++;
                            // logger.info( "当前第" + i + "个" );
                            // if( nowDay.compareTo( file.getName().split( "_" )[2] ) <= 0 )
                            // {
                            // continue;
                            // }
                            String typename = file.getName().split( "_" )[0] + file.getName().split( "_" )[1];

                            // logger.info( "当前处理类型为：" + typename );
                            boolean flag = getFiletoDB( file, typename );

                            // logger.info( file.getName() + "的插入结果为：" + flag );
                            // flag=false;
                            if( flag )
                            {
                                File f = new File( dns );
                                if( f.exists() == false )
                                {
                                    f.mkdirs();
                                }

                                boolean moveresult = MoveFile( file, dns );
                                if( moveresult )
                                {
                                    // logger.info( "XMl数据已移动" + file.getName() );
                                }
                                else
                                {
                                    logger.error( "XMl数据移动失败" + file.getName() );
                                }
                            }
                        }
                        catch( Throwable t )
                        {
                            logger.error( t.getMessage(), t );
                        }
                    } );
        }
        else
        {
            logger.info( "指定路径下没有文件：" + sour );
        }

        long endTime = System.currentTimeMillis();
        logger.info( "程序运行时间： " + ( endTime - startTime ) + "ms" );

    }

    public static void insertXMl( JTextArea text ) throws Throwable
    {
        SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss:sss" );// 设置日期格式2

        long startTime = System.currentTimeMillis();
        String sour = "d:/runtime/hl7/typexml/";
        String dns = "d:/runtime/hl7/oldXML/";
        File folder = new File( sour );
        File[] files = folder.listFiles();
        if( files.length != 0 )
        {
            logger.info( "【readXML】路径下文件共有" + files.length + "个" );
            logger.info( "【readXML】开始读取路径下文件：" + sour );
            HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】" + "路径下文件共有" + files.length + "个" + "\n" );
            HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】" + "开始读取路径下文件：" + sour + "\n" );
            for( File file : files )
            {
                logger.info( "【readXML】当前文件名为： " + file.getName() );
                HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】" + "当前文件名为： " + file.getName() + "\n" );
                String typename = file.getName().split( "_" )[0] + file.getName().split( "_" )[1];

                logger.info( "【readXML】当前处理类型为：" + typename );
                HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】" + "当前处理类型为：" + typename + "\n" );
                boolean flag = getFiletoDB( file, typename );

                logger.info( "【readXML】" + file.getName() + "的插入结果为：" + flag );
                HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】" + file.getName() + "的插入结果为：" + flag + "\n" );
                // flag=false;
                if( flag )
                {
                    boolean moveresult = MoveFile( file, dns );
                    if( moveresult )
                    {
                        logger.info( "【readXML】XMl数据已移动" + file.getName() );
                        HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】" + "XMl数据已移动" + file.getName() + "\n" );
                        HL7_listener.getLogTextProxy().text( text, "########################################################################################################################################\n" );
                    }
                    else
                    {
                        logger.error( "【readXML】XMl数据移动失败" + file.getName() );
                        HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】" + "XMl数据移动失败" + file.getName() + "\n" );
                        HL7_listener.getLogTextProxy().text( text, "########################################################################################################################################\n" );
                    }
                }
            }
        }
        else
        {
            logger.info( "【readXML】指定路径下没有文件：" + sour );
            HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】" + "指定路径下没有文件：" + sour + "\n" );
        }

        long endTime = System.currentTimeMillis();
        logger.info( "【readXML】程序运行时间： " + ( endTime - startTime ) + "ms" );

    }

    public static void insertXMl( JTextArea text, String filename ) throws Throwable
    {
        SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss:sss" );// 设置日期格式2

        long startTime = System.currentTimeMillis();
        String sour = "d:/runtime/hl7/typexml/";
        String dns = "d:/runtime/hl7/oldXML/";
        File file = new File( filename );
        if( file.exists() )
        {
            logger.info( "【readXML】开始处理文件：" + filename );
            HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】开始处理文件：" + filename + "\n" );
            // 获取读取文件的类型
            String typename = file.getName().split( "_" )[0] + file.getName().split( "_" )[1];
            logger.info( "【readXML】当前处理类型为：" + typename );
            HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】" + "当前处理类型为：" + typename + "\n" );
            // 根据文件类型进行处理
            boolean flag = getFiletoDB( file, typename );

            logger.info( "【readXML】" + file.getName() + "的插入结果为：" + flag );
            HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】" + file.getName() + "的插入结果为：" + flag + "\n" );
            // flag=false;
            if( flag )
            {
                boolean moveresult = MoveFile( file, dns );
                if( moveresult )
                {
                    logger.info( "【readXML】XMl数据已移动" + file.getName() );
                    HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】" + "XMl数据已移动" + file.getName() + "\n" );
                    HL7_listener.getLogTextProxy().text( text, "########################################################################################################################################\n" );

                }
                else
                {
                    logger.error( "【readXML】XMl数据移动失败" + file.getName() );
                    HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】" + "XMl数据移动失败" + file.getName() + "\n" );
                    HL7_listener.getLogTextProxy().text( text, "########################################################################################################################################\n" );
                }
            }
        }
        else
        {
            logger.info( "【readXML】指定路径下没有文件：" + sour );
            HL7_listener.getLogTextProxy().text( text, "【" + df.format( new Date() ) + "】【readXML】" + "指定路径下没有文件：" + filename + "\n" );
        }

        long endTime = System.currentTimeMillis();
        logger.info( "【readXML】程序运行时间： " + ( endTime - startTime ) + "ms" );

    }

    public static String returnReplace( String adt )
    {
        String adt1 = adt.substring( 0, adt.indexOf( ".", 1 ) );
        String adt2;
        if( adt.indexOf( ".", adt.indexOf( "." ) + 1 ) != -1 )
        {
            adt2 = adt.substring( 0, adt.indexOf( ".", adt.indexOf( "." ) + 1 ) ) + "/" + adt;
        }
        else
        {
            adt2 = adt;
        }
        String replace = adt1 + "/" + adt2;
        return replace;

    }

    public static boolean getFiletoDB( File file, String typename ) throws Throwable
    {
        boolean flag = false;
        // 解析文件，生成document对象
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse( file );
        // 生成XPath对象
        XPath xpath = XPathFactory.newInstance().newXPath();
        // 处理出入转
        if( typename.equals( "ADTA01" ) )
        {
            // 获取诊断数量
            NodeList lens = (NodeList) xpath.evaluate( "/HL7Message/DG1/DG1.1/text()", document, XPathConstants.NODESET );
            int len = lens.getLength();
            // logger.info("【getFiletoDB】共存在"+len+"条DG1诊断数据");
            // 只有一个时
            if( len > 0 && len < 2 )
            {
                ArrayList<DIAGNOSIS> diags = new ArrayList<DIAGNOSIS>();
                for( int i = 0; i < len; i++ )
                {
                    ArrayList<String> resultofdiags = new ArrayList<String>();
                    DIAGNOSIS diag = new DIAGNOSIS();
                    String[] diagtitles = { "MSH.9", "MSH.10", "PID.2", "PV1.19", "PID.5.1", "DG1.1", "DG1.3", "DG1.3.1", "DG1.5", "DG1.6" };
                    for( String adt : diagtitles )
                    {
                        String adt1 = adt.substring( 0, adt.indexOf( ".", 1 ) );
                        String adt2;
                        if( adt.indexOf( ".", adt.indexOf( "." ) + 1 ) != -1 )
                        {
                            adt2 = adt.substring( 0, adt.indexOf( ".", adt.indexOf( "." ) + 1 ) ) + "/" + adt;
                        }
                        else
                        {
                            adt2 = adt;
                        }
                        String replace = adt1 + "/" + adt2;
                        String temp = (String) xpath.evaluate( "/HL7Message/" + replace + "", document, XPathConstants.STRING );
                        resultofdiags.add( temp );
                    }
                    diag.setMSGID( resultofdiags.get( 0 ) );
                    diag.setMSGTYPE( resultofdiags.get( 1 ) + "||" + file.getName() );
                    diag.setPATIENT_ID( resultofdiags.get( 2 ) );
                    diag.setVISIT_ID( resultofdiags.get( 3 ) );
                    diag.setPNAME( resultofdiags.get( 4 ) );
                    diag.setDIAGNOSIS_NO( resultofdiags.get( 5 ) );
                    diag.setDIAGNOSIS_DESC( resultofdiags.get( 6 ) );
                    diag.setDIAGNOSIS_CODE( resultofdiags.get( 7 ) );
                    diag.setDIAGNOSIS_DATE( resultofdiags.get( 8 ) );
                    diag.setDIAGNOSIS_TYPE( resultofdiags.get( 9 ) );
                    diags.add( diag );
                }
                DAOFactory.getDiagnosisDAOInstance().doCreate( diags );
            }
            // 当有多个时，和一个一样，就是加个“[]”的事，懒得合并了，一样
            if( len > 1 )
            {

                ArrayList<DIAGNOSIS> diags = new ArrayList<DIAGNOSIS>();
                for( int i = 1; i <= len; i++ )
                {
                    ArrayList<String> resultofdiags = new ArrayList<String>();
                    DIAGNOSIS diag = new DIAGNOSIS();
                    String[] diagtitles = { "MSH.9", "MSH.10", "PID.2", "PV1.19", "PID.5.1", "DG1.1", "DG1.3", "DG1.3.1", "DG1.5", "DG1.6" };
                    for( String adt : diagtitles )
                    {
                        String replace = "/HL7Message/" + returnReplace( adt ).replace( "DG1/", "DG1[" + i + "]/" );
                        String temp = (String) xpath.evaluate( replace, document, XPathConstants.STRING );
                        resultofdiags.add( temp );
                    }
                    diag.setMSGID( resultofdiags.get( 0 ) );
                    diag.setMSGTYPE( resultofdiags.get( 1 ) + "||" + file.getName() );
                    diag.setPATIENT_ID( resultofdiags.get( 2 ) );
                    diag.setVISIT_ID( resultofdiags.get( 3 ) );
                    diag.setPNAME( resultofdiags.get( 4 ) );
                    diag.setDIAGNOSIS_NO( resultofdiags.get( 5 ) );
                    diag.setDIAGNOSIS_DESC( resultofdiags.get( 6 ) );
                    diag.setDIAGNOSIS_CODE( resultofdiags.get( 7 ) );
                    diag.setDIAGNOSIS_DATE( resultofdiags.get( 8 ) );
                    diag.setDIAGNOSIS_TYPE( resultofdiags.get( 9 ) );
                    diags.add( diag );
                }
                DAOFactory.getDiagnosisDAOInstance().doCreate( diags );
            }

            // 存储基本信息
            ArrayList<BASICINFO> infos = new ArrayList<BASICINFO>();
            BASICINFO info = new BASICINFO();
            String[] adts = { "MSH.9", "MSH.10", "EVN.1", "EVN.2", "PID.2", "PID.3", "PID.5.1", "PID.7", "PID.8", "PID.11", "PID.11", "PID.13", "PID.14", "NK1.4.1", "NK1.2", "NK1.4.1", "NK1.5", "PV1.2", "PV1.3.1", "PV1.3.2", "PV1.3.3", "PV1.3.4", "PV1.3.10", "PV1.6.1", "PV1.6.2", "PV1.6.3", "PV1.6.4", "PV1.7", "PV1.19", "PV1.44", "PV1.45" };
            ArrayList<String> results = new ArrayList<String>();
            for( String adt : adts )
            {
                // 根据“.”切割节点
                String replace = "/HL7Message/" + returnReplace( adt );
                String temp = (String) xpath.evaluate( replace, document, XPathConstants.STRING );
                results.add( temp );
            }
            if( results.size() > 11 )
            {
                info.setMSGTYPE( results.get( 0 ) + "||" + file.getName() );
                info.setMSGID( results.get( 1 ) );
                info.setACTIONTYPE( results.get( 2 ) );
                info.setACTIONTIME( results.get( 3 ) );
                info.setPATIENTID( results.get( 4 ) );
                info.setIDNO( results.get( 5 ) );
                info.setPNAME( results.get( 6 ) );
                info.setPBRITHDATE( results.get( 7 ) );
                info.setPSEX( results.get( 8 ) );
                info.setPADDRESS( results.get( 9 ) );
                info.setPADDRESSNO( results.get( 10 ) );
                info.setPPHONE( results.get( 11 ) );
                info.setPMPHONE( results.get( 12 ) );
                info.setMAILING_ADDRESS( results.get( 13 ) );
                info.setNEXT_OF_KIN( results.get( 14 ) );
                info.setNEXT_OF_KIN_ADDR( results.get( 15 ) );
                info.setNEXT_OF_KIN_PHONE( results.get( 16 ) );
                info.setPTYPE( results.get( 17 ) );
                info.setPDEPT( results.get( 18 ) );
                info.setPWARD( results.get( 19 ) );
                info.setPBEDNO( results.get( 20 ) );
                info.setPHLDY( results.get( 21 ) );
                info.setPLOCATION( results.get( 22 ) );
                info.setPLASTDEPT( results.get( 23 ) );
                info.setPLASTWARD( results.get( 24 ) );
                info.setPLASTBEDNO( results.get( 25 ) );
                info.setPLASTHLDY( results.get( 26 ) );
                info.setATTENDING_DOCTOR( results.get( 27 ) );
                info.setVISITID( results.get( 28 ) );
                info.setINTIME( results.get( 29 ) );
                info.setOUTTIME( results.get( 30 ) );
            }
            infos.add( info );
            flag = DAOFactory.getBasicinfoDAOInstance().doCreate( infos );
        }
        else if( typename.equals( "OMPO09" ) )
        {
            String[] adts = { "MSH.9", "MSH.10", "PID.2", "PID.3.1", "PID.5", "PV1.19", "PV1.3.1", "PV1.3.2", "PV1.3.3", "ORC.1", "ORC.2", "ORC.5", "ORC.9", "ORC.12", "ORC.29", "TQ1.1", "TQ1.3", "TQ1.6", "TQ1.7", "TQ1.8", "TQ1.10", "TQ1.11", "RXO.1", "RXO.2", "RXO.4", "RXO.5", "RXO.20", "RXO.32", "RXR.1", "ORC.25", "RXO.24.1", "RXO.24.2", "RXO.24.4" };
            NodeList lens = (NodeList) xpath.evaluate( "/HL7Message/ORC/ORC.1/text()", document, XPathConstants.NODESET );
            int len = lens.getLength();
            // logger.info("【getFiletoDB】共存在"+len+"条患者数据");
            ArrayList<List<String>> resultss = new ArrayList<>();
            for( int l = 1; l <= len; l++ )
            {
                ArrayList<String> results = new ArrayList<String>();
                for( String adt : adts )
                {
                    String replace = "/HL7Message/" + returnReplace( adt ).replace( "ORC/", "ORC[" + l + "]/" ).replace( "TQ1/", "TQ1[" + l + "]/" ).replace( "RXO/", "RXO[" + l + "]/" ).replace( "RXR/", "RXR[" + l + "]/" );
                    String temp = (String) xpath.evaluate( replace, document, XPathConstants.STRING );
                    results.add( temp );
                }
                resultss.add( results );

            }
            ArrayList<ANTIBIOTICS> antilist = new ArrayList<ANTIBIOTICS>();
            if( resultss.size() >= 1 )
            {
                for( int i = 0; i < resultss.size(); i++ )
                {
                    ANTIBIOTICS anti = new ANTIBIOTICS();
                    anti.setMSGTYPE( (String) resultss.get( i ).get( 0 ) + "||" + file.getName() );// MSH.9
                    anti.setMSGID( (String) resultss.get( i ).get( 1 ) );// MSH.10
                    anti.setPATIENTID( (String) resultss.get( i ).get( 2 ) );// PID.2
                    anti.setIDNO( (String) resultss.get( i ).get( 3 ) );// PID.3.1
                    anti.setPNAME( (String) resultss.get( i ).get( 4 ) );// PID.5
                    anti.setVISITD( (String) resultss.get( i ).get( 5 ) );// PV1.19
                    anti.setPDEPT( (String) resultss.get( i ).get( 6 ) );// PV1.3.1
                    anti.setPWARD( (String) resultss.get( i ).get( 7 ) );// PV1.3.2
                    anti.setPBEDNO( (String) resultss.get( i ).get( 8 ) );// PV1.3.3
                    anti.setSTATUSID( (String) resultss.get( i ).get( 9 ) );// ORC.1
                    anti.setORDERNO( (String) resultss.get( i ).get( 10 ) );// ORC.2
                    anti.setSTATUS( (String) resultss.get( i ).get( 11 ) );// ORC.5
                    anti.setORDERTIME( (String) resultss.get( i ).get( 12 ) );// ORC.9
                    anti.setORDERDOCTOR( (String) resultss.get( i ).get( 13 ) );// ORC.12
                    anti.setORDERTYPE( (String) resultss.get( i ).get( 14 ) );// ORC.29
                    anti.setTQNO( (String) resultss.get( i ).get( 15 ) );// TQ1.1
                    anti.setFREQUENCY( (String) resultss.get( i ).get( 16 ) );// TQ1.3
                    anti.setFORTIME( (String) resultss.get( i ).get( 17 ) );// TQ1.6
                    anti.setSTARTTIME( (String) resultss.get( i ).get( 18 ) );// TQ1.7
                    anti.setENDTIME( (String) resultss.get( i ).get( 19 ) );// TQ1.8
                    anti.setTQTYPE( (String) resultss.get( i ).get( 20 ) );// TQ1.10
                    anti.setTQCONT( (String) resultss.get( i ).get( 21 ) );// TQ1.11
                    anti.setORDERTEXT( (String) resultss.get( i ).get( 22 ) );// RXO.1
                    anti.setDOSAGE( (String) resultss.get( i ).get( 23 ) );// RXO.2
                    anti.setDOSAGEUNITS( (String) resultss.get( i ).get( 24 ) );// RXO.4
                    anti.setDOSAGETYPE( (String) resultss.get( i ).get( 25 ) );// RXO.5
                    anti.setREMARK( (String) resultss.get( i ).get( 26 ) );// RXO.20
                    anti.setROOM( (String) resultss.get( i ).get( 27 ) );// RXO.32
                    anti.setADMINISTRATION( (String) resultss.get( i ).get( 28 ) );// RXR.1
                    anti.setUSE_TIME( (String) resultss.get( i ).get( 29 ) );// ORC.25
                    anti.setGOAL( (String) resultss.get( i ).get( 32 ) );
                    anti.setANTITYPECODE( (String) resultss.get( i ).get( 30 ) );// RXO.24.1
                    anti.setANTITYPENAME( (String) resultss.get( i ).get( 31 ) );// RXO.24.2
                    antilist.add( anti );
                }
            }
            flag = DAOFactory.getAntibioticsDAOInstance().doCreate( antilist );

        }
        else if( typename.equals( "ORUR01" ) )
        {
            String[] adts = { "MSH.9", "MSH.10", "PID.2", "PID.3.1", "PID.5", "PV1.19", "PV1.3.1", "PV1.3.2", "PV1.3.3", "ORC.1", "ORC.29", "OBR.1", "OBR.4", "OBX.1", "OBX.2", "OBX.3", "OBX.5", "OBX.6", "OBX.11", "OBX.14" };
            NodeList lens = (NodeList) xpath.evaluate( "/HL7Message/OBX/OBX.14/text()", document, XPathConstants.NODESET );
            int len = lens.getLength();
            // logger.info("【getFiletoDB】共存在"+len+"条患者数据");
            if( len >= 1 )
            {
                ArrayList<List<String>> resultss = new ArrayList<>();
                for( int l = 1; l <= len; l++ )
                {
                    ArrayList<String> results = new ArrayList<String>();
                    for( String adt : adts )
                    {
                        String replace = "/HL7Message/" + returnReplace( adt ).replace( "OBX/", "OBX[" + l + "]/" );
                        String temp = (String) xpath.evaluate( replace, document, XPathConstants.STRING );
                        results.add( temp );
                    }
                    resultss.add( results );
                }
                ArrayList<TEMPERATURE> tempList = new ArrayList<TEMPERATURE>();
                if( resultss.size() >= 1 )
                {
                    for( int i = 0; i < resultss.size(); i++ )
                    {
                        TEMPERATURE anti = new TEMPERATURE();
                        anti.setMSGTYPE( (String) resultss.get( i ).get( 0 ) + "||" + file.getName() );
                        anti.setMSGID( (String) resultss.get( i ).get( 1 ) );
                        anti.setPATIENTID( (String) resultss.get( i ).get( 2 ) );
                        anti.setIDNO( (String) resultss.get( i ).get( 3 ) );
                        anti.setPNAME( (String) resultss.get( i ).get( 4 ) );
                        anti.setVISITD( (String) resultss.get( i ).get( 5 ) );
                        anti.setPDEPT( (String) resultss.get( i ).get( 6 ) );
                        anti.setPWARD( (String) resultss.get( i ).get( 7 ) );
                        anti.setPBEDNO( (String) resultss.get( i ).get( 8 ) );
                        anti.setORCID( (String) resultss.get( i ).get( 9 ) );
                        anti.setORCTYPE( (String) resultss.get( i ).get( 10 ) );
                        anti.setOBRNO( (String) resultss.get( i ).get( 11 ) );
                        anti.setOBRNAME( (String) resultss.get( i ).get( 12 ) );
                        anti.setOBXNO( (String) resultss.get( i ).get( 13 ) );
                        anti.setOBXTYPE( (String) resultss.get( i ).get( 14 ) );
                        anti.setOBXNAME( (String) resultss.get( i ).get( 15 ) );
                        anti.setOBXRESULT( (String) resultss.get( i ).get( 16 ) );
                        anti.setOBXUNIT( (String) resultss.get( i ).get( 17 ) );
                        anti.setOBXFLAG( (String) resultss.get( i ).get( 18 ) );
                        anti.setOBXTIME( (String) resultss.get( i ).get( 19 ) );
                        // 筛选只保留体温体重
                        if( resultss.get( i ).get( 15 ).equals( "TW体温" ) || resultss.get( i ).get( 15 ).equals( "TZ体重" ) || resultss.get( i ).get( 15 ).equals( "DBCS大便次数" ) )
                        {
                            tempList.add( anti );
                        }
                    }
                }
                flag = DAOFactory.getTemperatureDAOInstance().doCreate( tempList );
            }

        }
        else if( typename.equals( "OULR21" ) )
        {
            String[] adts = { "MSH.9", "MSH.10", "PID.2", "PID.3.1", "PID.5", "PV1.19", "PV1.3.1", "PV1.3.2", "PV1.3.3", "ORC.1", "ORC.16", "ORC.29", "OBR.1", "OBR.2", "OBR.3", "OBR.4", "OBR.22", "OBR.25", "OBR.26.1", "OBX.1", "OBX.2", "OBX.3.2", "OBX.4", "OBX.5", "OBX.7", "OBX.8", "OBX.11", "OBX.17", "OBR.7", "OBX.3.1", "OBR.15", "OBR.14" };
            // 根据obr的个数判断有几份报告
            NodeList lenobr = (NodeList) xpath.evaluate( "/HL7Message/OBR/OBR.1/text()", document, XPathConstants.NODESET );
            // logger.info("【getFiletoDB】报告份数obr子项lenobr个数："+lenobr.getLength());

            NodeList obxnodelist = (NodeList) xpath.evaluate( "/HL7Message/OBX/OBX.1/text()", document, XPathConstants.NODESET );
            int obxitem1 = 0;
            for( int n = 0; n < obxnodelist.getLength(); n++ )
            {
                if( "1".equals( obxnodelist.item( n ).getNodeValue() ) )
                {
                    obxitem1++;
                }
            }
            // 根据obx的个数判断所有报告的子项有多少
            NodeList lens = (NodeList) xpath.evaluate( "/HL7Message/OBX/OBX.17/text()", document, XPathConstants.NODESET );
            int len = lens.getLength();
            // logger.info("【getFiletoDB】子项份数obx子项lenobx个数："+len);
            int lenosbr = obxitem1 > lenobr.getLength() ? lenobr.getLength() : obxitem1;
            // 有多份报告时，先获取每份报告的子数目
            if( lenosbr > 1 )
            {

                ArrayList<Integer> start = new ArrayList<Integer>();
                // 循环每个obx子项，获取每次出现1的位置
                for( int r = 1; r <= len; r++ )
                {
                    String temps = (String) xpath.evaluate( "/HL7Message/OBX[" + r + "]/OBX.1", document, XPathConstants.STRING );
                    if( temps.equals( "1" ) )
                    {
                        start.add( r );
                    }
                }

                // 转换start的位置
                ArrayList<Integer> num = new ArrayList<Integer>();
                int numforlast = 0;
                for( int r = 1; r < lenosbr; r++ )
                {
                    num.add( start.get( r ) - start.get( r - 1 ) );
                    numforlast += start.get( r ) - start.get( r - 1 );
                }
                num.add( len - numforlast );

                // 分成num.length+1份
                for( int t = 1; t <= num.size(); t++ )
                {
                    ArrayList<List<String>> resultss = new ArrayList<>();
                    for( int u = 1; u <= num.get( t - 1 ); u++ )
                    {
                        ArrayList<String> results = new ArrayList<String>();
                        int all = 0;
                        for( int v = 0; v < t - 1; v++ )
                        {
                            all += num.get( v );
                        }
                        int uu = all + u;
                        for( String adt : adts )
                        {
                            String replace = "/HL7Message/" + returnReplace( adt ).replace( "OBX/", "OBX[" + uu + "]/" ).replace( "OBR/", "OBR[" + t + "]/" ).replace( "ORC/", "ORC[" + t + "]/" );

                            String temp = (String) xpath.evaluate( replace, document, XPathConstants.STRING );
                            results.add( temp );
                        }
                        resultss.add( results );
                    }
                    ArrayList<LISREPORT> tempList = new ArrayList<LISREPORT>();
                    if( resultss.size() >= 1 )
                    {
                        for( int i = 0; i < resultss.size(); i++ )
                        {
                            LISREPORT anti = new LISREPORT();
                            anti.setMSGTYPE( (String) resultss.get( i ).get( 0 ) + "||" + file.getName() );// MSH.9
                            anti.setMSGID( (String) resultss.get( i ).get( 1 ) );// MSH.1
                            anti.setPATIENTID( (String) resultss.get( i ).get( 2 ) );// PID.2
                            anti.setIDNO( (String) resultss.get( i ).get( 3 ) );// PID.3.1
                            anti.setPNAME( (String) resultss.get( i ).get( 4 ) );// PID.5
                            anti.setVISITD( (String) resultss.get( i ).get( 5 ) );// PV1.19
                            anti.setPDEPT( (String) resultss.get( i ).get( 6 ) );// PV1.3.1
                            anti.setPWARD( (String) resultss.get( i ).get( 7 ) );// PV1.3.2
                            anti.setPBEDNO( (String) resultss.get( i ).get( 8 ) );// PV1.3.3
                            anti.setORCID( (String) resultss.get( i ).get( 9 ) );// ORC.1
                            anti.setORCUNIT( (String) resultss.get( i ).get( 10 ) );// ORC.16
                            anti.setORCTYPE( (String) resultss.get( i ).get( 11 ) );// ORC.29
                            anti.setOBRNO( (String) resultss.get( i ).get( 12 ) );// OBR.1
                            anti.setREQNO( (String) resultss.get( i ).get( 13 ) );// OBR.2
                            anti.setREPNO( (String) resultss.get( i ).get( 14 ) );// OBR.3
                            anti.setOBRNAME( (String) resultss.get( i ).get( 15 ) );// OBR.4
                            anti.setREPTIME( (String) resultss.get( i ).get( 16 ) );// OBR.22
                            anti.setOBRSTATUS( (String) resultss.get( i ).get( 17 ) );// OBR.25
                            anti.setOBRREPNAME( (String) resultss.get( i ).get( 18 ) );// OBR.47.2
                            anti.setOBXNO( (String) resultss.get( i ).get( 19 ) );// OBX.1
                            anti.setOBXTYPE( (String) resultss.get( i ).get( 20 ) );// OBX.2
                            anti.setOBXNAME( (String) resultss.get( i ).get( 21 ) );// OBX.3
                            anti.setOBXNAMEID( (String) resultss.get( i ).get( 22 ) );// OBX.4
                            anti.setOBXRESULT( (String) resultss.get( i ).get( 23 ) );// OBX.5
                            anti.setOBXRANGE( (String) resultss.get( i ).get( 24 ) );// OBX.7
                            anti.setOBXUNIT( (String) resultss.get( i ).get( 25 ) );// OBX.8
                            anti.setOBXFLAG( (String) resultss.get( i ).get( 26 ) );// OBX.11
                            anti.setOBXMETHOD( (String) resultss.get( i ).get( 27 ) );// OBX.17
                            anti.setREQTIME( (String) resultss.get( i ).get( 28 ) );
                            anti.setOBXNAMECODE( (String) resultss.get( i ).get( 29 ) );
                            anti.setSPECIMEN( (String) resultss.get( i ).get( 30 ) );
                            anti.setRectime( (String) resultss.get( i ).get( 31 ) );
                            tempList.add( anti );
                        }
                    }
                    flag = DAOFactory.getLisreportDAOInstance().doCreate( tempList );

                }

            }
            else
            {

                if( len == 0 )
                {
                    lens = (NodeList) xpath.evaluate( "/HL7Message/OBR/OBR.25/text()", document, XPathConstants.NODESET );
                    len = lens.getLength();
                    // logger.info("【getFiletoDB】共存在"+len+"条sss患者数据");
                }
                if( len >= 1 )
                {
                    ArrayList<List<String>> resultss = new ArrayList<>();
                    for( int l = 1; l <= len; l++ )
                    {
                        ArrayList<String> results = new ArrayList<String>();
                        for( String adt : adts )
                        {
                            String replace = "/HL7Message/" + returnReplace( adt ).replace( "OBR/", "OBR[" + lenobr.getLength() + "]/" ).replace( "OBX/", "OBX[" + l + "]/" );
                            String temp = (String) xpath.evaluate( replace, document, XPathConstants.STRING );
                            results.add( temp );
                        }
                        resultss.add( results );
                    }
                    ArrayList<LISREPORT> tempList = new ArrayList<LISREPORT>();
                    if( resultss.size() >= 1 )
                    {
                        for( int i = 0; i < resultss.size(); i++ )
                        {
                            LISREPORT anti = new LISREPORT();
                            anti.setMSGTYPE( (String) resultss.get( i ).get( 0 ) + "||" + file.getName() );// MSH.9
                            anti.setMSGID( (String) resultss.get( i ).get( 1 ) );// MSH.1
                            anti.setPATIENTID( (String) resultss.get( i ).get( 2 ) );// PID.2
                            anti.setIDNO( (String) resultss.get( i ).get( 3 ) );// PID.3.1
                            anti.setPNAME( (String) resultss.get( i ).get( 4 ) );// PID.5
                            anti.setVISITD( (String) resultss.get( i ).get( 5 ) );// PV1.19
                            anti.setPDEPT( (String) resultss.get( i ).get( 6 ) );// PV1.3.1
                            anti.setPWARD( (String) resultss.get( i ).get( 7 ) );// PV1.3.2
                            anti.setPBEDNO( (String) resultss.get( i ).get( 8 ) );// PV1.3.3
                            anti.setORCID( (String) resultss.get( i ).get( 9 ) );// ORC.1
                            anti.setORCUNIT( (String) resultss.get( i ).get( 10 ) );// ORC.16
                            anti.setORCTYPE( (String) resultss.get( i ).get( 11 ) );// ORC.29
                            anti.setOBRNO( (String) resultss.get( i ).get( 12 ) );// OBR.1
                            anti.setREQNO( (String) resultss.get( i ).get( 13 ) );// OBR.2
                            anti.setREPNO( (String) resultss.get( i ).get( 14 ) );// OBR.3
                            anti.setOBRNAME( (String) resultss.get( i ).get( 15 ) );// OBR.4
                            System.out.println( (String) resultss.get( i ).get( 15 ) );
                            anti.setREPTIME( (String) resultss.get( i ).get( 16 ) );// OBR.22
                            anti.setOBRSTATUS( (String) resultss.get( i ).get( 17 ) );// OBR.25
                            anti.setOBRREPNAME( (String) resultss.get( i ).get( 18 ) );// OBR.47.2
                            anti.setOBXNO( (String) resultss.get( i ).get( 19 ) );// OBX.1
                            anti.setOBXTYPE( (String) resultss.get( i ).get( 20 ) );// OBX.2
                            anti.setOBXNAME( (String) resultss.get( i ).get( 21 ) );// OBX.3
                            anti.setOBXNAMEID( (String) resultss.get( i ).get( 22 ) );// OBX.4
                            anti.setOBXRESULT( (String) resultss.get( i ).get( 23 ) );// OBX.5
                            anti.setOBXRANGE( (String) resultss.get( i ).get( 24 ) );// OBX.7
                            anti.setOBXUNIT( (String) resultss.get( i ).get( 25 ) );// OBX.8
                            anti.setOBXFLAG( (String) resultss.get( i ).get( 26 ) );// OBX.11
                            anti.setOBXMETHOD( (String) resultss.get( i ).get( 27 ) );// OBX.17
                            anti.setREQTIME( (String) resultss.get( i ).get( 28 ) );
                            anti.setOBXNAMECODE( (String) resultss.get( i ).get( 29 ) );
                            anti.setSPECIMEN( (String) resultss.get( i ).get( 30 ) );
                            tempList.add( anti );
                        }
                    }
                    flag = DAOFactory.getLisreportDAOInstance().doCreate( tempList );
                }
            }
        }
        else if( typename.equals( "SIUS12" ) )
        {
            String[] adts = { "MSH.9", "MSH.10", "SCH.2", "SCH.6", "SCH.11.4", "SCH.28", "PID.2", "PV1.2", "PV1.19", "AIS.1", "AIS.3.1", "AIS.3.2", "AIS.3.3", "AIS.4", "AIS.7", "AIS.8", "AIS.11", "AIS.12", "AIS.13", "AIS.14.2", "AIS.15", "AIS.16", "AIS.17.2", "AIS.18", "AIS.19", "AIS.20", "AIS.21", "AIG.4", "AIG.14", "AIL.3.2", "AIL.3.9" };
            // ,"AIP.1","AIP.3.1","AIP.3.2","AIP.4.1","AIP.4.2"};

            NodeList lens = (NodeList) xpath.evaluate( "/HL7Message/SCH/SCH.2/text()", document, XPathConstants.NODESET );
            int len = lens.getLength();
            // logger.info("【getFiletoDB】共存在"+len+"条患者数据");
            NodeList lensAIP = (NodeList) xpath.evaluate( "/HL7Message/AIP/AIP.1/text()", document, XPathConstants.NODESET );
            int lenAIP = lensAIP.getLength();
            // logger.info("【getFiletoDB】共存在"+lenAIP+"条AIP数据");
            if( len > 0 )
            {
                ArrayList<List<String>> resultss = new ArrayList<>();
                for( int l = 1; l <= len; l++ )
                {
                    ArrayList<String> results = new ArrayList<String>();
                    for( String adt : adts )
                    {
                        String replace = "/HL7Message/" + returnReplace( adt );
                        String temp = (String) xpath.evaluate( replace, document, XPathConstants.STRING );
                        results.add( temp );
                    }
                    resultss.add( results );

                    ArrayList<OPERATIONS> tempList = new ArrayList<OPERATIONS>();
                    if( resultss.size() >= 1 )
                    {
                        for( int i = 0; i < resultss.size(); i++ )
                        {
                            OPERATIONS anti = new OPERATIONS();
                            anti.setMSGTYPE( (String) resultss.get( i ).get( 0 ) + "||" + file.getName() );
                            anti.setMSGID( (String) resultss.get( i ).get( 1 ) );
                            anti.setSAPPLYID( (String) resultss.get( i ).get( 2 ) );
                            anti.setSAPPLYREASON( (String) resultss.get( i ).get( 3 ) );
                            anti.setSAPPLYTIME( (String) resultss.get( i ).get( 4 ) );
                            anti.setSDEPT( (String) resultss.get( i ).get( 5 ) );
                            anti.setPATIENTID( (String) resultss.get( i ).get( 6 ) );
                            anti.setPTYPE( (String) resultss.get( i ).get( 7 ) );
                            anti.setVISITID( (String) resultss.get( i ).get( 8 ) );
                            anti.setOPERNO( (String) resultss.get( i ).get( 9 ) );
                            anti.setOPERCODE( (String) resultss.get( i ).get( 10 ) );
                            anti.setOPERNAME( (String) resultss.get( i ).get( 11 ) );
                            anti.setOPERCLASS( (String) resultss.get( i ).get( 12 ) );
                            anti.setOPERSTARTTIME( (String) resultss.get( i ).get( 13 ) );
                            anti.setQUANTUM( (String) resultss.get( i ).get( 14 ) );
                            anti.setQUANTUMUNIT( (String) resultss.get( i ).get( 15 ) );
                            anti.setLOCATION( (String) resultss.get( i ).get( 16 ) );
                            anti.setISGRADE( (String) resultss.get( i ).get( 17 ) );
                            anti.setOPERENDTIME( (String) resultss.get( i ).get( 18 ) );
                            anti.setWOUNDGRADE( (String) resultss.get( i ).get( 19 ) );
                            anti.setNNIS( (String) resultss.get( i ).get( 20 ) );
                            anti.setHEAL( (String) resultss.get( i ).get( 21 ) );
                            anti.setOPERTYPE( (String) resultss.get( i ).get( 22 ) );
                            anti.setEMBED( (String) resultss.get( i ).get( 23 ) );
                            anti.setENDOSCOPIC( (String) resultss.get( i ).get( 24 ) );
                            anti.setBLOODOUT( (String) resultss.get( i ).get( 25 ) );
                            anti.setBLOODIN( (String) resultss.get( i ).get( 26 ) );
                            anti.setANESTHESIAMETHOD( (String) resultss.get( i ).get( 27 ) );
                            anti.setASA( (String) resultss.get( i ).get( 28 ) );
                            anti.setROOM( (String) resultss.get( i ).get( 29 ) );
                            anti.setTAICI( (String) resultss.get( i ).get( 30 ) );
                            for( int aip = 1; aip <= lenAIP; aip++ )
                            {
                                String replace = "/HL7Message/" + returnReplace( "AIP.4.1" ).replace( "AIP/", "AIP[" + aip + "]/" );
                                String temp = (String) xpath.evaluate( replace, document, XPathConstants.STRING );
                                // ,"AIP.1","AIP.3.1","AIP.3.2","AIP.4.1","AIP.4.2"};
                                if( temp.equals( "FPA" ) )
                                {
                                    String replacefpa = "/HL7Message/" + returnReplace( "AIP.3.2" ).replace( "AIP/", "AIP[" + aip + "]/" );
                                    String replacefpacode = "/HL7Message/" + returnReplace( "AIP.3.1" ).replace( "AIP/", "AIP[" + aip + "]/" );
                                    String fpa = (String) xpath.evaluate( replacefpa, document, XPathConstants.STRING );
                                    String fpacode = (String) xpath.evaluate( replacefpacode, document, XPathConstants.STRING );
                                    anti.setSURGEON( fpa );
                                    anti.setSURGEONCODE( fpacode );

                                }
                                else if( temp.equals( "FPB" ) )
                                {
                                    String replacefpb = "/HL7Message/" + returnReplace( "AIP.3.2" ).replace( "AIP/", "AIP[" + aip + "]/" );
                                    String replacefpbcode = "/HL7Message/" + returnReplace( "AIP.3.1" ).replace( "AIP/", "AIP[" + aip + "]/" );
                                    String fpb = (String) xpath.evaluate( replacefpb, document, XPathConstants.STRING );
                                    String fpbcode = (String) xpath.evaluate( replacefpbcode, document, XPathConstants.STRING );
                                    anti.setFIRSTAS( fpb );
                                    anti.setFIRSTASCODE( fpbcode );

                                }
                                else if( temp.equals( "FPC" ) )
                                {
                                    String replacefpc = "/HL7Message/" + returnReplace( "AIP.3.2" ).replace( "AIP/", "AIP[" + aip + "]/" );
                                    String replacefpccode = "/HL7Message/" + returnReplace( "AIP.3.1" ).replace( "AIP/", "AIP[" + aip + "]/" );
                                    String fpc = (String) xpath.evaluate( replacefpc, document, XPathConstants.STRING );
                                    String fpccode = (String) xpath.evaluate( replacefpccode, document, XPathConstants.STRING );
                                    anti.setANESTHESIA( fpc );
                                    anti.setANESTHESIACODE( fpccode );
                                }
                            }

                            tempList.add( anti );
                        }
                    }
                    flag = DAOFactory.getOperationsDAOInstance().doCreate( tempList );
                }

            }
        }
        if( typename.equals( "ORUR01" ) )
        {
            String[] adts = { "MSH.9", "MSH.10", "PID.2", "PID.3.1", "PID.5", "PV1.19", "PV1.3.1", "PV1.3.2", "PV1.3.3", "ORC.1", "ORC.2", "ORC.29", "OBR.1", "OBR.3", "OBR.4", "OBR.22", "OBR.24", "OBR.25", "OBR.47.2", "OBX.1", "OBX.2", "OBX.3", "OBX.5.1", "OBX.5.2", "OBX.8", "OBX.11", "OBX.17" };
            NodeList lens = (NodeList) xpath.evaluate( "/HL7Message/OBX/OBX.17/text()", document, XPathConstants.NODESET );
            int len = lens.getLength();
            // logger.info("【getFiletoDB】共存在"+len+"条患者数据");
            if( len == 0 )
            {
                lens = (NodeList) xpath.evaluate( "/HL7Message/OBR/OBR.25/text()", document, XPathConstants.NODESET );
                len = lens.getLength();
                // logger.info("【getFiletoDB】共存在"+len+"条sss患者数据");
                flag = true;
            }
            if( len >= 1 )
            {
                ArrayList<List<String>> resultss = new ArrayList<>();
                for( int l = 1; l <= len; l++ )
                {
                    ArrayList<String> results = new ArrayList<String>();
                    for( String adt : adts )
                    {
                        String replace = "/HL7Message/" + returnReplace( adt ).replace( "OBX/", "OBX[" + l + "]/" );
                        String temp = (String) xpath.evaluate( replace, document, XPathConstants.STRING );
                        results.add( temp );
                    }
                    resultss.add( results );
                }
                ArrayList<XRAY> tempList = new ArrayList<XRAY>();
                if( resultss.size() >= 1 )
                {
                    for( int i = 0; i < resultss.size(); i++ )
                    {
                        XRAY anti = new XRAY();
                        anti.setMSGTYPE( (String) resultss.get( i ).get( 0 ) + "||" + file.getName() );
                        anti.setMSGID( (String) resultss.get( i ).get( 1 ) );
                        anti.setPATIENTID( (String) resultss.get( i ).get( 2 ) );
                        anti.setIDNO( (String) resultss.get( i ).get( 3 ) );
                        anti.setPNAME( (String) resultss.get( i ).get( 4 ) );
                        anti.setVISITD( (String) resultss.get( i ).get( 5 ) );
                        anti.setPDEPT( (String) resultss.get( i ).get( 6 ) );
                        anti.setPWARD( (String) resultss.get( i ).get( 7 ) );
                        anti.setPBEDNO( (String) resultss.get( i ).get( 8 ) );
                        anti.setORCID( (String) resultss.get( i ).get( 9 ) );
                        anti.setORCNO( (String) resultss.get( i ).get( 10 ) );
                        anti.setORCTYPE( (String) resultss.get( i ).get( 11 ) );
                        anti.setOBRNO( (String) resultss.get( i ).get( 12 ) );
                        anti.setREPNO( (String) resultss.get( i ).get( 13 ) );
                        anti.setOBRNAME( (String) resultss.get( i ).get( 14 ) );
                        anti.setREPTIME( (String) resultss.get( i ).get( 15 ) );
                        anti.setOBRTYPE( (String) resultss.get( i ).get( 16 ) );
                        anti.setOBRSTATUS( (String) resultss.get( i ).get( 17 ) );
                        anti.setOBRREPNAME( (String) resultss.get( i ).get( 18 ) );
                        anti.setOBXNO( (String) resultss.get( i ).get( 19 ) );
                        anti.setOBXTYPE( (String) resultss.get( i ).get( 20 ) );
                        anti.setOBXNAME( (String) resultss.get( i ).get( 21 ) );
                        anti.setOBXRESULT1( (String) resultss.get( i ).get( 22 ) );
                        anti.setOBXRESULT2( (String) resultss.get( i ).get( 23 ) );
                        anti.setOBXUNIT( (String) resultss.get( i ).get( 24 ) );
                        anti.setOBXFLAG( (String) resultss.get( i ).get( 25 ) );
                        anti.setOBXMETHOD( (String) resultss.get( i ).get( 26 ) );
                        tempList.add( anti );
                    }
                }

                flag = DAOFactory.getXrayDAOInstance().doCreate( tempList );
            }
        }
        return flag;
    }

    public static String xmltostring( Document doc ) throws TransformerException
    {
        TransformerFactory tf = TransformerFactory.newInstance();

        javax.xml.transform.Transformer t = tf.newTransformer();

        // t.setOutputProperty(\"encoding\",\"GB23121\");//解决中文问题，试过用GBK不行

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        t.transform( new DOMSource( doc ), new StreamResult( bos ) );

        String xmlStr = bos.toString();
        return xmlStr;
    }
}