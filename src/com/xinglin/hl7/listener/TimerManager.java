package com.xinglin.hl7.listener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

/**
 * 任务管理
 * 
 * @author baobao
 *
 */
public class TimerManager
{

    private static Logger logger = Logger.getLogger( TimerManager.class.getName() );

    /**
     * @param args
     */
    public static void main( String[] args )
    {

        logger.info( "开始删除计划" );
        new TimerManager();

    }

    // 时间间隔(一天)
    private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

    public TimerManager()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set( Calendar.HOUR_OF_DAY, 13 ); // 凌晨1点
        calendar.set( Calendar.MINUTE, 42 );
        calendar.set( Calendar.SECOND, 00 );
        Date date = calendar.getTime(); // 第一次执行定时任务的时间
        // 如果第一次执行定时任务的时间 小于当前的时间
        // 此时要在 第一次执行定时任务的时间加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。
        if( date.before( new Date() ) )
        {
            date = this.addDay( date, 1 );
        }
        Timer timer = new Timer();
        Task  task  = new Task();
        // 安排指定的任务在指定的时间开始进行重复的固定延迟执行。
        timer.schedule( task, date, PERIOD_DAY );
    }

    // 增加或减少天数
    public Date addDay( Date date, int num )
    {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime( date );
        startDT.add( Calendar.DAY_OF_MONTH, num );
        return startDT.getTime();
    }

}

class Task extends TimerTask
{

    private static Logger logger = Logger.getLogger( TimerTask.class.getName() );

    public void run()
    {
        logger.info( "开始计划Task!" );
        SimpleDateFormat dft       = new SimpleDateFormat( "yyyyMMdd_HHmmss" );// 设置日期格式
        Date             beginDate = new Date();
        Calendar         date      = Calendar.getInstance();
        date.setTime( beginDate );
        date.set( Calendar.DATE, date.get( Calendar.DATE ) - 3 );

        String            fileName       = dft.format( date.getTime() );
        String            sourceFilePath = "D:\\runtime\\hl7\\files";
        String            zipFilePath    = "D:\\runtime\\hl7\\backupZIP\\fileszip";
        ArrayList<String> filelist       = FileToZip.fileToZip( sourceFilePath, zipFilePath, fileName );
        if( filelist.size() > 0 )
        {
            boolean flag = FileDelete.deleteDirectory( sourceFilePath, fileName );

            logger.info( "删除files文件夹计划!" + flag );
        }
        else
        {
            logger.error( "【Task】未发现需要压缩的文件" );
        }
        String            fileName2       = dft.format( date.getTime() );
        String            sourceFilePath2 = "D:\\runtime\\hl7\\oldXML";
        String            zipFilePath2    = "D:\\runtime\\hl7\\backupZIP\\xmlzip";
        ArrayList<String> filelist2       = FileToZip.fileToZip( sourceFilePath2, zipFilePath2, fileName2 );
        if( filelist2.size() > 0 )
        {
            boolean flag = FileDelete.deleteDirectory( sourceFilePath2, fileName2 );

            logger.info( "删除oldXML文件夹计划!" + flag );
        }
        else
        {
            logger.error( "【Task】未发现需要压缩的文件" );
        }
        System.exit( 0 );
    }
}
