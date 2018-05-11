package com.xinglin.hl7.analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

public class analysis
{

    private static Logger logger = Logger.getLogger( analysis.class.getName() );

    public static void readFiles( String sour ) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException
    {
        File   folder = new File( sour );
        File[] files  = folder.listFiles();
        if( files.length != 0 )
        {
            logger.info( "路径下文件共有" + files.length + "个" );
            logger.info( "开始读取路径下文件：" + sour );
            for( File file : files )
            {
                String encoding = "utf-8";
                if( file.isFile() && file.exists() )
                { // 判断文件是否存在
                    InputStreamReader read           = new InputStreamReader(
                            new FileInputStream( file ), encoding );// 考虑到编码格式
                    BufferedReader    bufferedReader = new BufferedReader( read );
                    String            lineTxts       = "";
                    String            lineTxt        = null;

                    while( ( lineTxt = bufferedReader.readLine() ) != null )
                    {
                        lineTxts += lineTxt;
                    }

                    lineTxts = "MSH|^~\\&|HIS||ESB||20160504151811||ADT^A01^ADT_A01|7da1c62e-c7d2-4616-8bf5-06c2b9388b98|P|2.6|||NE|AL||utf-8\n"
                            + "EVN|C|20160504151811|||820964^陈娟\n"
                            + "PID||1005122721|||涂松林^^^TU SONG LIN||19570726000000|1|||&兰溪镇鲇鱼尾村四组\n"
                            + "PV1||2|210102^21010202^009^213424^^^^^9^ 呼吸内科$呼吸内科病区$呼吸内科护理单元||||||||||||||||1||||||||||||||||||||H0002|||||20160504114100\n"
                            + "DG1|1||R06.002^胸闷|||A\n"
                            + "IN1|1|A^自费|NONE";

                    toXml( lineTxts, file.getName() );
                    read.close();
                }
            }

        }
        else
        {
            logger.error( "指定路径下没有请求文件：" + sour );
        }

    }

    public static String readFile( String sour ) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException
    {
        File   file     = new File( sour );
        String type     = null;
        String encoding = "utf-8";
        if( file.isFile() && file.exists() )
        { // 判断文件是否存在

            InputStreamReader read           = new InputStreamReader( new FileInputStream( file ), encoding );// 考虑到编码格式
            BufferedReader    bufferedReader = new BufferedReader( read );
            String            lineTxts       = "";
            String            lineTxt        = null;

            while( ( lineTxt = bufferedReader.readLine() ) != null )
            {
                if( !lineTxt.equals( "" ) )
                {
                    lineTxts += lineTxt + "\n";
                }
            }
            read.close();
            logger.info( "readFilelineTxts:\n" + lineTxts );
            logger.info( "readFilegetName:\n" + file.getName() );
            type = toXml( lineTxts, file.getName() );

        }
        else
        {
            logger.error( "指定路径下没有请求文件：" + sour );
        }
        return type;
    }

    public static String toXml( String myHL7string, String filename ) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
    {
        String savestring = HL7ToXmlConverter.ConvertToXml( myHL7string, filename );

        File                 file      = new File( "D:/runtime/hl7/savedxml/" + filename + ".xml" );
        DocumentBuilder      builder   = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document document1 = (org.w3c.dom.Document) builder.parse( file );
        XPath                xpath     = XPathFactory.newInstance().newXPath();

        String type1 = (String) xpath.evaluate( "/HL7Message/MSH/MSH.9/MSH.9.3/text()", document1, XPathConstants.STRING );
        MoveFile( file, "D:/runtime/hl7/typexml/" + type1 + "_" );
        logger.info( "the type is : " + type1 );
        return type1;
    }

    public static void main( String[] args ) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException
    {
        // readFiles("d:/runtime/hl7/files/");

        readFile( "d:/runtime/hl7/files/20180108_113151_fefa5ce1-1ff2-402f-ba62-4f4c3383a0b0_0.txt" );
    }

    public static boolean MoveFile( File filesource, String filedns )
    {
        boolean flag = false;
        try
        {
            if( filesource.renameTo( new File( filedns + filesource.getName() ) ) )
            {
                logger.info( "File is moved successful!" );
                flag = true;
            }
            else
            {
                logger.error( "File is failed to move!" );
            }
        }
        catch( Exception e )
        {

            logger.error( "【analysis】【MoveFile】", e );
            e.printStackTrace();
        }
        return flag;
    }

}
