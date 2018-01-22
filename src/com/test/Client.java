package com.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client implements ActionListener
{
    // 这里有两个图形界面，一个是连接的frame,另一个和服务器通信的界面frame1
    private JFrame frame;
    private JLabel adress;
    private JLabel port;
    JTextField     adresstext;
    JTextField     porttext;
    JButton        connect;

    private JFrame   frame1;
    private JLabel   shuru;
    private JPanel   panel1;
    private JPanel   panel2;
    private JLabel   jieshou;
    JButton          send;
    static JTextArea shurukuang;
    static TextArea  jieshoukuang;

    static BufferedReader br1;   // 从服务端接受的数据流
    static PrintStream    ps;    // 从客户端输出的数据流
    static BufferedReader br2;   // 从通信界面中的输入框接受的数据流
    static Socket         client;
    // 将输入框字符串转换为字符串流所需的字符串的输入流
    static ByteArrayInputStream stringInputStream;

    public Client()
    {
        frame = new JFrame();
        adress = new JLabel( "IP 地址" );
        port = new JLabel( "端口号" );
        adresstext = new JTextField( "127.0.0.1", 10 );
        porttext = new JTextField( "2000", 10 );
        connect = new JButton( "连接" );
        // 连接界面的布局
        frame.setLayout( new FlowLayout() );
        frame.add( adress );
        frame.add( adresstext );
        frame.add( port );
        frame.add( porttext );
        frame.add( connect );
        frame.setVisible( true );
        frame.setSize( 200, 150 );
        connect.addActionListener( this );
        // 通信界面的实例化
        frame1 = new JFrame();
        shuru = new JLabel( "请输入" );
        shurukuang = new JTextArea( "请输入····", 5, 40 );

        panel1 = new JPanel();
        panel1.add( shuru );
        panel1.add( shurukuang );
        panel1.setLayout( new FlowLayout() );

        send = new JButton( "发送" );
        panel2 = new JPanel();
        jieshou = new JLabel( "已接受" );

        jieshoukuang = new TextArea( 8, 60 );
        jieshoukuang.setEditable( false );

        panel2.add( jieshou );
        panel2.add( jieshoukuang );
        panel2.setLayout( new FlowLayout() );
        frame1.setLayout( new FlowLayout() );
        // 通信界面都的布局
        frame1.add( BorderLayout.NORTH, panel1 );
        frame1.add( send );
        frame1.add( BorderLayout.SOUTH, panel2 );
        // 连接时通信界面是处于看不到的
        frame1.setVisible( false );
        frame1.setSize( 500, 350 );
        send.addActionListener( this );
    }

    // 两个界面当中都有相应的按钮时间，为相应的时间添加动作
    public void actionPerformed( ActionEvent e )
    {
        if( e.getSource() == connect )
        {
            try
            {
                // 当触发连接按钮时，实例化一个客户端
                client = new Socket( "127.0.0.1", 2000 );
                // 隐藏连接界面，显示通信界面
                frame.setVisible( false );
                frame1.setVisible( true );
                jieshoukuang.append( "已经连接上服务器！" + "\n" );
            }
            catch( IOException e1 )
            {
                System.out.println( "链接失败！" );
                e1.printStackTrace();
            }
        }
        // 通信界面中的发送按钮相应的时间处理
        if( e.getSource() == send )
        {
            // 将输入框中的字符串转换为字符串流
            stringInputStream = new ByteArrayInputStream( ( shurukuang.getText() ).getBytes() );
            br2 = new BufferedReader( new InputStreamReader( stringInputStream ) );
            String msg;
            try
            {
                while( ( msg = br2.readLine() ) != null )
                {
                    ps.println( msg ); // 将输入框中的内容发送给服务器端
                    jieshoukuang.append( "向服务器发送：" + msg + "\n" );
                    jieshoukuang.append( "客户端接受相应:" + br1.readLine() + "\n" );
                    if( msg.equals( "quit" ) )
                    {
                        jieshoukuang.append( "客户端将退出!" );
                        br1.close();
                        ps.close();
                        client.close();
                        frame1.setVisible( false );
                        break;
                    }
                }
            }
            catch( IOException e2 )
            {
                System.out.println( "读输入框数据出错！" );
            }
            shurukuang.setText( "" );
        }
    }

    public static void main( String[] args ) throws IOException
    {
        new Client(); // 实例化连接界面
        client = new Socket( "127.0.0.1", 2000 );
        br1 = new BufferedReader( new InputStreamReader( client.getInputStream() ) ); // 从服务端接受的数据
        ps = new PrintStream( client.getOutputStream() ); // 从客户端输出的数据
    }
}