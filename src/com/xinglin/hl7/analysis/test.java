package com.xinglin.hl7.analysis;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test
{

    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

        SimpleDateFormat df = new SimpleDateFormat( "yyyyMMdd_HHmmss" );// 设置日期格式
        System.out.println( df.format( new Date() ) );

        SimpleDateFormat df2 = new SimpleDateFormat( "yyyy\\MM\\dd\\HH\\" );// 设置日期格式
        System.out.println( df2.format( new Date() ) );

        File saveFile = new File( "d:/runtime/hl7/files/" + df2.format( new Date() ) );
        System.out.println( saveFile.getAbsolutePath() );

        if( saveFile.exists() == false )
        {
            saveFile.mkdirs();
        }

        String sourceFilePath = "D:\\runtime\\hl7\\files";

        File   sourceFile  = new File( sourceFilePath );
        File[] sourceFiles = sourceFile.listFiles();

        for( int i = 0; i < sourceFiles.length; i++ )
        {
            System.out.println( sourceFiles[i].getName() );
        }
    }

}
