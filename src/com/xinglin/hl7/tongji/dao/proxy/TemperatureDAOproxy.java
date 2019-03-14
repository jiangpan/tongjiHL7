package com.xinglin.hl7.tongji.dao.proxy;

import java.util.ArrayList;

import com.xinglin.hl7.db.DatabaseConnection;
import com.xinglin.hl7.tongji.dao.ITemperatureDAO;
import com.xinglin.hl7.tongji.dao.impl.TemperatureDAOimpl;
import com.xinglin.hl7.tongji.vo.Temperature;

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
    public boolean doCreate( ArrayList<Temperature> Temperature ) throws Throwable
    {
        boolean flag = false;
        flag = this.dao.doCreate( Temperature );
        this.dbc.close();
        return flag;
    }
}