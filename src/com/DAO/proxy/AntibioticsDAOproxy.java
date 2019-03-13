
package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.IAntibioticsDAO;
import com.DAO.impl.AntibioticsDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.ANTIBIOTICS;

public class AntibioticsDAOproxy implements IAntibioticsDAO
{
    private DatabaseConnection dbc = null;
    private AntibioticsDAOimpl dao = null;

    public AntibioticsDAOproxy() throws Exception
    {
        this.dbc = new DatabaseConnection();
        this.dao = new AntibioticsDAOimpl( this.dbc.getConnection() );
    }

    @Override
    public boolean doCreate( ArrayList<ANTIBIOTICS> antibiotics ) throws Throwable
    {
        boolean flag = false;
        flag = this.dao.doCreate( antibiotics );
        this.dbc.close();
        return flag;
    }
}