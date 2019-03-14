/**
 * 
 */
package com.xinglin.hl7.analysis.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author Administrator
 *
 */
public class readConfig
{
    private static Map<String, String> configMap;
    private static Logger              logger = Logger.getLogger( readConfig.class.getName() );

    public static Map<String, String> getConfigMap()
    {
        if( configMap == null )
        {
            configMap = getDBinfo();
        }
        return configMap;
    }

    private static Map<String, String> getDBinfo()
    {
        Map<String, String> map = new HashMap<>();
        try
        {
            File            file     = new File( "D:/runtime/hl7/Config/config.xml" );
            DocumentBuilder builder  = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document        document = builder.parse( file );
            // 生成XPath对象
            XPath  xpath    = XPathFactory.newInstance().newXPath();
            String dbdriver = (String) xpath.evaluate( "/config/DB/dbdriver/text()", document, XPathConstants.STRING );
            String dbuser   = (String) xpath.evaluate( "/config/DB/dbuser/text()", document, XPathConstants.STRING );
            String dbpass   = (String) xpath.evaluate( "/config/DB/dbpass/text()", document, XPathConstants.STRING );
            String dburl    = (String) xpath.evaluate( "/config/DB/dburl/text()", document, XPathConstants.STRING );

            String detail = (String) xpath.evaluate( "/config/LOG/detail/text()", document, XPathConstants.STRING );
            String swing  = (String) xpath.evaluate( "/config/LOG/swing/text()", document, XPathConstants.STRING );

            map.put( "dbdriver", dbdriver );
            map.put( "dbuser", dbuser );
            map.put( "dbpass", dbpass );
            map.put( "dburl", dburl );
            map.put( "detail", detail );
            map.put( "swing", swing );
        }
        catch( Throwable t )
        {
            logger.error( t.getMessage(), t );
        }
        return map;
    }
    /*
     * public static ArrayList<String> readConfig() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
     * {
     * String sour="D:/runtime/hl7/config/config.xml";
     * File file = new File(sour);
     * DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
     * Document document = builder.parse(file);
     * 
     * XPath xpath = XPathFactory.newInstance().newXPath();
     * ArrayList<String> result=new ArrayList<String>();
     * String classname = (String) xpath.evaluate("/config/class/classname/text()", document,XPathConstants.STRING);
     * System.out.println(classname);
     * result.add(classname);
     * String userno = (String) xpath.evaluate("/config/class/userno/text()", document,XPathConstants.STRING);
     * System.out.println(userno);
     * result.add(userno);
     * String username = (String) xpath.evaluate("/config/class/username/text()", document,XPathConstants.STRING);
     * System.out.println(username);
     * result.add(username);
     * String address = (String) xpath.evaluate("/config/class/address/text()", document,XPathConstants.STRING);
     * System.out.println(address);
     * result.add(address);
     * String dept = (String) xpath.evaluate("/config/class/dept/text()", document,XPathConstants.STRING);
     * System.out.println(dept);
     * result.add(dept);
     * System.out.println("-------------");
     * return result;
     * }
     */

    public static ArrayList<String> CreateAck( String url ) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
    {
        File              file = new File( url );
        ArrayList<String> acks = new ArrayList<String>();
        String            ack1 = "MSH|^~\\&|";
        if( file.isFile() && file.exists() )
        {
            DocumentBuilder builder  = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document        document = builder.parse( file );
            XPath           xpath    = XPathFactory.newInstance().newXPath();
            ack1 += (String) "INFECT" + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.6", document, XPathConstants.STRING ) + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.3", document, XPathConstants.STRING ) + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.4", document, XPathConstants.STRING ) + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.7", document, XPathConstants.STRING ) + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.8", document, XPathConstants.STRING ) + "|"
                    + "ACK^A01" + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.10", document, XPathConstants.STRING ) + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.11", document, XPathConstants.STRING ) + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.12", document, XPathConstants.STRING ) + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.13", document, XPathConstants.STRING ) + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.14", document, XPathConstants.STRING ) + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.15", document, XPathConstants.STRING ) + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.16", document, XPathConstants.STRING ) + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.17", document, XPathConstants.STRING ) + "|"
                    + (String) xpath.evaluate( "/HL7Message/MSH/MSH.18", document, XPathConstants.STRING );

            String  ack2 = "MSA|AA|" + (String) xpath.evaluate( "/HL7Message/MSH/MSH.10", document, XPathConstants.STRING );
            boolean flag = true;

            String ack3 = "";
            if( !flag )
            {
                ack3 = "ERR||||s001|||success";
            }
            acks.add( ack1 );
            acks.add( ack2 );
            acks.add( ack3 );
        }
        else
        {
            logger.error( "指定路径下没有请求文件：" + url );
        }
        return acks;

    }
}
