package com.xinglin.hl7.tongji.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.xinglin.hl7.tongji.dao.ITemperatureDAO;
import com.xinglin.hl7.tongji.vo.Temperature;

public class TemperatureDAOimpl implements ITemperatureDAO
{
    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public TemperatureDAOimpl( Connection conn )
    {
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<Temperature> temp ) throws Throwable
    {
        boolean result = false;
        pstmt = conn.prepareStatement( " INSERT INTO HL7_OBX (MSGTYPE, MSGID, PATIENTID, IDNO, PNAME, VISITD, PDEPT, PWARD, PBEDNO, ORCID, "
                + "ORCTYPE, OBRNO, OBRNAME, OBXNO, OBXTYPE, OBXNAME, OBXRESULT, OBXUNIT, OBXFLAG, OBXTIME, LASTMODIFYTIME) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'))   " );

        for( int i = 0; i < temp.size(); i++ )
        {
            pstmt.setString( 1, ( (Temperature) temp.get( i ) ).getMsgType() );
            pstmt.setString( 2, ( (Temperature) temp.get( i ) ).getMsgId() );
            pstmt.setString( 3, ( (Temperature) temp.get( i ) ).getPatientid() );
            pstmt.setString( 4, ( (Temperature) temp.get( i ) ).getIdNo() );
            pstmt.setString( 5, ( (Temperature) temp.get( i ) ).getName() );
            pstmt.setString( 6, ( (Temperature) temp.get( i ) ).getVisitid() );
            pstmt.setString( 7, ( (Temperature) temp.get( i ) ).getDept() );
            pstmt.setString( 8, ( (Temperature) temp.get( i ) ).getWard() );
            pstmt.setString( 9, ( (Temperature) temp.get( i ) ).getBedno() );
            pstmt.setString( 10, ( (Temperature) temp.get( i ) ).getOrcId() );
            pstmt.setString( 11, ( (Temperature) temp.get( i ) ).getOrcType() );
            pstmt.setString( 12, ( (Temperature) temp.get( i ) ).getObrNo() );
            pstmt.setString( 13, ( (Temperature) temp.get( i ) ).getObrName() );
            pstmt.setString( 14, ( (Temperature) temp.get( i ) ).getObxNo() );
            pstmt.setString( 15, ( (Temperature) temp.get( i ) ).getObxType() );
            pstmt.setString( 16, ( (Temperature) temp.get( i ) ).getObxName() );
            pstmt.setString( 17, ( (Temperature) temp.get( i ) ).getObxResult() );
            pstmt.setString( 18, ( (Temperature) temp.get( i ) ).getObxUnit() );
            pstmt.setString( 19, ( (Temperature) temp.get( i ) ).getObxFlag() );
            pstmt.setString( 20, ( (Temperature) temp.get( i ) ).getObxTime() );
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