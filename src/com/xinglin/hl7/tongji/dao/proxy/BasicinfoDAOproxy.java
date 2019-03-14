
package com.xinglin.hl7.tongji.dao.proxy;

import java.util.ArrayList;

import com.xinglin.hl7.db.DatabaseConnection;
import com.xinglin.hl7.tongji.dao.IBasicinfoDAO;
import com.xinglin.hl7.tongji.dao.impl.BasicinfoDAOimpl;
import com.xinglin.hl7.tongji.vo.Basicinfo;

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
    public boolean doCreate( ArrayList<Basicinfo> basicinfo ) throws Throwable
    {
        boolean flag = false;
        flag = this.dao.doCreate( basicinfo );
        this.dbc.close();
        return flag;
    }
}