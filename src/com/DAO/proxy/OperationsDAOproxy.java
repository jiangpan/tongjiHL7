
package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.IOperationsDAO;
import com.DAO.impl.OperationsDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.OPERATIONS;

public class OperationsDAOproxy implements IOperationsDAO
{
    private DatabaseConnection dbc = null;
    private OperationsDAOimpl  dao = null;

    public OperationsDAOproxy() throws Exception
    {
        this.dbc = new DatabaseConnection();
        this.dao = new OperationsDAOimpl( this.dbc.getConnection() );
    }

    @Override
    public boolean doCreate( ArrayList<OPERATIONS> Operations ) throws Throwable
    {
        boolean flag = false;
        flag = this.dao.doCreate( Operations );
        this.dbc.close();
        return flag;
    }
}