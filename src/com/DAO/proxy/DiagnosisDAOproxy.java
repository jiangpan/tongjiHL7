
package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.IDiagnosisDAO;
import com.DAO.impl.DiagnosisDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.DIAGNOSIS;

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
    public boolean doCreate( ArrayList<DIAGNOSIS> diagnosis ) throws Throwable
    {
        boolean flag = false;
        flag = this.dao.doCreate( diagnosis );
        this.dbc.close();
        return flag;
    }
}