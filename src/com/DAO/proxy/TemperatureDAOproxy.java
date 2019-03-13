package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.ITemperatureDAO;
import com.DAO.impl.TemperatureDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.TEMPERATURE;

public class TemperatureDAOproxy implements ITemperatureDAO
{
    private DatabaseConnection dbc = null;
    private TemperatureDAOimpl dao = null;

    public TemperatureDAOproxy() throws Exception
    {
        this.dbc = new DatabaseConnection();
        this.dao = new TemperatureDAOimpl( this.dbc.getConnection() );
    }

    @Override
    public boolean doCreate( ArrayList<TEMPERATURE> Temperature ) throws Throwable
    {
        boolean flag = false;
        flag = this.dao.doCreate( Temperature );
        this.dbc.close();
        return flag;
    }
}