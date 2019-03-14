
package com.xinglin.hl7.tongji.dao.proxy;

import java.util.ArrayList;

import com.xinglin.hl7.db.DatabaseConnection;
import com.xinglin.hl7.tongji.dao.IAntibioticsDAO;
import com.xinglin.hl7.tongji.dao.impl.AntibioticsDAOimpl;
import com.xinglin.hl7.tongji.vo.Antibiotics;

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
    public boolean doCreate( ArrayList<Antibiotics> antibiotics ) throws Throwable
    {
        boolean flag = false;
        flag = this.dao.doCreate( antibiotics );
        this.dbc.close();
        return flag;
    }
}