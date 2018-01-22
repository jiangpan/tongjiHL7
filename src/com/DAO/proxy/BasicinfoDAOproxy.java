/**
 * 
 */
package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.IBasicinfoDAO;
import com.DAO.impl.BasicinfoDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.BASICINFO;

/**
 * @author baobao
 *
 */
public class BasicinfoDAOproxy implements IBasicinfoDAO
{

    /**
     * 
     */
    private DatabaseConnection dbc = null;
    private BasicinfoDAOimpl   dao = null;

    public BasicinfoDAOproxy() throws Exception
    {
        // TODO Auto-generated constructor stub

        this.dbc = new DatabaseConnection();
        this.dao = new BasicinfoDAOimpl( this.dbc.getConnection() );
    }

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean doCreate( ArrayList<BASICINFO> basicinfo ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean flag = false;
        flag = this.dao.doCreate( basicinfo );
        this.dbc.close();
        return flag;
    }

}
