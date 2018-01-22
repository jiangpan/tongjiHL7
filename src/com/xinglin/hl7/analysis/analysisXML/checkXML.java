/**
 * 
 */
package com.xinglin.hl7.analysis.analysisXML;

import java.io.File;
import java.io.IOException;

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
public class checkXML
{
    private static Logger logger = Logger.getLogger( checkXML.class.getName() );

    /**
     * @param args
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws XPathExpressionException
     */
    public static void main( String[] args ) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
    {
        // TODO Auto-generated method stub

        CheckXML( "d:/runtime/hl7/typexml/ADT_A01_20160726_012557_0.txt.xml", null );
    }

    public static String CheckXML( String url, String type ) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
    {
        File   file    = new File( url );
        String ackcont = "";
        if( file.isFile() && file.exists() )
        {
            DocumentBuilder builder  = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document        document = builder.parse( file );
            XPath           xpath    = XPathFactory.newInstance().newXPath();
            if( type.equals( "ADT_A01" ) )
            {

                String evn1 = (String) xpath.evaluate( "/HL7Message/MSH/MSH.9", document, XPathConstants.STRING );
                String evn2 = (String) xpath.evaluate( "/HL7Message/EVN/EVN.2", document, XPathConstants.STRING );
                String pid2 = (String) xpath.evaluate( "/HL7Message/PID/PID.2", document, XPathConstants.STRING );
                String pid4 = (String) xpath.evaluate( "/HL7Message/PID/PID.4", document, XPathConstants.STRING );
                String pid5 = (String) xpath.evaluate( "/HL7Message/PID/PID.5", document, XPathConstants.STRING );
                String pid7 = (String) xpath.evaluate( "/HL7Message/PID/PID.7", document, XPathConstants.STRING );
                if( evn1.equals( "" ) )
                {
                    logger.info( "事件类型代代码为空" );
                    ackcont += "事件类型代代码为空；";
                }
                else if( evn2.equals( "" ) )
                {
                    System.out.print( "事件记录时间为空" );
                    ackcont += "事件记录时间为空；";
                }
                else if( pid2.equals( "" ) )
                {
                    System.out.print( "病人唯一标示为空" );
                    ackcont += "病人唯一标示为空；";
                }
                else if( pid5.equals( "" ) )
                {
                    System.out.print( "患者姓名为空" );
                    ackcont += "患者姓名为空";
                }
            }

        }
        else
        {

            logger.error( "指定路径下没有请求文件：" + url );
        }

        return ackcont;

    }

}
