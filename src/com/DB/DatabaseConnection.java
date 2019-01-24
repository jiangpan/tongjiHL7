/**
 * 
 */
package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

import com.xinglin.hl7.analysis.analysisXML.readConfig;

/**
 * @author xinglinyg
 *
 */
public class DatabaseConnection
{
    // private static Logger logger = Logger.getLogger( DatabaseConnection.class.getName() );

    Connection conn = null;

    public DatabaseConnection() throws Exception
    {
        try
        {
            Map<String, String> map = readConfig.getConfigMap();
            Class.forName( (String) map.get( "dbdriver" ) );
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
