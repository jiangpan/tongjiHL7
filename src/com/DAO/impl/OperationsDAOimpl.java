/**
 * 
 */
package com.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.DAO.IOperationsDAO;
import com.VO.OPERATIONS;;

/**
 * @author baobao
 *
 */
public class OperationsDAOimpl implements IOperationsDAO
{

    /**
     * 
     */

    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public OperationsDAOimpl( Connection conn )
    {
        // TODO Auto-generated constructor stub
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<OPERATIONS> operations ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean result = false;
        pstmt = conn.prepareStatement( " INSERT INTO HL7_OPERATIONS (MSGTYPE, MSGID, SAPPLYID, SAPPLYREASON, SAPPLYTIME, SDEPT, PATIENTID, PTYPE, "
                + "VISITID, OPERNO, OPERCODE, OPERNAME, OPERCLASS, OPERSTARTTIME, QUANTUM, QUANTUMUNIT, LOCATION, ISGRADE, OPERENDTIME, WOUNDGRADE, "
                + "NNIS, HEAL, OPERTYPE, EMBED, ENDOSCOPIC, BLOODOUT, BLOODIN, ANESTHESIAMETHOD, ASA, ROOM, TAICI, AIPNO, AIPSNO, AIPSNAME, AIPSCODE, AIPSTYPE,"
                + " SURGEON,SURGEONCODE,FIRSTAS,FIRSTASCODE,ANESTHESIA,ANESTHESIACODE, LASTMODIFYTIME) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'))   " );

        for( int i = 0; i < operations.size(); i++ )
        {
            pstmt.setString( 1, ( (OPERATIONS) operations.get( i ) ).getMSGTYPE() );
            pstmt.setString( 2, ( (OPERATIONS) operations.get( i ) ).getMSGID() );
            pstmt.setString( 3, ( (OPERATIONS) operations.get( i ) ).getSAPPLYID() );
            pstmt.setString( 4, ( (OPERATIONS) operations.get( i ) ).getSAPPLYREASON() );
            pstmt.setString( 5, ( (OPERATIONS) operations.get( i ) ).getSAPPLYTIME() );
            pstmt.setString( 6, ( (OPERATIONS) operations.get( i ) ).getSDEPT() );
            pstmt.setString( 7, ( (OPERATIONS) operations.get( i ) ).getPATIENTID() );
            pstmt.setString( 8, ( (OPERATIONS) operations.get( i ) ).getPTYPE() );
            pstmt.setString( 9, ( (OPERATIONS) operations.get( i ) ).getVISITID() );
            pstmt.setString( 10, ( (OPERATIONS) operations.get( i ) ).getOPERNO() );
            pstmt.setString( 11, ( (OPERATIONS) operations.get( i ) ).getOPERCODE() );
            pstmt.setString( 12, ( (OPERATIONS) operations.get( i ) ).getOPERNAME() );
            pstmt.setString( 13, ( (OPERATIONS) operations.get( i ) ).getOPERCLASS() );
            pstmt.setString( 14, ( (OPERATIONS) operations.get( i ) ).getOPERSTARTTIME() );
            pstmt.setString( 15, ( (OPERATIONS) operations.get( i ) ).getQUANTUM() );
            pstmt.setString( 16, ( (OPERATIONS) operations.get( i ) ).getQUANTUMUNIT() );
            pstmt.setString( 17, ( (OPERATIONS) operations.get( i ) ).getLOCATION() );
            pstmt.setString( 18, ( (OPERATIONS) operations.get( i ) ).getISGRADE() );
            pstmt.setString( 19, ( (OPERATIONS) operations.get( i ) ).getOPERENDTIME() );
            pstmt.setString( 20, ( (OPERATIONS) operations.get( i ) ).getWOUNDGRADE() );
            pstmt.setString( 21, ( (OPERATIONS) operations.get( i ) ).getNNIS() );
            pstmt.setString( 22, ( (OPERATIONS) operations.get( i ) ).getHEAL() );
            pstmt.setString( 23, ( (OPERATIONS) operations.get( i ) ).getOPERTYPE() );
            pstmt.setString( 24, ( (OPERATIONS) operations.get( i ) ).getEMBED() );
            pstmt.setString( 25, ( (OPERATIONS) operations.get( i ) ).getENDOSCOPIC() );
            pstmt.setString( 26, ( (OPERATIONS) operations.get( i ) ).getBLOODOUT() );
            pstmt.setString( 27, ( (OPERATIONS) operations.get( i ) ).getBLOODIN() );
            pstmt.setString( 28, ( (OPERATIONS) operations.get( i ) ).getANESTHESIAMETHOD() );
            pstmt.setString( 29, ( (OPERATIONS) operations.get( i ) ).getASA() );
            pstmt.setString( 30, ( (OPERATIONS) operations.get( i ) ).getROOM() );
            pstmt.setString( 31, ( (OPERATIONS) operations.get( i ) ).getTAICI() );
            pstmt.setString( 32, ( (OPERATIONS) operations.get( i ) ).getAIPNO() );
            pstmt.setString( 33, ( (OPERATIONS) operations.get( i ) ).getAIPSNO() );
            pstmt.setString( 34, ( (OPERATIONS) operations.get( i ) ).getAIPSNAME() );
            pstmt.setString( 35, ( (OPERATIONS) operations.get( i ) ).getAIPSCODE() );
            pstmt.setString( 36, ( (OPERATIONS) operations.get( i ) ).getAIPSTYPE() );

            pstmt.setString( 37, ( (OPERATIONS) operations.get( i ) ).getSURGEON() );
            pstmt.setString( 38, ( (OPERATIONS) operations.get( i ) ).getSURGEONCODE() );
            pstmt.setString( 39, ( (OPERATIONS) operations.get( i ) ).getFIRSTAS() );
            pstmt.setString( 40, ( (OPERATIONS) operations.get( i ) ).getFIRSTASCODE() );
            pstmt.setString( 41, ( (OPERATIONS) operations.get( i ) ).getANESTHESIA() );
            pstmt.setString( 42, ( (OPERATIONS) operations.get( i ) ).getANESTHESIACODE() );
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
