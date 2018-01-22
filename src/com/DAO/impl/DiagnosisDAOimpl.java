/**
 * 
 */
package com.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.DAO.IDiagnosisDAO;
import com.VO.DIAGNOSIS;

/**
 * @author baobao
 *
 */
public class DiagnosisDAOimpl implements IDiagnosisDAO
{

    /**
     * 
     */

    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public DiagnosisDAOimpl( Connection conn )
    {
        // TODO Auto-generated constructor stub
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<DIAGNOSIS> diagnosis ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean result = false;

        pstmt = conn.prepareStatement( "INSERT INTO HL7_DIAGNOSIS (MSGTYPE, MSGID, PNAME, PATIENT_ID, VISIT_ID, DIAGNOSIS_NO, DIAGNOSIS_TYPE, "
                + "DIAGNOSIS_TYPE2, DIAGNOSIS_DESC, DIAGNOSIS_CODE, DIAGNOSIS_DATE, LASTMODIFYTIME) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'))   " );

        for( int i = 0; i < diagnosis.size(); i++ )
        {

            pstmt.setString( 1, ( (DIAGNOSIS) diagnosis.get( i ) ).getMSGTYPE() );
            pstmt.setString( 2, ( (DIAGNOSIS) diagnosis.get( i ) ).getMSGID() );
            pstmt.setString( 3, ( (DIAGNOSIS) diagnosis.get( i ) ).getPNAME() );
            pstmt.setString( 4, ( (DIAGNOSIS) diagnosis.get( i ) ).getPATIENT_ID() );
            pstmt.setString( 5, ( (DIAGNOSIS) diagnosis.get( i ) ).getVISIT_ID() );
            pstmt.setString( 6, ( (DIAGNOSIS) diagnosis.get( i ) ).getDIAGNOSIS_NO() );
            pstmt.setString( 7, ( (DIAGNOSIS) diagnosis.get( i ) ).getDIAGNOSIS_TYPE() );
            pstmt.setString( 8, ( (DIAGNOSIS) diagnosis.get( i ) ).getDIAGNOSIS_TYPE2() );
            pstmt.setString( 9, ( (DIAGNOSIS) diagnosis.get( i ) ).getDIAGNOSIS_DESC() );
            pstmt.setString( 10, ( (DIAGNOSIS) diagnosis.get( i ) ).getDIAGNOSIS_CODE() );
            pstmt.setString( 11, ( (DIAGNOSIS) diagnosis.get( i ) ).getDIAGNOSIS_DATE() );
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
