
package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.IBasicinfoDAO;
import com.DAO.impl.BasicinfoDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.BASICINFO;

public class BasicinfoDAOproxy implements IBasicinfoDAO
{
    private DatabaseConnection dbc = null;
    private BasicinfoDAOimpl   dao = null;

    public BasicinfoDAOproxy() throws Exception
    {
        this.dbc = new DatabaseConnection();
        this.dao = new BasicinfoDAOimpl( this.dbc.getConnection() );
    }

    @Override
    public boolean doCreate( ArrayList<BASICINFO> basicinfo ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean flag = false;
        flag = this.dao.doCreate( basicinfo );
        this.dbc.close();
        return flag;
    }
}