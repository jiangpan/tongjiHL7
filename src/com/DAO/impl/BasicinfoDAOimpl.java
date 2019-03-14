package com.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.DAO.IBasicinfoDAO;
import com.VO.BASICINFO;

public class BasicinfoDAOimpl implements IBasicinfoDAO
{
    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public BasicinfoDAOimpl( Connection conn )
    {
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<BASICINFO> basicinfo ) throws Throwable
    {
        boolean flag = false;

        pstmt = conn.prepareStatement( " INSERT INTO HL7_BASICINFO (MSGTYPE, MSGID, ACTIONTYPE, ACTIONTIME, PATIENTID, IDNO, PNAME, PBRITHDATE, PSEX, PADDRESS,"
                + " PADDRESSNO, PPHONE, PMPHONE, MAILING_ADDRESS, NEXT_OF_KIN, NEXT_OF_KIN_ADDR, NEXT_OF_KIN_PHONE, PTYPE, PDEPT, PWARD, PBEDNO, PHLDY, "
                + "PLOCATION, PLASTDEPT, PLASTWARD, PLASTBEDNO, PLASTHLDY, ATTENDING_DOCTOR, VISITID, INTIME, OUTTIME, LASTMODIFYTIME) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + "to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'))" );

        for( int i = 0; i < basicinfo.size(); i++ )
        {
            pstmt.setString( 1, ( (BASICINFO) basicinfo.get( i ) ).getMSGTYPE() );
            pstmt.setString( 2, ( (BASICINFO) basicinfo.get( i ) ).getMSGID() );
            pstmt.setString( 3, ( (BASICINFO) basicinfo.get( i ) ).getACTIONTYPE() );
            pstmt.setString( 4, ( (BASICINFO) basicinfo.get( i ) ).getACTIONTIME() );
            pstmt.setString( 5, ( (BASICINFO) basicinfo.get( i ) ).getPATIENTID() );
            pstmt.setString( 6, ( (BASICINFO) basicinfo.get( i ) ).getIDNO() );
            pstmt.setString( 7, ( (BASICINFO) basicinfo.get( i ) ).getPNAME() );
            pstmt.setString( 8, ( (BASICINFO) basicinfo.get( i ) ).getPBRITHDATE() );
            pstmt.setString( 9, ( (BASICINFO) basicinfo.get( i ) ).getPSEX() );
            pstmt.setString( 10, ( (BASICINFO) basicinfo.get( i ) ).getPADDRESS() );
            pstmt.setString( 11, ( (BASICINFO) basicinfo.get( i ) ).getPADDRESSNO() );
            pstmt.setString( 12, ( (BASICINFO) basicinfo.get( i ) ).getPPHONE() );
            pstmt.setString( 13, ( (BASICINFO) basicinfo.get( i ) ).getPMPHONE() );
            pstmt.setString( 14, ( (BASICINFO) basicinfo.get( i ) ).getMAILING_ADDRESS() );
            pstmt.setString( 15, ( (BASICINFO) basicinfo.get( i ) ).getNEXT_OF_KIN() );
            pstmt.setString( 16, ( (BASICINFO) basicinfo.get( i ) ).getNEXT_OF_KIN_ADDR() );
            pstmt.setString( 17, ( (BASICINFO) basicinfo.get( i ) ).getNEXT_OF_KIN_PHONE() );
            pstmt.setString( 18, ( (BASICINFO) basicinfo.get( i ) ).getPTYPE() );
            pstmt.setString( 19, ( (BASICINFO) basicinfo.get( i ) ).getPDEPT() );
            pstmt.setString( 20, ( (BASICINFO) basicinfo.get( i ) ).getPWARD() );
            pstmt.setString( 21, ( (BASICINFO) basicinfo.get( i ) ).getPBEDNO() );
            pstmt.setString( 22, ( (BASICINFO) basicinfo.get( i ) ).getPHLDY() );
            pstmt.setString( 23, ( (BASICINFO) basicinfo.get( i ) ).getPLOCATION() );
            pstmt.setString( 24, ( (BASICINFO) basicinfo.get( i ) ).getPLASTDEPT() );
            pstmt.setString( 25, ( (BASICINFO) basicinfo.get( i ) ).getPLASTWARD() );
            pstmt.setString( 26, ( (BASICINFO) basicinfo.get( i ) ).getPLASTBEDNO() );
            pstmt.setString( 27, ( (BASICINFO) basicinfo.get( i ) ).getPLASTHLDY() );
            pstmt.setString( 28, ( (BASICINFO) basicinfo.get( i ) ).getATTENDING_DOCTOR() );
            pstmt.setString( 29, ( (BASICINFO) basicinfo.get( i ) ).getVISITID() );
            pstmt.setString( 30, ( (BASICINFO) basicinfo.get( i ) ).getINTIME() );
            pstmt.setString( 31, ( (BASICINFO) basicinfo.get( i ) ).getOUTTIME() );
            pstmt.addBatch();
        }
        int[] inserts = pstmt.executeBatch();
        for( int insert : inserts )
        {
            if( insert == -2 )
            {
                flag = true;
            }
        }

        return flag;
    }
}