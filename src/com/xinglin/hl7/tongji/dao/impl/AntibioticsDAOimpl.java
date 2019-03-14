package com.xinglin.hl7.tongji.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.xinglin.hl7.tongji.dao.IAntibioticsDAO;
import com.xinglin.hl7.tongji.vo.Antibiotics;

public class AntibioticsDAOimpl implements IAntibioticsDAO
{
    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public AntibioticsDAOimpl( Connection conn )
    {
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<Antibiotics> antibiotics ) throws Throwable
    {
        boolean result = false;

        pstmt = conn.prepareStatement( " INSERT INTO HL7_ANTIBIOTICS (MSGTYPE, MSGID, PATIENTID, IDNO, PNAME, VISITD, PDEPT,"
                + " PWARD, PBEDNO, STATUSID, ORDERNO, STATUS, ORDERTIME, ORDERDOCTOR, ORDERTYPE, TQNO, FREQUENCY, FORTIME, "
                + "STARTTIME, ENDTIME, TQTYPE, TQCONT, ORDERTEXT, DOSAGE, DOSAGEUNITS, DOSAGETYPE, REMARK, ROOM, "
                + "ADMINISTRATION, USE_TIME,GOAL,ANTITYPECODE,ANTITYPENAME, LASTMODIFYTIME) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + "to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'))" );

        for( int i = 0; i < antibiotics.size(); i++ )
        {
            pstmt.setString( 1, ( (Antibiotics) antibiotics.get( i ) ).getMsgType() );
            pstmt.setString( 2, ( (Antibiotics) antibiotics.get( i ) ).getMsgId() );
            pstmt.setString( 3, ( (Antibiotics) antibiotics.get( i ) ).getPatientid() );
            pstmt.setString( 4, ( (Antibiotics) antibiotics.get( i ) ).getIdNo() );
            pstmt.setString( 5, ( (Antibiotics) antibiotics.get( i ) ).getPName() );
            pstmt.setString( 6, ( (Antibiotics) antibiotics.get( i ) ).getVisitid() );
            pstmt.setString( 7, ( (Antibiotics) antibiotics.get( i ) ).getPDept() );
            pstmt.setString( 8, ( (Antibiotics) antibiotics.get( i ) ).getPWard() );
            pstmt.setString( 9, ( (Antibiotics) antibiotics.get( i ) ).getPBedNo() );
            pstmt.setString( 10, ( (Antibiotics) antibiotics.get( i ) ).getStatusId() );
            pstmt.setString( 11, ( (Antibiotics) antibiotics.get( i ) ).getOrderNo() );
            pstmt.setString( 12, ( (Antibiotics) antibiotics.get( i ) ).getStatus() );
            pstmt.setString( 13, ( (Antibiotics) antibiotics.get( i ) ).getOrderTime() );
            pstmt.setString( 14, ( (Antibiotics) antibiotics.get( i ) ).getOrderDoctor() );
            pstmt.setString( 15, ( (Antibiotics) antibiotics.get( i ) ).getOrderType() );
            pstmt.setString( 16, ( (Antibiotics) antibiotics.get( i ) ).getTqNo() );
            pstmt.setString( 17, ( (Antibiotics) antibiotics.get( i ) ).getFrequency() );
            pstmt.setString( 18, ( (Antibiotics) antibiotics.get( i ) ).getFortime() );
            pstmt.setString( 19, ( (Antibiotics) antibiotics.get( i ) ).getStartTime() );
            pstmt.setString( 20, ( (Antibiotics) antibiotics.get( i ) ).getStopTime() );
            pstmt.setString( 21, ( (Antibiotics) antibiotics.get( i ) ).getTqType() );
            pstmt.setString( 22, ( (Antibiotics) antibiotics.get( i ) ).getTqContent() );
            pstmt.setString( 23, ( (Antibiotics) antibiotics.get( i ) ).getOrderText() );
            pstmt.setString( 24, ( (Antibiotics) antibiotics.get( i ) ).getDosage() );
            pstmt.setString( 25, ( (Antibiotics) antibiotics.get( i ) ).getDosageUnits() );
            pstmt.setString( 26, ( (Antibiotics) antibiotics.get( i ) ).getDosageType() );
            pstmt.setString( 27, ( (Antibiotics) antibiotics.get( i ) ).getRemark() );
            pstmt.setString( 28, ( (Antibiotics) antibiotics.get( i ) ).getRoom() );
            pstmt.setString( 29, ( (Antibiotics) antibiotics.get( i ) ).getAdministration() );
            pstmt.setString( 30, ( (Antibiotics) antibiotics.get( i ) ).getUseTime() );
            pstmt.setString( 31, ( (Antibiotics) antibiotics.get( i ) ).getGoal() );
            pstmt.setString( 32, ( (Antibiotics) antibiotics.get( i ) ).getAntiTypeCode() );
            pstmt.setString( 33, ( (Antibiotics) antibiotics.get( i ) ).getAntiTypeName() );

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