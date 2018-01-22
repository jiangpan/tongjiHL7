/**
 * 
 */
package com.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.DAO.ILisreportDAO;
import com.VO.LISREPORT;;

/**
 * @author baobao
 *
 */
public class LisreportDAOimpl implements ILisreportDAO
{

    /**
     * 
     */
    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public LisreportDAOimpl( Connection conn )
    {
        // TODO Auto-generated constructor stub
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<LISREPORT> temp ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean result = false;

        pstmt = conn.prepareStatement( " INSERT INTO HL7_LISREPORT (MSGTYPE, MSGID, PATIENTID, IDNO, PNAME, VISITD, PDEPT, PWARD, "
                + "PBEDNO, ORCID, ORCUNIT, ORCTYPE, OBRNO, REQNO, REPNO, OBRNAME, REPTIME, OBRSTATUS, OBRREPNAME, OBXNO, OBXTYPE,"
                + " OBXNAME, OBXNAMEID, OBXRESULT, OBXRANGE, OBXUNIT, OBXFLAG, OBXMETHOD,REQTIME,OBXNAMECODE,SPECIMEN,rectime, LASTMODIFYTIME)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'))   " );

        for( int i = 0; i < temp.size(); i++ )
        {
            pstmt.setString( 1, ( (LISREPORT) temp.get( i ) ).getMSGTYPE() );// MSH.9
            pstmt.setString( 2, ( (LISREPORT) temp.get( i ) ).getMSGID() );// MSH.1
            pstmt.setString( 3, ( (LISREPORT) temp.get( i ) ).getPATIENTID() );// PID.2
            pstmt.setString( 4, ( (LISREPORT) temp.get( i ) ).getIDNO() );// PID.3.1
            pstmt.setString( 5, ( (LISREPORT) temp.get( i ) ).getPNAME() );// PID.5
            pstmt.setString( 6, ( (LISREPORT) temp.get( i ) ).getVISITD() );// PV1.19
            pstmt.setString( 7, ( (LISREPORT) temp.get( i ) ).getPDEPT() );// PV1.3.1
            pstmt.setString( 8, ( (LISREPORT) temp.get( i ) ).getPWARD() );// PV1.3.2
            pstmt.setString( 9, ( (LISREPORT) temp.get( i ) ).getPBEDNO() );// PV1.3.3
            pstmt.setString( 10, ( (LISREPORT) temp.get( i ) ).getORCID() );// ORC.1
            pstmt.setString( 11, ( (LISREPORT) temp.get( i ) ).getORCUNIT() );// ORC.16
            pstmt.setString( 12, ( (LISREPORT) temp.get( i ) ).getORCTYPE() );// ORC.29
            pstmt.setString( 13, ( (LISREPORT) temp.get( i ) ).getOBRNO() );// OBR.1
            pstmt.setString( 14, ( (LISREPORT) temp.get( i ) ).getREQNO() );// OBR.2
            pstmt.setString( 15, ( (LISREPORT) temp.get( i ) ).getREPNO() );// OBR.3
            pstmt.setString( 16, ( (LISREPORT) temp.get( i ) ).getOBRNAME() );// OBR.4
            pstmt.setString( 17, ( (LISREPORT) temp.get( i ) ).getREPTIME() );// OBR.22
            pstmt.setString( 18, ( (LISREPORT) temp.get( i ) ).getOBRSTATUS() );// OBR.25
            pstmt.setString( 19, ( (LISREPORT) temp.get( i ) ).getOBRREPNAME() );// OBR.47.2
            pstmt.setString( 20, ( (LISREPORT) temp.get( i ) ).getOBXNO() );// OBX.1
            pstmt.setString( 21, ( (LISREPORT) temp.get( i ) ).getOBXTYPE() );// OBX.2
            pstmt.setString( 22, ( (LISREPORT) temp.get( i ) ).getOBXNAME() );// OBX.3
            pstmt.setString( 23, ( (LISREPORT) temp.get( i ) ).getOBXNAMEID() );// OBX.4
            pstmt.setString( 24, ( (LISREPORT) temp.get( i ) ).getOBXRESULT() );// OBX.5
            pstmt.setString( 25, ( (LISREPORT) temp.get( i ) ).getOBXRANGE() );// OBX.7
            pstmt.setString( 26, ( (LISREPORT) temp.get( i ) ).getOBXUNIT() );// OBX.8
            pstmt.setString( 27, ( (LISREPORT) temp.get( i ) ).getOBXFLAG() );// OBX.11
            pstmt.setString( 28, ( (LISREPORT) temp.get( i ) ).getOBXMETHOD() );// OBX.17

            pstmt.setString( 29, ( (LISREPORT) temp.get( i ) ).getREQTIME() );// OBX.17
            pstmt.setString( 30, ( (LISREPORT) temp.get( i ) ).getOBXNAMECODE() );// OBX.3.2
            pstmt.setString( 31, ( (LISREPORT) temp.get( i ) ).getSPECIMEN() );// OBr.15
            pstmt.setString( 32, ( (LISREPORT) temp.get( i ) ).getRectime() );// OBr.14
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
