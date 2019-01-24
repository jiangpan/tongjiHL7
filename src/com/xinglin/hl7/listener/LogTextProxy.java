package com.xinglin.hl7.listener;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.xinglin.hl7.analysis.analysisXML.readConfig;

public class LogTextProxy
{
    private boolean detail;
    private boolean swing;

    public LogTextProxy()
    {
        this.detail = "true".equals( readConfig.getConfigMap() == null ? null : readConfig.getConfigMap().get( "detail" ) );
        this.swing  = "true".equals( readConfig.getConfigMap() == null ? null : readConfig.getConfigMap().get( "swing" ) );
    }

    public void log( Logger logger, String content )
    {
        if( detail )
        {
            logger.info( content );
        }
    }

    public void text( JTextArea text, String content )
    {
        if( swing )
        {
            text.append( content );
        }
    }
}
