/**
 * 
 */
package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.IDiagnosisDAO;
import com.DAO.impl.DiagnosisDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.DIAGNOSIS;

/**
 * @author baobao
 *
 */
public class DiagnosisDAOproxy implements IDiagnosisDAO
{

    /**
     * 
     */
    private DatabaseConnection dbc = null;
    private DiagnosisDAOimpl   dao = null;

    public DiagnosisDAOproxy() throws Exception
    {
        // TODO Auto-generated constructor stub

        this.dbc = new DatabaseConnection();
        this.dao = new DiagnosisDAOimpl( this.dbc.getConnection() );
    }

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean doCreate( ArrayList<DIAGNOSIS> diagnosis ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean flag = false;
        flag = this.dao.doCreate( diagnosis );
        this.dbc.close();
        return flag;
    }

}
