
package com.xinglin.hl7.tongji.dao.proxy;

import java.util.ArrayList;

import com.xinglin.hl7.db.DatabaseConnection;
import com.xinglin.hl7.tongji.dao.IDiagnosisDAO;
import com.xinglin.hl7.tongji.dao.impl.DiagnosisDAOimpl;
import com.xinglin.hl7.tongji.vo.Diagnosis;

public class DiagnosisDAOproxy implements IDiagnosisDAO
{
    private DatabaseConnection dbc = null;
    private DiagnosisDAOimpl   dao = null;

    public DiagnosisDAOproxy() throws Exception
    {
        this.dbc = new DatabaseConnection();
        this.dao = new DiagnosisDAOimpl( this.dbc.getConnection() );
    }

    @Override
    public boolean doCreate( ArrayList<Diagnosis> diagnosis ) throws Throwable
    {
        boolean flag = false;
        flag = this.dao.doCreate( diagnosis );
        this.dbc.close();
        return flag;
    }
}