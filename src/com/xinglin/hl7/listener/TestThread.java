package com.xinglin.hl7.listener;

import java.util.concurrent.atomic.AtomicInteger;

public class TestThread extends Thread
{
    private static final AtomicInteger count = new AtomicInteger();

    /*
     * public static void main(String[] args) {
     * (new TestThread()).start();
     * }
     */
    @Override
    public void run()
    {
        System.out.println( count.incrementAndGet() );
        while( true )
            try
            {
                Thread.sleep( 100000 );
            }
            catch( InterruptedException e )
            {
                break;
            }
    }

    public static void main( String[] args )
    {
        Runtime.getRuntime().addShutdownHook( new Thread(){
            public void run()
            {
                new HL7_listener().init();
            }
        } );
        System.exit( 0 );
    }
}