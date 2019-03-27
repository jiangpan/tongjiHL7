package com.xinglin.hl7.analysis.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 根据D:\\findMsgid.txt的msgid记录, 解压备份查找文件 *
 */
public class findMsgById
{
    static String findMsgid  = "D:\\findMsgid.txt";
    static String xmlzip     = "D:\\runtime\\hl7\\backupZIP\\xmlzip2";
    static String findSource = "D:\\runtime\\hl7\\findSource2";
    static String findResult = "D:\\runtime\\hl7\\findResult\\";

    public static void main( String[] args ) throws IOException
    {
        String ar = readToString( findMsgid );

        String[] msgids = ar.split( "\r\n" );

        SimpleFileVisitor<Path> finder = new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) throws IOException
            {
                File f = file.toFile();

                if( f.getName().endsWith( "zip" ) )
                {
                    System.out.println();
                    System.out.println( LocalDateTime.now() + "开始解压文件(" + f.getName() + ")至文件夹" );
                    boolean flag = decompressZip( f.getAbsolutePath(), findSource + "\\" );
                    if( flag )
                    {
                        System.out.println( LocalDateTime.now() + "成功解压文件(" + f.getName() + ")至文件夹" );
                        getUnparsedFilesByPath( findResult, msgids );
                    }
                    else
                    {
                        System.out.println( LocalDateTime.now() + "解压文件(" + f.getName() + ")至文件夹失败!" );
                    }
                }
                else
                {
                    f.delete();
                }
                return super.visitFile( file, attrs );
            }
        };
        java.nio.file.Files.walkFileTree( Paths.get( xmlzip ), finder );
    }

    public static boolean decompressZip( String zipPath, String descDir )
    {
        File zipFile = new File( zipPath );
        boolean flag = false;
        File pathFile = new File( descDir );
        if( !pathFile.exists() )
        {
            pathFile.mkdirs();
        }
        ZipFile zip = null;
        try
        {
            zip = new ZipFile( zipFile, Charset.forName( "gbk" ) );
            int count = 0;
            for( Enumeration<?> entries = zip.entries(); entries.hasMoreElements(); )
            {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zip.getInputStream( entry );
                // 指定解压后的文件夹+当前zip文件的名称
                String outPath = ( descDir + zipEntryName ).replace( "/", File.separator );
                // 判断路径是否存在,不存在则创建文件路径
                File file = new File( outPath.substring( 0, outPath.lastIndexOf( File.separator ) ) );
                if( !file.exists() )
                {
                    file.mkdirs();
                }
                // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                if( new File( outPath ).isDirectory() )
                {
                    continue;
                }
                // System.err.println( "当前zip解压之后的路径为：" + outPath );
                count++;
                OutputStream out = new FileOutputStream( outPath );
                byte[] buf1 = new byte[2048];
                int len;
                while( ( len = in.read( buf1 ) ) > 0 )
                {
                    out.write( buf1, 0, len );
                }
                in.close();
                out.close();
            }
            System.out.println( LocalDateTime.now() + "当前zip解压之后的文件数为：" + count );
            flag = true;
            zip.close();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
        return flag;
    }

    public static void getUnparsedFilesByPath( String dns, String[] msgids ) throws IOException
    {
        long start = System.currentTimeMillis();
        List<File> files = new ArrayList<File>();
        SimpleFileVisitor<Path> finder = new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) throws IOException
            {
                File f = file.toFile();

                if( Stream.of( msgids ).anyMatch( el -> f.getName().indexOf( el ) > -1 ) )
                {
                    files.add( f );
                    boolean isMove = MoveFile( f, dns );
                    if( isMove )
                    {
                        System.out.println( LocalDateTime.now() + "成功找到并转移成功一个文件" );
                    }
                }
                else
                {
                    f.delete();
                }
                return super.visitFile( file, attrs );
            }
        };
        java.nio.file.Files.walkFileTree( Paths.get( findSource ), finder );
        System.out.println( "扫描文件时间为:" + ( System.currentTimeMillis() - start ) + "ms. 发现" + files.size() + "个文件" );
    }

    public static boolean MoveFile( File filesource, String filedns )
    {
        boolean flag = false;
        try
        {
            File newFile = new File( filedns + filesource.getName() );
            if( newFile.exists() == false )
            {
                File parent = newFile.getParentFile();

                if( parent != null )
                {
                    parent.mkdirs();
                }
            }
            if( filesource.renameTo( newFile ) )
            {
                flag = true;
            }
        }
        catch( Exception e )
        {
            System.out.println( e.getMessage() );
        }
        return flag;
    }

    public static String readToString( String fileName )
    {
        String encoding = "UTF-8";
        File file = new File( fileName );
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try
        {
            FileInputStream in = new FileInputStream( file );
            in.read( filecontent );
            in.close();
        }
        catch( Throwable t )
        {
            t.printStackTrace();
        }
        try
        {
            return new String( filecontent, encoding );
        }
        catch( UnsupportedEncodingException e )
        {
            System.err.println( "The OS does not support " + encoding );
            e.printStackTrace();
            return null;
        }
    }
}