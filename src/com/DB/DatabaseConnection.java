/**
 * 
 */
package com.DB;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author xinglinyg
 *
 */
public class DatabaseConnection
{

    private static Logger logger = Logger.getLogger( DatabaseConnection.class.getName() );
    /**
     * 
     */
    Connection            conn   = null;

    public static HashMap getDBinfo() throws ParserConfigurationException, SAXException, IOException, TransformerException, XPathExpressionException
    {
        File            file     = new File( "D:/runtime/hl7/Config/config.xml" );
        HashMap         map      = (HashMap) new HashMap<String, String>();
        DocumentBuilder builder  = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document        document = builder.parse( file );
        // 生成XPath对象
        XPath  xpath    = XPathFactory.newInstance().newXPath();
        String dbdriver = (String) xpath.evaluate( "/config/DB/dbdriver/text()", document, XPathConstants.STRING );
        String dbuser   = (String) xpath.evaluate( "/config/DB/dbuser/text()", document, XPathConstants.STRING );
        String dbpass   = (String) xpath.evaluate( "/config/DB/dbpass/text()", document, XPathConstants.STRING );
        String dburl    = (String) xpath.evaluate( "/config/DB/dburl/text()", document, XPathConstants.STRING );
        map.put( "dbdriver", dbdriver );
        map.put( "dbuser", dbuser );
        map.put( "dbpass", dbpass );
        map.put( "dburl", dburl );
        return map;

    }

    public DatabaseConnection() throws Exception
    {
        // TODO Auto-generated constructor stub
        try
        {
            HashMap map = getDBinfo();
            Class.forName( (String) map.get( "dbdriver" ) );
            getDBinfo();
            this.conn = DriverManager.getConnection( (String) map.get( "dburl" ), (String) map.get( "dbuser" ), (String) map.get( "dbpass" ) );

        }
        catch( Exception e )
        {
            throw e;
        }
    }

    public Connection getConnection()
    {
        return this.conn;
    }

    public void close() throws Exception
    {
        if( this.conn != null )
        {
            try
            {
                this.conn.close();
            }
            catch( Exception e )
            {
                throw e;
            }
        }
    }

}
