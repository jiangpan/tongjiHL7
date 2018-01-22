/**
 * 
 */
package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.ITemperatureDAO;
import com.DAO.impl.TemperatureDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.TEMPERATURE;

/**
 * @author baobao
 *
 */
public class TemperatureDAOproxy implements ITemperatureDAO
{

    /**
     * 
     */
    private DatabaseConnection dbc = null;
    private TemperatureDAOimpl dao = null;

    public TemperatureDAOproxy() throws Exception
    {
        // TODO Auto-generated constructor stub

        this.dbc = new DatabaseConnection();
        this.dao = new TemperatureDAOimpl( this.dbc.getConnection() );
    }

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean doCreate( ArrayList<TEMPERATURE> Temperature ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean flag = false;
        flag = this.dao.doCreate( Temperature );
        this.dbc.close();
        return flag;
    }

}
