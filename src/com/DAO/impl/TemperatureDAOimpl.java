/**
 * 
 */
package com.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.DAO.ITemperatureDAO;
import com.VO.TEMPERATURE;

/**
 * @author baobao
 *
 */
public class TemperatureDAOimpl implements ITemperatureDAO
{

    /**
     * 
     */

    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public TemperatureDAOimpl( Connection conn )
    {
        // TODO Auto-generated constructor stub
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<TEMPERATURE> temp ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean result = false;
        pstmt = conn.prepareStatement( " INSERT INTO HL7_OBX (MSGTYPE, MSGID, PATIENTID, IDNO, PNAME, VISITD, PDEPT, PWARD, PBEDNO, ORCID, "
                + "ORCTYPE, OBRNO, OBRNAME, OBXNO, OBXTYPE, OBXNAME, OBXRESULT, OBXUNIT, OBXFLAG, OBXTIME, LASTMODIFYTIME) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'))   " );

        for( int i = 0; i < temp.size(); i++ )
        {
            pstmt.setString( 1, ( (TEMPERATURE) temp.get( i ) ).getMSGTYPE() );
            pstmt.setString( 2, ( (TEMPERATURE) temp.get( i ) ).getMSGID() );
            pstmt.setString( 3, ( (TEMPERATURE) temp.get( i ) ).getPATIENTID() );
            pstmt.setString( 4, ( (TEMPERATURE) temp.get( i ) ).getIDNO() );
            pstmt.setString( 5, ( (TEMPERATURE) temp.get( i ) ).getPNAME() );
            pstmt.setString( 6, ( (TEMPERATURE) temp.get( i ) ).getVISITD() );
            pstmt.setString( 7, ( (TEMPERATURE) temp.get( i ) ).getPDEPT() );
            pstmt.setString( 8, ( (TEMPERATURE) temp.get( i ) ).getPWARD() );
            pstmt.setString( 9, ( (TEMPERATURE) temp.get( i ) ).getPBEDNO() );
            pstmt.setString( 10, ( (TEMPERATURE) temp.get( i ) ).getORCID() );
            pstmt.setString( 11, ( (TEMPERATURE) temp.get( i ) ).getORCTYPE() );
            pstmt.setString( 12, ( (TEMPERATURE) temp.get( i ) ).getOBRNO() );
            pstmt.setString( 13, ( (TEMPERATURE) temp.get( i ) ).getOBRNAME() );
            pstmt.setString( 14, ( (TEMPERATURE) temp.get( i ) ).getOBXNO() );
            pstmt.setString( 15, ( (TEMPERATURE) temp.get( i ) ).getOBXTYPE() );
            pstmt.setString( 16, ( (TEMPERATURE) temp.get( i ) ).getOBXNAME() );
            pstmt.setString( 17, ( (TEMPERATURE) temp.get( i ) ).getOBXRESULT() );
            pstmt.setString( 18, ( (TEMPERATURE) temp.get( i ) ).getOBXUNIT() );
            pstmt.setString( 19, ( (TEMPERATURE) temp.get( i ) ).getOBXFLAG() );
            pstmt.setString( 20, ( (TEMPERATURE) temp.get( i ) ).getOBXTIME() );
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
