package com.xinglin.hl7.tongji.dao.proxy;

import java.util.ArrayList;

import com.xinglin.hl7.db.DatabaseConnection;
import com.xinglin.hl7.tongji.dao.IXrayDAO;
import com.xinglin.hl7.tongji.dao.impl.XrayDAOimpl;
import com.xinglin.hl7.tongji.vo.Xray;

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
    public boolean doCreate( ArrayList<Xray> Xray ) throws Throwable
    {
        boolean flag = false;
        flag = this.dao.doCreate( Xray );
        this.dbc.close();
        return flag;
    }
}