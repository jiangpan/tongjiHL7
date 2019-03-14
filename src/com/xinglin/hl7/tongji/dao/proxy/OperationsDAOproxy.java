
package com.xinglin.hl7.tongji.dao.proxy;

import java.util.ArrayList;

import com.xinglin.hl7.db.DatabaseConnection;
import com.xinglin.hl7.tongji.dao.IOperationsDAO;
import com.xinglin.hl7.tongji.dao.impl.OperationsDAOimpl;
import com.xinglin.hl7.tongji.vo.Operation;

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
    public boolean doCreate( ArrayList<Operation> Operations ) throws Throwable
    {
        boolean flag = false;
        flag = this.dao.doCreate( Operations );
        this.dbc.close();
        return flag;
    }
}