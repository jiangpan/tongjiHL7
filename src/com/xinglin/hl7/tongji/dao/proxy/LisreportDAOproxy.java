package com.xinglin.hl7.tongji.dao.proxy;

import java.util.ArrayList;

import com.xinglin.hl7.db.DatabaseConnection;
import com.xinglin.hl7.tongji.dao.ILisreportDAO;
import com.xinglin.hl7.tongji.dao.impl.LisreportDAOimpl;
import com.xinglin.hl7.tongji.vo.LisReport;

public class LisreportDAOproxy implements ILisreportDAO
{
    private DatabaseConnection dbc = null;
    private LisreportDAOimpl   dao = null;

    public LisreportDAOproxy() throws Exception
    {
        this.dbc = new DatabaseConnection();
        this.dao = new LisreportDAOimpl( this.dbc.getConnection() );
    }

    @Override
    public boolean doCreate( ArrayList<LisReport> Temperature ) throws Throwable
    {
        boolean flag = false;
        flag = this.dao.doCreate( Temperature );
        this.dbc.close();
        return flag;
    }
}