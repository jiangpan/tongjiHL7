/**
 * 
 */
package com.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.DAO.IXrayDAO;
import com.VO.XRAY;

/**
 * @author baobao
 *
 */
public class XrayDAOimpl implements IXrayDAO
{

    /**
     * 
     */

    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public XrayDAOimpl( Connection conn )
    {
        // TODO Auto-generated constructor stub
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<XRAY> xray ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean result = false;
        pstmt = conn.prepareStatement( " INSERT INTO HL7_XRAY (MSGTYPE, MSGID, PATIENTID, IDNO, PNAME, VISITD, PDEPT, PWARD, PBEDNO, ORCID,"
                + " ORCNO, ORCTYPE, OBRNO, REPNO, OBRNAME, REPTIME, OBRTYPE, OBRSTATUS, OBRREPNAME, OBXNO, OBXTYPE, OBXNAME, "
                + "OBXRESULT1, OBXRESULT2, OBXUNIT, OBXFLAG, OBXMETHOD, LASTMODIFYTIME) "
                + "  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss')) " );

        for( int i = 0; i < xray.size(); i++ )
        {
            pstmt.setString( 1, ( (XRAY) xray.get( i ) ).getMSGTYPE() );
            pstmt.setString( 2, ( (XRAY) xray.get( i ) ).getMSGID() );
            pstmt.setString( 3, ( (XRAY) xray.get( i ) ).getPATIENTID() );
            pstmt.setString( 4, ( (XRAY) xray.get( i ) ).getIDNO() );
            pstmt.setString( 5, ( (XRAY) xray.get( i ) ).getPNAME() );
            pstmt.setString( 6, ( (XRAY) xray.get( i ) ).getVISITD() );
            pstmt.setString( 7, ( (XRAY) xray.get( i ) ).getPDEPT() );
            pstmt.setString( 8, ( (XRAY) xray.get( i ) ).getPWARD() );
            pstmt.setString( 9, ( (XRAY) xray.get( i ) ).getPBEDNO() );
            pstmt.setString( 10, ( (XRAY) xray.get( i ) ).getORCID() );
            pstmt.setString( 11, ( (XRAY) xray.get( i ) ).getORCNO() );
            pstmt.setString( 12, ( (XRAY) xray.get( i ) ).getORCTYPE() );
            pstmt.setString( 13, ( (XRAY) xray.get( i ) ).getOBRNO() );
            pstmt.setString( 14, ( (XRAY) xray.get( i ) ).getREPNO() );
            pstmt.setString( 15, ( (XRAY) xray.get( i ) ).getOBRNAME() );
            pstmt.setString( 16, ( (XRAY) xray.get( i ) ).getREPTIME() );
            pstmt.setString( 17, ( (XRAY) xray.get( i ) ).getOBRTYPE() );
            pstmt.setString( 18, ( (XRAY) xray.get( i ) ).getOBRSTATUS() );
            pstmt.setString( 19, ( (XRAY) xray.get( i ) ).getOBRREPNAME() );
            pstmt.setString( 20, ( (XRAY) xray.get( i ) ).getOBXNO() );
            pstmt.setString( 21, ( (XRAY) xray.get( i ) ).getOBXTYPE() );
            pstmt.setString( 22, ( (XRAY) xray.get( i ) ).getOBXNAME() );
            pstmt.setString( 23, ( (XRAY) xray.get( i ) ).getOBXRESULT1() );
            pstmt.setString( 24, ( (XRAY) xray.get( i ) ).getOBXRESULT2() );
            pstmt.setString( 25, ( (XRAY) xray.get( i ) ).getOBXUNIT() );
            pstmt.setString( 26, ( (XRAY) xray.get( i ) ).getOBXFLAG() );
            pstmt.setString( 27, ( (XRAY) xray.get( i ) ).getOBXMETHOD() );
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
