package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.ILisreportDAO;
import com.DAO.impl.LisreportDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.LISREPORT;

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
    public boolean doCreate( ArrayList<LISREPORT> Temperature ) throws Throwable
    {
        boolean flag = false;
        flag = this.dao.doCreate( Temperature );
        this.dbc.close();
        return flag;
    }
}