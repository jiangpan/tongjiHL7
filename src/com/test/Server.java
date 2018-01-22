/**
 * 
 */
package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author baobao
 *
 */
public class Server
{
    static BufferedReader br;   // 服务器端的输入流
    static PrintStream    ps;   // 服务器端的输出流
    static JTextArea      text; // 服务器相关的界面组件

    public Server()
    {
        JFrame frame = new JFrame( "服务器端" );
        text = new JTextArea();
        JScrollPane scroll = new JScrollPane( text );
        frame.add( scroll );
        frame.setVisible( true );
        frame.setSize( 300, 400 );
        text.setEditable( false );
    }

    public static void main( String[] args ) throws Exception
    {
        new Server(); // 生成服务器界面
        // 通过服务器端构造函数 ServerSocket(port) 实例化一个服务器端口
        ServerSocket server = new ServerSocket( 2000 );
        text.append( "监听2000端口" + "\n" );
        Socket client = server.accept();
        br = new BufferedReader( new InputStreamReader( client.getInputStream() ) );
        ps = new PrintStream( client.getOutputStream() );
        String msg;
        // 如果输入流不为空,将接受到的信息打印到相应的文本框中并反馈回收到的信息
        while( ( msg = br.readLine() ) != null )
        {
            text.append( "服务器端收到：" + msg + "\n" );
            ps.println( msg );
            if( msg.equals( "quit" ) )
            {
                text.append( "客户端“2000”已退出！" + "\n" );
                text.append( "服务器程序将退出！" );
                break;
            }
        }
        ps.close();
        br.close();
        client.close();
    }
}
