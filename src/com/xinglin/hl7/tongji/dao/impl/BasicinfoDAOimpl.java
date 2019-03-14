package com.xinglin.hl7.tongji.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.xinglin.hl7.tongji.dao.IBasicinfoDAO;
import com.xinglin.hl7.tongji.vo.Basicinfo;

public class BasicinfoDAOimpl implements IBasicinfoDAO
{
    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public BasicinfoDAOimpl( Connection conn )
    {
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<Basicinfo> basicinfo ) throws Throwable
    {
        boolean flag = false;

        pstmt = conn.prepareStatement( " INSERT INTO HL7_BASICINFO (MSGTYPE, MSGID, ACTIONTYPE, ACTIONTIME, PATIENTID, IDNO, PNAME, PBRITHDATE, PSEX, PADDRESS,"
                + " PADDRESSNO, PPHONE, PMPHONE, MAILING_ADDRESS, NEXT_OF_KIN, NEXT_OF_KIN_ADDR, NEXT_OF_KIN_PHONE, PTYPE, PDEPT, PWARD, PBEDNO, PHLDY, "
                + "PLOCATION, PLASTDEPT, PLASTWARD, PLASTBEDNO, PLASTHLDY, ATTENDING_DOCTOR, VISITID, INTIME, OUTTIME, LASTMODIFYTIME) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + "to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'))" );

        for( int i = 0; i < basicinfo.size(); i++ )
        {
            pstmt.setString( 1, ( (Basicinfo) basicinfo.get( i ) ).getMsgType() );
            pstmt.setString( 2, ( (Basicinfo) basicinfo.get( i ) ).getMsgId() );
            pstmt.setString( 3, ( (Basicinfo) basicinfo.get( i ) ).getActiontype() );
            pstmt.setString( 4, ( (Basicinfo) basicinfo.get( i ) ).getActiontime() );
            pstmt.setString( 5, ( (Basicinfo) basicinfo.get( i ) ).getPatientid() );
            pstmt.setString( 6, ( (Basicinfo) basicinfo.get( i ) ).getIdno() );
            pstmt.setString( 7, ( (Basicinfo) basicinfo.get( i ) ).getName() );
            pstmt.setString( 8, ( (Basicinfo) basicinfo.get( i ) ).getBirthdate() );
            pstmt.setString( 9, ( (Basicinfo) basicinfo.get( i ) ).getSex() );
            pstmt.setString( 10, ( (Basicinfo) basicinfo.get( i ) ).getAddress() );
            pstmt.setString( 11, ( (Basicinfo) basicinfo.get( i ) ).getAddressno() );
            pstmt.setString( 12, ( (Basicinfo) basicinfo.get( i ) ).getPhone() );
            pstmt.setString( 13, ( (Basicinfo) basicinfo.get( i ) ).getMobilePhone() );
            pstmt.setString( 14, ( (Basicinfo) basicinfo.get( i ) ).getMailingAddress() );
            pstmt.setString( 15, ( (Basicinfo) basicinfo.get( i ) ).getNextOfKin() );
            pstmt.setString( 16, ( (Basicinfo) basicinfo.get( i ) ).getNextOfKinAddr() );
            pstmt.setString( 17, ( (Basicinfo) basicinfo.get( i ) ).getNextOfKinPhone() );
            pstmt.setString( 18, ( (Basicinfo) basicinfo.get( i ) ).getType() );
            pstmt.setString( 19, ( (Basicinfo) basicinfo.get( i ) ).getDept() );
            pstmt.setString( 20, ( (Basicinfo) basicinfo.get( i ) ).getWard() );
            pstmt.setString( 21, ( (Basicinfo) basicinfo.get( i ) ).getBedno() );
            pstmt.setString( 22, ( (Basicinfo) basicinfo.get( i ) ).getUnit() );
            pstmt.setString( 23, ( (Basicinfo) basicinfo.get( i ) ).getLocation() );
            pstmt.setString( 24, ( (Basicinfo) basicinfo.get( i ) ).getLastDept() );
            pstmt.setString( 25, ( (Basicinfo) basicinfo.get( i ) ).getLastWard() );
            pstmt.setString( 26, ( (Basicinfo) basicinfo.get( i ) ).getLastBedno() );
            pstmt.setString( 27, ( (Basicinfo) basicinfo.get( i ) ).getLastUnit() );
            pstmt.setString( 28, ( (Basicinfo) basicinfo.get( i ) ).getAttendingDoctor() );
            pstmt.setString( 29, ( (Basicinfo) basicinfo.get( i ) ).getVisitid() );
            pstmt.setString( 30, ( (Basicinfo) basicinfo.get( i ) ).getIntime() );
            pstmt.setString( 31, ( (Basicinfo) basicinfo.get( i ) ).getOuttime() );
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