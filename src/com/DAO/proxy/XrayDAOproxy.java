package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.IXrayDAO;
import com.DAO.impl.XrayDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.XRAY;

public class XrayDAOproxy implements IXrayDAO
{
    private DatabaseConnection dbc = null;
    private XrayDAOimpl        dao = null;

    public XrayDAOproxy() throws Exception
    {
        this.dbc = new DatabaseConnection();
        this.dao = new XrayDAOimpl( this.dbc.getConnection() );
    }

    @Override
    public boolean doCreate( ArrayList<XRAY> Xray ) throws Throwable
    {
        boolean flag = false;
        flag = this.dao.doCreate( Xray );
        this.dbc.close();
        return flag;
    }
}