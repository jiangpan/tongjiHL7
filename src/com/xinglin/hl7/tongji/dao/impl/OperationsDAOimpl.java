package com.xinglin.hl7.tongji.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.xinglin.hl7.tongji.dao.IOperationsDAO;
import com.xinglin.hl7.tongji.vo.Operation;;

public class OperationsDAOimpl implements IOperationsDAO
{
    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public OperationsDAOimpl( Connection conn )
    {
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<Operation> operations ) throws Throwable
    {
        boolean result = false;
        pstmt = conn.prepareStatement( " INSERT INTO HL7_OPERATIONS (MSGTYPE, MSGID, SAPPLYID, SAPPLYREASON, SAPPLYTIME, SDEPT, PATIENTID, PTYPE, "
                + "VISITID, OPERNO, OPERCODE, OPERNAME, OPERCLASS, OPERSTARTTIME, QUANTUM, QUANTUMUNIT, LOCATION, ISGRADE, OPERENDTIME, WOUNDGRADE, "
                + "NNIS, HEAL, OPERTYPE, EMBED, ENDOSCOPIC, BLOODOUT, BLOODIN, ANESTHESIAMETHOD, ASA, ROOM, TAICI, AIPNO, AIPSNO, AIPSNAME, AIPSCODE, AIPSTYPE,"
                + " SURGEON,SURGEONCODE,FIRSTAS,FIRSTASCODE,ANESTHESIA,ANESTHESIACODE, LASTMODIFYTIME) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'))   " );

        for( int i = 0; i < operations.size(); i++ )
        {
            pstmt.setString( 1, ( (Operation) operations.get( i ) ).getMsgType() );
            pstmt.setString( 2, ( (Operation) operations.get( i ) ).getMsgId() );
            pstmt.setString( 3, ( (Operation) operations.get( i ) ).getSapplyId() );
            pstmt.setString( 4, ( (Operation) operations.get( i ) ).getSapplyReason() );
            pstmt.setString( 5, ( (Operation) operations.get( i ) ).getSapplyTime() );
            pstmt.setString( 6, ( (Operation) operations.get( i ) ).getSDept() );
            pstmt.setString( 7, ( (Operation) operations.get( i ) ).getPatientid() );
            pstmt.setString( 8, ( (Operation) operations.get( i ) ).getPType() );
            pstmt.setString( 9, ( (Operation) operations.get( i ) ).getVisitid() );
            pstmt.setString( 10, ( (Operation) operations.get( i ) ).getOperNo() );
            pstmt.setString( 11, ( (Operation) operations.get( i ) ).getOperCode() );
            pstmt.setString( 12, ( (Operation) operations.get( i ) ).getOperName() );
            pstmt.setString( 13, ( (Operation) operations.get( i ) ).getOperClass() );
            pstmt.setString( 14, ( (Operation) operations.get( i ) ).getOperStarttime() );
            pstmt.setString( 15, ( (Operation) operations.get( i ) ).getQuantum() );
            pstmt.setString( 16, ( (Operation) operations.get( i ) ).getQuantumUnit() );
            pstmt.setString( 17, ( (Operation) operations.get( i ) ).getLocation() );
            pstmt.setString( 18, ( (Operation) operations.get( i ) ).getGrade() );
            pstmt.setString( 19, ( (Operation) operations.get( i ) ).getOperEndtime() );
            pstmt.setString( 20, ( (Operation) operations.get( i ) ).getWoundGrade() );
            pstmt.setString( 21, ( (Operation) operations.get( i ) ).getNnis() );
            pstmt.setString( 22, ( (Operation) operations.get( i ) ).getHeal() );
            pstmt.setString( 23, ( (Operation) operations.get( i ) ).getOperType() );
            pstmt.setString( 24, ( (Operation) operations.get( i ) ).getEmbed() );
            pstmt.setString( 25, ( (Operation) operations.get( i ) ).getEndoscopic() );
            pstmt.setString( 26, ( (Operation) operations.get( i ) ).getBloodout() );
            pstmt.setString( 27, ( (Operation) operations.get( i ) ).getBloodin() );
            pstmt.setString( 28, ( (Operation) operations.get( i ) ).getAnesthesiaMethod() );
            pstmt.setString( 29, ( (Operation) operations.get( i ) ).getAsa() );
            pstmt.setString( 30, ( (Operation) operations.get( i ) ).getRoom() );
            pstmt.setString( 31, ( (Operation) operations.get( i ) ).getTableNo() );
            pstmt.setString( 32, ( (Operation) operations.get( i ) ).getAipNo() );
            pstmt.setString( 33, ( (Operation) operations.get( i ) ).getAipsNo() );
            pstmt.setString( 34, ( (Operation) operations.get( i ) ).getAipsName() );
            pstmt.setString( 35, ( (Operation) operations.get( i ) ).getAipsCode() );
            pstmt.setString( 36, ( (Operation) operations.get( i ) ).getAipsType() );
            pstmt.setString( 37, ( (Operation) operations.get( i ) ).getSurgeon() );
            pstmt.setString( 38, ( (Operation) operations.get( i ) ).getSurgeonCode() );
            pstmt.setString( 39, ( (Operation) operations.get( i ) ).getFirstAs() );
            pstmt.setString( 40, ( (Operation) operations.get( i ) ).getFirstAsCode() );
            pstmt.setString( 41, ( (Operation) operations.get( i ) ).getAnesthesia() );
            pstmt.setString( 42, ( (Operation) operations.get( i ) ).getAnesthesiaCode() );
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