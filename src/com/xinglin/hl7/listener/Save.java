package com.xinglin.hl7.listener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Save
{
    public static boolean save( String url, String content )
    {
        boolean result = false;
        content = content.replace( "&", "$" ).replace( "EVN|", "\nEVN|" ).replace( "PID|", "\nPID|" ).replace( "PV1|", "\nPV1|" ).replace( "DG1|", "\nDG1|" ).replace( "IN1|", "\nIN1|" );
        File file = new File( url );
        try
        {
            FileOutputStream fop = new FileOutputStream( file );
            if( !file.exists() )
            {
                file.createNewFile();
            }
            byte[] contentInBytes = content.getBytes( "utf-8" );
            fop.write( contentInBytes );
            fop.flush();
            fop.close();
            result = true;

        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
        return result;
    }
}