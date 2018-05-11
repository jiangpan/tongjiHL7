package com.xinglin.hl7.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

/**
 * 将文件夹下面的文件
 * 打包成zip压缩文件
 * 
 * @author baobao
 *
 */
public final class FileToZip
{

    private static Logger logger = Logger.getLogger( FileToZip.class.getName() );

    private FileToZip()
    {
    }

    public static List<File> getFilesByPathName( String sourceFilePath, String name )
    {
        long                    start  = System.currentTimeMillis();
        List<File>              files  = new ArrayList<File>();
        SimpleFileVisitor<Path> finder = new SimpleFileVisitor<Path>(){
                                           @Override
                                           public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) throws IOException
                                           {
                                               File f = file.toFile();
                                               if( f.getName().indexOf( name ) > -1 )
                                               {
                                                   files.add( f );
                                               }
                                               return super.visitFile( file, attrs );
                                           }
                                       };

        try
        {
            java.nio.file.Files.walkFileTree( Paths.get( sourceFilePath ), finder );
        }
        catch( IOException e )
        {
            logger.error( e.getMessage(), e );
        }
        logger.info( "本次扫描路径(" + sourceFilePath + ")下获取文件数量:" + files.size() );
        logger.info( "扫描文件时间为:" + ( System.currentTimeMillis() - start ) );
        return files;
    }

    /**
     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
     * 
     * @param sourceFilePath :待压缩的文件路径
     * @param zipFilePath :压缩后存放路径
     * @param fileName :压缩后文件的名称
     * @return
     */
    public static ArrayList<String> fileToZip( String sourceFilePath, String zipFilePath, String fileName )
    {
        File sourceFile = new File( sourceFilePath );

        FileInputStream     fis            = null;
        BufferedInputStream bis            = null;
        FileOutputStream    fos            = null;
        ZipOutputStream     zos            = null;
        ArrayList<String>   deleteFileName = new ArrayList<String>();
        if( sourceFile.exists() == false )
        {
            logger.error( "【FileToZip】" + "待压缩的文件目录：" + sourceFilePath + "不存在." );
        }
        else
        {
            try
            {
                File zipFile = new File( zipFilePath + "/" + fileName + ".zip" );
                if( zipFile.exists() )
                {
                    logger.error( "【FileToZip】" + "待压缩的文件目录：" + zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件." );
                }
                else
                {
                    List<File> sourceFiles = getFilesByPathName( sourceFilePath, fileName.split( "_" )[0] );
                    // File[] sourceFiles = sourceFile.listFiles();

                    if( null == sourceFiles || sourceFiles.size() < 1 )
                    {
                        logger.error( "【FileToZip】" + "待压缩的文件目录：" + "待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩." );
                    }
                    else
                    {
                        fos = new FileOutputStream( zipFile );
                        zos = new ZipOutputStream( new BufferedOutputStream( fos ) );
                        byte[] bufs = new byte[1024 * 10];
                        for( int i = 0; i < sourceFiles.size(); i++ )
                        {
                            // 创建ZIP实体，并添加进压缩包
                            ZipEntry zipEntry = new ZipEntry( sourceFiles.get( i ).getName() );
                            zos.putNextEntry( zipEntry );
                            // 读取待压缩的文件并写进压缩包里
                            fis = new FileInputStream( sourceFiles.get( i ) );
                            bis = new BufferedInputStream( fis, 1024 * 10 );
                            int read = 0;
                            while( ( read = bis.read( bufs, 0, 1024 * 10 ) ) != -1 )
                            {
                                zos.write( bufs, 0, read );
                            }
                            deleteFileName.add( sourceFiles.get( i ).getName() );
                            fis.close();
                            bis.close();
                        }
                    }
                }
            }
            catch( FileNotFoundException e )
            {
                e.printStackTrace();
                throw new RuntimeException( e );
            }
            catch( IOException e )
            {
                e.printStackTrace();
                throw new RuntimeException( e );
            }
            finally
            {
                // 关闭流
                try
                {
                    if( null != bis )
                    {
                        bis.close();
                    }
                    if( null != zos )
                    {
                        zos.close();
                    }
                    if( null != fis )
                    {
                        fis.close();
                    }
                    if( null != fos )
                    {
                        fos.close();
                    }

                }
                catch( IOException e )
                {

                    logger.error( "【FileToZip】", e );
                    e.printStackTrace();
                }
            }
        }
        return deleteFileName;
    }
}