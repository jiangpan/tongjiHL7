/**
 * 
 */
package com.xinglin.hl7.listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.xinglin.hl7.analysis.analysis;
import com.xinglin.hl7.analysis.analysisXML.readConfig;
import com.xinglin.hl7.analysis.analysisXML.readXML;

/**
 * @author Administrator
 *
 */
public class HL7_listener
{

    private static Logger logger = Logger.getLogger( HL7_listener.class.getName() );

    public static final int PORT = 8000; // 监听的端口号

    public static JTextArea text; // 服务器相关的界面组件

    public static void main( String[] args )
    {

        Thread shutdownHook = new Thread(){
            public void run()
            {
                try
                {
                    Thread.sleep( 1000 );
                }
                catch( InterruptedException e )
                {
                    // TODO Auto-generated catch block
                    logger.error( this.getName(), e );
                }
                logger.info( "restart" );
                new HL7_listener().init();
            }
        };
        Runtime.getRuntime().addShutdownHook( shutdownHook );
        new HL7_listener().init();
    }

    public void init()
    {
        logger.info( " 建立线程压缩文件" );
        new Thread( new TimerManagerThread() ).start();
        JFrame frame = new JFrame( "HL7_Listener" );
        text = new JTextArea();
        JScrollPane scroll = new JScrollPane( text );
        frame.add( scroll );
        frame.setVisible( true );
        frame.setSize( 600, 800 );
        text.setEditable( true );

        frame.addWindowListener( new WindowAdapter() // 关闭窗口
        {
            public void windowClosing( WindowEvent e )
            {
                int rs = JOptionPane.showConfirmDialog( null, "是否退出?" );
                if( rs == 0 )
                    System.exit( 0 );
            }
        } );

        ServerSocket serverSocket = null;
        try
        {
            serverSocket = new ServerSocket( PORT );
            text.append( "监听" + PORT + "端口" + "\n" );
            logger.info( "【HL7_listener】开始监听" + PORT + "端口" );
            while( true )
            {
                Socket client = serverSocket.accept();
                logger.info( "【HL7_listener】新增连接：" + client.getInetAddress() + ":" + client.getPort() );
                text.append( "【HL7_listener】新增连接：" + client.getInetAddress() + ":" + client.getPort() + "\n" );
                // 线程处理读写
                new Thread( new ReadHandlerThread( client, text ) ).start();

                // new Thread(new WriteHandlerThread(client,text)).start();
            }
        }
        catch( Exception e )
        {
            logger.error( "【HL7_listener】【Error】", e );
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if( serverSocket != null )
                {
                    serverSocket.close();
                }
            }
            catch( IOException e )
            {
                logger.error( "【HL7_listener】【Error】", e );
                e.printStackTrace();
            }
        }
    }

}

/*
 * 处理读操作的线程
 */
class ReadHandlerThread implements Runnable
{

    private static Logger logger = Logger.getLogger( ReadHandlerThread.class.getName() );
    private Socket        client;
    private JTextArea     text;

    public ReadHandlerThread( Socket client, JTextArea text )
    {
        this.client = client;
        this.text   = text;
    }

    @Override
    public void run()
    {

        BufferedReader br = null; // 服务器端的输入流
        PrintStream    ps = null; // 服务器端的输出流
        try
        {
            int i = 0;
            br = new BufferedReader( new InputStreamReader( client.getInputStream(), "utf-8" ) );
            ps = new PrintStream( client.getOutputStream() );
            String reciver;// 每次接受内容
            String input       = "";// 完整消息
            String filename    = null;// 保存文件名
            String mshtypename = null;// MSH id
            while( ( reciver = br.readLine() ) != null )
            {
                // 读取客户端数据

                SimpleDateFormat df = new SimpleDateFormat( "yyyyMMdd_HHmmss" );// 设置日期格式

                SimpleDateFormat df2      = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss:sss" );// 设置日期格式
                String           filetime = df.format( new Date() );

                logger.info( "【ReadHandlerThread】此次收到原始内容为：" + reciver );
                // 处理掉开头字符
                if( reciver.indexOf( "MSH" ) != -1 )
                {
                    String[] reciversp = reciver.split( "\\|" );
                    mshtypename = "_" + reciversp[9];
                    reciver     = reciver.substring( reciver.indexOf( "MSH" ) );
                }

                // 当识别到结束字符
                if( reciver.getBytes()[0] == 28 )
                {

                    long startTime = System.currentTimeMillis();
                    logger.info( "【ReadHandlerThread】收到结尾内容：" + reciver );
                    logger.info( "【ReadHandlerThread】收到结尾字符" + reciver.getBytes()[0] );
                    // input=input.replace("<0B>","").replace("<1C><0D>","");
                    logger.info( "【ReadHandlerThread】收到结尾内容为：" + reciver );
                    logger.info( "【ReadHandlerThread】收到的全部内容为：" + input );

                    text.append( "【" + df2.format( new Date() ) + "】【ReadHandlerThread】收到结尾内容为：" + reciver + "\n" );
                    text.append( "【" + df2.format( new Date() ) + "】【ReadHandlerThread】收到结尾字符" + reciver.getBytes()[0] + "\n" );
                    text.append( "【" + df2.format( new Date() ) + "】【ReadHandlerThread】收到的全部内容为：\n" + input + "\n" );
                    // 保存文件
                    boolean result = Save.save( "d:/runtime/hl7/files/" + filetime + mshtypename + "_" + i + ".txt", input );

                    if( result )
                    {
                        logger.info( "【ReadHandlerThread】文件保存为d:/runtime/hl7/files/" + filetime + mshtypename + "_" + i + ".txt" );
                        // String type = analysis.toXml( input, filetime + mshtypename + "_" + i + ".txt" );

                        String            type = analysis.readFile( "d:/runtime/hl7/files/" + filetime + mshtypename + "_" + i + ".txt" );
                        ArrayList<String> ack  = readConfig.CreateAck( "d:/runtime/hl7/typexml/" + type + "_" + filetime + mshtypename + "_" + i + ".txt.xml" );
                        filename = "d:/runtime/hl7/typexml/" + type + "_" + filetime + mshtypename + "_" + i + ".txt.xml";
                        DataOutputStream dos = null;
                        dos = new DataOutputStream( client.getOutputStream() );
                        // 对应ASCII码
                        dos.write( 11 ); // 0b VT (vertical tab) 垂直制表符

                        dos.write( ack.get( 0 ).getBytes() );
                        dos.write( 13 ); // 0d CR (carriage return) 回车键

                        dos.write( ack.get( 1 ).getBytes() );
                        dos.write( 13 );

                        dos.write( ack.get( 2 ).getBytes() );

                        dos.write( 28 ); // 1c FS (file separator) 文件分隔符
                        dos.write( 13 );
                        String hhcc = "\n";
                        text.append( "【" + df2.format( new Date() ) + "】【ReadHandlerThread】回复:\n" + ack.get( 0 ) + hhcc + ack.get( 1 ) + hhcc + ack.get( 2 ) + hhcc + "\n" );
                        text.append( "****************************************************************************************************************************************\n" );

                        logger.info( "【ReadHandlerThread】回复" + ack.get( 0 ) + hhcc + ack.get( 1 ) + hhcc + ack.get( 2 ) + hhcc );

                        long endTime = System.currentTimeMillis();
                        logger.info( "回复确认耗时： " + ( endTime - startTime ) + "ms" );

                        // text过多删除
                        if( text.getLineCount() > 10000 )
                        {

                            logger.info( "【ReadHandlerThread】JTextArea行数过多，自动置空" + text.getLineCount() );
                            text.setText( "" );
                        }
                        logger.info( "【ReadHandlerThread】新建线程处理文件" + filename );
                        text.append( "【" + df2.format( new Date() ) + "】【ReadHandlerThread】新建线程处理文件" + filename + "\n" );
                        new Thread( new WriteHandlerThread( client, text, filename ) ).start();

                    }
                    else
                    {
                        logger.error( "【ReadHandlerThread】【Error】保存消息为文本失败" );
                    }

                    input = "";
                }
                else
                {
                    text.append( "【" + df2.format( new Date() ) + "】【ReadHandlerThread】收到：" + reciver + "\n" );
                    input += reciver + "\n";
                }

            }

        }
        catch( Exception e )
        {
            logger.error( "【ReadHandlerThread】【Error】", e );
            e.printStackTrace();
        }
        finally
        {

            logger.info( "【ReadHandlerThread】准备输入、输出流关闭" );
            try
            {
                if( ps != null )
                {
                    ps.close();
                    br.close();
                    logger.info( "【ReadHandlerThread】输入、输出流关闭" );
                }
                else
                {
                    logger.info( "【ReadHandlerThread】输入、输出流不关闭" + ps.toString() );
                }
                if( client != null )
                {
                    client = null;
                }
            }
            catch( IOException e )
            {
                logger.error( "【ReadHandlerThread】【Error】", e );
                e.printStackTrace();
            }
        }
    }

}

/*
 * 处理写操作的线程
 */
class WriteHandlerThread implements Runnable
{

    private JTextArea text;

    private static Logger logger = Logger.getLogger( WriteHandlerThread.class.getName() );
    private String        filename;

    public WriteHandlerThread( Socket client, JTextArea text, String filename )
    {
        this.text     = text;
        this.filename = filename;
    }

    @Override
    public void run()
    {
        try
        {
            readXML.insertXMl( text, filename );
        }
        catch( Throwable e )
        {
            // TODO Auto-generated catch block
            logger.error( "【WriteHandlerThread】【Error】", e );
            Thread.currentThread().interrupt();
        }
    }

}

/*
 * 处理写操作的线程
 */
class TimerManagerThread implements Runnable
{

    private static Logger logger = Logger.getLogger( TimerManagerThread.class.getName() );

    public TimerManagerThread()
    {
    }

    @Override
    public void run()
    {
        logger.info( "开始删除计划" );
        new TimerManager();
    }

}
