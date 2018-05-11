/**
 * 
 */
package com.xinglin.hl7.listener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author baobao
 *
 */
public class FileDelete
{

    private static Logger logger = Logger.getLogger( FileDelete.class.getName() );

    /**
     * @param args
     * @throws IOException
     */
    public static void main( String[] args ) throws IOException
    {
        // TODO Auto-generated method stub

        String            sourceFilePath = "E:\\files";
        String            zipFilePath    = "E:\\fileszip";
        String            fileName       = "20160810_144619";
        ArrayList<String> filelist       = FileToZip.fileToZip( sourceFilePath, zipFilePath, fileName );
        deleteDirectory( sourceFilePath, fileName );
    }

    /**
     * 删除目录及目录下的文件
     * 
     * @param dir
     *            要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     * @throws IOException
     */
    public static boolean deleteDirectory( String dir, String fileName )
    {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if( !dir.endsWith( File.separator ) )
        {
            dir = dir + File.separator;
        }
        File dirFile = new File( dir );
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if( ( !dirFile.exists() ) || ( !dirFile.isDirectory() ) )
        {
            logger.error( "【FileDelete】" + "删除目录失败：" + dir + "不存在！" );
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        List<File> files = FileToZip.getFilesByPathName( dir, fileName.split( "_" )[0] );
        // File[] files = dirFile.listFiles();
        for( int i = 0; i < files.size(); i++ )
        {
            // 删除子文件
            if( files.get( i ).isFile() )
            {
                flag = FileDelete.deleteFile( files.get( i ).getAbsolutePath() );
                if( !flag )
                    break;
            }
            // 删除子目录
            else if( files.get( i ).isDirectory() )
            {
                flag = FileDelete.deleteDirectory( files.get( i ).getAbsolutePath(), fileName );
                if( !flag )
                    break;
            }
        }
        if( !flag )
        {
            logger.error( "【FileDelete】" + "删除目录失败！" );
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * 删除单个文件
     * 
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile( String fileName )
    {
        File file = new File( fileName );
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if( file.exists() && file.isFile() )
        {
            if( file.getAbsoluteFile().delete() )
            {
                logger.info( "【FileDelete】" + "删除单个文件" + fileName + "成功！" );
                return true;
            }
            else
            {
                logger.error( "【FileDelete】" + "删除单个文件" + fileName + "失败！" );
                return false;
            }
        }
        else
        {
            logger.error( "【FileDelete】" + "删除单个文件失败：" + fileName + "不存在！" );
            return false;
        }
    }

}
