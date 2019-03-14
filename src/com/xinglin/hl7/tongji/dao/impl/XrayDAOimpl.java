package com.xinglin.hl7.tongji.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.xinglin.hl7.tongji.dao.IXrayDAO;
import com.xinglin.hl7.tongji.vo.Xray;

public class XrayDAOimpl implements IXrayDAO
{
    private Connection        conn  = null;
    private PreparedStatement pstmt = null;

    public XrayDAOimpl( Connection conn )
    {
        this.conn = conn;
    }

    @Override
    public boolean doCreate( ArrayList<Xray> xray ) throws Throwable
    {
        boolean result = false;
        pstmt = conn.prepareStatement( " INSERT INTO HL7_XRAY (MSGTYPE, MSGID, PATIENTID, IDNO, PNAME, VISITD, PDEPT, PWARD, PBEDNO, ORCID,"
                + " ORCNO, ORCTYPE, OBRNO, REPNO, OBRNAME, REPTIME, OBRTYPE, OBRSTATUS, OBRREPNAME, OBXNO, OBXTYPE, OBXNAME, "
                + "OBXRESULT1, OBXRESULT2, OBXUNIT, OBXFLAG, OBXMETHOD, LASTMODIFYTIME) "
                + "  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,to_char(sysdate,'yyyy-mm-dd hh24:mi:ss')) " );

        for( int i = 0; i < xray.size(); i++ )
        {
            pstmt.setString( 1, ( (Xray) xray.get( i ) ).getMsgType() );
            pstmt.setString( 2, ( (Xray) xray.get( i ) ).getMsgId() );
            pstmt.setString( 3, ( (Xray) xray.get( i ) ).getPatientid() );
            pstmt.setString( 4, ( (Xray) xray.get( i ) ).getIdNo() );
            pstmt.setString( 5, ( (Xray) xray.get( i ) ).getName() );
            pstmt.setString( 6, ( (Xray) xray.get( i ) ).getVisitd() );
            pstmt.setString( 7, ( (Xray) xray.get( i ) ).getDept() );
            pstmt.setString( 8, ( (Xray) xray.get( i ) ).getWard() );
            pstmt.setString( 9, ( (Xray) xray.get( i ) ).getBedno() );
            pstmt.setString( 10, ( (Xray) xray.get( i ) ).getOrcId() );
            pstmt.setString( 11, ( (Xray) xray.get( i ) ).getOrcNo() );
            pstmt.setString( 12, ( (Xray) xray.get( i ) ).getOrcType() );
            pstmt.setString( 13, ( (Xray) xray.get( i ) ).getObrNo() );
            pstmt.setString( 14, ( (Xray) xray.get( i ) ).getRepNo() );
            pstmt.setString( 15, ( (Xray) xray.get( i ) ).getObrName() );
            pstmt.setString( 16, ( (Xray) xray.get( i ) ).getRepTime() );
            pstmt.setString( 17, ( (Xray) xray.get( i ) ).getObrType() );
            pstmt.setString( 18, ( (Xray) xray.get( i ) ).getObrStatus() );
            pstmt.setString( 19, ( (Xray) xray.get( i ) ).getObrRepName() );
            pstmt.setString( 20, ( (Xray) xray.get( i ) ).getObxNo() );
            pstmt.setString( 21, ( (Xray) xray.get( i ) ).getObxType() );
            pstmt.setString( 22, ( (Xray) xray.get( i ) ).getObxName() );
            pstmt.setString( 23, ( (Xray) xray.get( i ) ).getObxResult1() );
            pstmt.setString( 24, ( (Xray) xray.get( i ) ).getObxResult2() );
            pstmt.setString( 25, ( (Xray) xray.get( i ) ).getObxUnit() );
            pstmt.setString( 26, ( (Xray) xray.get( i ) ).getObxFlag() );
            pstmt.setString( 27, ( (Xray) xray.get( i ) ).getObxMethod() );
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