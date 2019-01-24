/**
 * 
 */
package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.xinglin.hl7.analysis.analysis;

/**
 *
 * @author <a href="mailto:baojf@xinglin-tech.com">baojf</a>
 * @since 2018年1月8日
 */

public class findNoDept
{

    /**
     * 
     */
    public findNoDept()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws XPathExpressionException
     */
    public static void main( String[] args ) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException
    {
        // TODO Auto-generated method stub
        List<String> names = findMids();
        System.out.println( names.size() );
        // findAllMid( names );
        transXML();
    }

    public static void transXML() throws XPathExpressionException, IOException, ParserConfigurationException, SAXException
    {
        String sour2  = "D:\\QQDownload\\new\\";
        File   folder = new File( sour2 );
        File[] files  = folder.listFiles();
        if( files.length != 0 )
        {
            for( File file : files )
            {
                analysis.readFile( file.getAbsolutePath() );

            }
        }
    }

    public static List<String> findMids() throws IOException
    {
        List<String> names    = new ArrayList<String>();
        String       sour     = "D:\\QQDownload\\mids.txt";
        File         file     = new File( sour );
        String       type     = null;
        String       encoding = "utf-8";
        if( file.isFile() && file.exists() )
        { // 判断文件是否存在
            InputStreamReader read           = new InputStreamReader(
                    new FileInputStream( file ), encoding );              // 考虑到编码格式
            BufferedReader    bufferedReader = new BufferedReader( read );
            String            lineTxt        = null;

            while( ( lineTxt = bufferedReader.readLine() ) != null )
            {
                names.add( lineTxt );
            }
            read.close();
        }
        return names;
    }

    public static void findAllMid( List<String> names )
    {
        String sour   = "D:\\QQDownload\\files\\";
        String sour2  = "D:\\QQDownload\\new\\";
        File   folder = new File( sour );
        File[] files  = folder.listFiles();
        if( files.length != 0 )
        {
            for( File file : files )
            {
                if( isContains( names, file.getName() ) )
                {
                    analysis.MoveFile( file, sour2 );
                }
            }
        }
    }

    public static boolean isContains( List<String> names, String name )
    {
        for( String n : names )
        {
            if( name.contains( n ) )
            {
                return true;
            }
        }
        return false;
    }

}
