package com.xinglin.hl7.tongji.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.xinglin.hl7.tongji.dao.ILisreportDAO;
import com.xinglin.hl7.tongji.vo.LisReport;;

public class LisreportDAOimpl implements ILisreportDAO
{
    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public LisreportDAOimpl( Connection conn )
    {
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<LisReport> temp ) throws Throwable
    {
        boolean result = false;

        pstmt = conn.prepareStatement( " INSERT INTO HL7_LISREPORT (MSGTYPE, MSGID, PATIENTID, IDNO, PNAME, VISITD, PDEPT, PWARD, "
                + "PBEDNO, ORCID, ORCUNIT, ORCTYPE, OBRNO, REQNO, REPNO, OBRNAME, REPTIME, OBRSTATUS, OBRREPNAME, OBXNO, OBXTYPE,"
                + " OBXNAME, OBXNAMEID, OBXRESULT, OBXRANGE, OBXUNIT, OBXFLAG, OBXMETHOD,REQTIME,OBXNAMECODE,SPECIMEN,rectime, LASTMODIFYTIME)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'))   " );

        for( int i = 0; i < temp.size(); i++ )
        {
            pstmt.setString( 1, ( (LisReport) temp.get( i ) ).getMsgType() );// MSH.9
            pstmt.setString( 2, ( (LisReport) temp.get( i ) ).getMsgId() );// MSH.1
            pstmt.setString( 3, ( (LisReport) temp.get( i ) ).getPatientid() );// PID.2
            pstmt.setString( 4, ( (LisReport) temp.get( i ) ).getIdNo() );// PID.3.1
            pstmt.setString( 5, ( (LisReport) temp.get( i ) ).getPName() );// PID.5
            pstmt.setString( 6, ( (LisReport) temp.get( i ) ).getVisitd() );// PV1.19
            pstmt.setString( 7, ( (LisReport) temp.get( i ) ).getPDept() );// PV1.3.1
            pstmt.setString( 8, ( (LisReport) temp.get( i ) ).getPWard() );// PV1.3.2
            pstmt.setString( 9, ( (LisReport) temp.get( i ) ).getPBedno() );// PV1.3.3
            pstmt.setString( 10, ( (LisReport) temp.get( i ) ).getOrcId() );// ORC.1
            pstmt.setString( 11, ( (LisReport) temp.get( i ) ).getOrcUnit() );// ORC.16
            pstmt.setString( 12, ( (LisReport) temp.get( i ) ).getOrcType() );// ORC.29
            pstmt.setString( 13, ( (LisReport) temp.get( i ) ).getObrNo() );// OBR.1
            pstmt.setString( 14, ( (LisReport) temp.get( i ) ).getReqNo() );// OBR.2
            pstmt.setString( 15, ( (LisReport) temp.get( i ) ).getRepNo() );// OBR.3
            pstmt.setString( 16, ( (LisReport) temp.get( i ) ).getObrName() );// OBR.4
            pstmt.setString( 17, ( (LisReport) temp.get( i ) ).getRepTime() );// OBR.22
            pstmt.setString( 18, ( (LisReport) temp.get( i ) ).getObrStatus() );// OBR.25
            pstmt.setString( 19, ( (LisReport) temp.get( i ) ).getObrRepname() );// OBR.47.2
            pstmt.setString( 20, ( (LisReport) temp.get( i ) ).getObxNo() );// OBX.1
            pstmt.setString( 21, ( (LisReport) temp.get( i ) ).getObxType() );// OBX.2
            pstmt.setString( 22, ( (LisReport) temp.get( i ) ).getObxName() );// OBX.3
            pstmt.setString( 23, ( (LisReport) temp.get( i ) ).getObxNameId() );// OBX.4
            pstmt.setString( 24, ( (LisReport) temp.get( i ) ).getObxResult() );// OBX.5
            pstmt.setString( 25, ( (LisReport) temp.get( i ) ).getObxRange() );// OBX.7
            pstmt.setString( 26, ( (LisReport) temp.get( i ) ).getObxUnit() );// OBX.8
            pstmt.setString( 27, ( (LisReport) temp.get( i ) ).getObxFlag() );// OBX.11
            pstmt.setString( 28, ( (LisReport) temp.get( i ) ).getObxMethod() );// OBX.17
            pstmt.setString( 29, ( (LisReport) temp.get( i ) ).getReqTime() );// OBX.17
            pstmt.setString( 30, ( (LisReport) temp.get( i ) ).getObxNameCode() );// OBX.3.2
            pstmt.setString( 31, ( (LisReport) temp.get( i ) ).getSpecimen() );// OBr.15
            pstmt.setString( 32, ( (LisReport) temp.get( i ) ).getRecTime() );// OBr.14
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