package com.xinglin.hl7.tongji.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.xinglin.hl7.tongji.dao.IDiagnosisDAO;
import com.xinglin.hl7.tongji.vo.Diagnosis;

public class DiagnosisDAOimpl implements IDiagnosisDAO
{
    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public DiagnosisDAOimpl( Connection conn )
    {
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<Diagnosis> diagnosis ) throws Throwable
    {
        boolean result = false;

        pstmt = conn.prepareStatement( "INSERT INTO HL7_DIAGNOSIS (MSGTYPE, MSGID, PNAME, PATIENT_ID, VISIT_ID, DIAGNOSIS_NO, DIAGNOSIS_TYPE, "
                + "DIAGNOSIS_TYPE2, DIAGNOSIS_DESC, DIAGNOSIS_CODE, DIAGNOSIS_DATE, LASTMODIFYTIME) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'))   " );

        for( int i = 0; i < diagnosis.size(); i++ )
        {

            pstmt.setString( 1, ( (Diagnosis) diagnosis.get( i ) ).getMsgType() );
            pstmt.setString( 2, ( (Diagnosis) diagnosis.get( i ) ).getMsgId() );
            pstmt.setString( 3, ( (Diagnosis) diagnosis.get( i ) ).getPName() );
            pstmt.setString( 4, ( (Diagnosis) diagnosis.get( i ) ).getPatientid() );
            pstmt.setString( 5, ( (Diagnosis) diagnosis.get( i ) ).getVisitid() );
            pstmt.setString( 6, ( (Diagnosis) diagnosis.get( i ) ).getDiagnosisNo() );
            pstmt.setString( 7, ( (Diagnosis) diagnosis.get( i ) ).getDiagnosisType() );
            pstmt.setString( 8, ( (Diagnosis) diagnosis.get( i ) ).getDiagnosisType2() );
            pstmt.setString( 9, ( (Diagnosis) diagnosis.get( i ) ).getDiagnosisDesc() );
            pstmt.setString( 10, ( (Diagnosis) diagnosis.get( i ) ).getDiagnosisCode() );
            pstmt.setString( 11, ( (Diagnosis) diagnosis.get( i ) ).getDiagnosisDate() );
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