/**
 * 
 */
package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.IAntibioticsDAO;
import com.DAO.impl.AntibioticsDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.ANTIBIOTICS;

/**
 * @author baobao
 *
 */
public class AntibioticsDAOproxy implements IAntibioticsDAO
{

    /**
     * 
     */
    private DatabaseConnection dbc = null;
    private AntibioticsDAOimpl dao = null;

    public AntibioticsDAOproxy() throws Exception
    {
        // TODO Auto-generated constructor stub

        this.dbc = new DatabaseConnection();
        this.dao = new AntibioticsDAOimpl( this.dbc.getConnection() );
    }

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean doCreate( ArrayList<ANTIBIOTICS> antibiotics ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean flag = false;
        flag = this.dao.doCreate( antibiotics );
        this.dbc.close();
        return flag;
    }

}
