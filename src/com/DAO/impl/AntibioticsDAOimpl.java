/**
 * 
 */
package com.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.DAO.IAntibioticsDAO;
import com.VO.ANTIBIOTICS;

/**
 * @author baobao
 *
 */
public class AntibioticsDAOimpl implements IAntibioticsDAO
{

    /**
     * 
     */

    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public AntibioticsDAOimpl( Connection conn )
    {
        // TODO Auto-generated constructor stub
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<ANTIBIOTICS> antibiotics ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean result = false;

        pstmt = conn.prepareStatement( " INSERT INTO HL7_ANTIBIOTICS (MSGTYPE, MSGID, PATIENTID, IDNO, PNAME, VISITD, PDEPT,"
                + " PWARD, PBEDNO, STATUSID, ORDERNO, STATUS, ORDERTIME, ORDERDOCTOR, ORDERTYPE, TQNO, FREQUENCY, FORTIME, "
                + "STARTTIME, ENDTIME, TQTYPE, TQCONT, ORDERTEXT, DOSAGE, DOSAGEUNITS, DOSAGETYPE, REMARK, ROOM, "
                + "ADMINISTRATION, USE_TIME,GOAL,ANTITYPECODE,ANTITYPENAME, LASTMODIFYTIME) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + "to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'))" );

        for( int i = 0; i < antibiotics.size(); i++ )
        {
            pstmt.setString( 1, ( (ANTIBIOTICS) antibiotics.get( i ) ).getMSGTYPE() );
            pstmt.setString( 2, ( (ANTIBIOTICS) antibiotics.get( i ) ).getMSGID() );
            pstmt.setString( 3, ( (ANTIBIOTICS) antibiotics.get( i ) ).getPATIENTID() );
            pstmt.setString( 4, ( (ANTIBIOTICS) antibiotics.get( i ) ).getIDNO() );
            pstmt.setString( 5, ( (ANTIBIOTICS) antibiotics.get( i ) ).getPNAME() );
            pstmt.setString( 6, ( (ANTIBIOTICS) antibiotics.get( i ) ).getVISITD() );
            pstmt.setString( 7, ( (ANTIBIOTICS) antibiotics.get( i ) ).getPDEPT() );
            pstmt.setString( 8, ( (ANTIBIOTICS) antibiotics.get( i ) ).getPWARD() );
            pstmt.setString( 9, ( (ANTIBIOTICS) antibiotics.get( i ) ).getPBEDNO() );
            pstmt.setString( 10, ( (ANTIBIOTICS) antibiotics.get( i ) ).getSTATUSID() );
            pstmt.setString( 11, ( (ANTIBIOTICS) antibiotics.get( i ) ).getORDERNO() );
            pstmt.setString( 12, ( (ANTIBIOTICS) antibiotics.get( i ) ).getSTATUS() );
            pstmt.setString( 13, ( (ANTIBIOTICS) antibiotics.get( i ) ).getORDERTIME() );
            pstmt.setString( 14, ( (ANTIBIOTICS) antibiotics.get( i ) ).getORDERDOCTOR() );
            pstmt.setString( 15, ( (ANTIBIOTICS) antibiotics.get( i ) ).getORDERTYPE() );
            pstmt.setString( 16, ( (ANTIBIOTICS) antibiotics.get( i ) ).getTQNO() );
            pstmt.setString( 17, ( (ANTIBIOTICS) antibiotics.get( i ) ).getFREQUENCY() );
            pstmt.setString( 18, ( (ANTIBIOTICS) antibiotics.get( i ) ).getFORTIME() );
            pstmt.setString( 19, ( (ANTIBIOTICS) antibiotics.get( i ) ).getSTARTTIME() );
            pstmt.setString( 20, ( (ANTIBIOTICS) antibiotics.get( i ) ).getENDTIME() );
            pstmt.setString( 21, ( (ANTIBIOTICS) antibiotics.get( i ) ).getTQTYPE() );
            pstmt.setString( 22, ( (ANTIBIOTICS) antibiotics.get( i ) ).getTQCONT() );
            pstmt.setString( 23, ( (ANTIBIOTICS) antibiotics.get( i ) ).getORDERTEXT() );
            pstmt.setString( 24, ( (ANTIBIOTICS) antibiotics.get( i ) ).getDOSAGE() );
            pstmt.setString( 25, ( (ANTIBIOTICS) antibiotics.get( i ) ).getDOSAGEUNITS() );
            pstmt.setString( 26, ( (ANTIBIOTICS) antibiotics.get( i ) ).getDOSAGETYPE() );
            pstmt.setString( 27, ( (ANTIBIOTICS) antibiotics.get( i ) ).getREMARK() );
            pstmt.setString( 28, ( (ANTIBIOTICS) antibiotics.get( i ) ).getROOM() );
            pstmt.setString( 29, ( (ANTIBIOTICS) antibiotics.get( i ) ).getADMINISTRATION() );
            pstmt.setString( 30, ( (ANTIBIOTICS) antibiotics.get( i ) ).getUSE_TIME() );
            pstmt.setString( 31, ( (ANTIBIOTICS) antibiotics.get( i ) ).getGOAL() );
            pstmt.setString( 32, ( (ANTIBIOTICS) antibiotics.get( i ) ).getANTITYPECODE() );
            pstmt.setString( 33, ( (ANTIBIOTICS) antibiotics.get( i ) ).getANTITYPENAME() );

            pstmt.addBatch();
        }
        int[] inserts = pstmt.executeBatch();
        for( int insert : inserts )
        {
            if( insert == -2 )
            {
                result = true;
            }
        }

        return result;
    }

}
