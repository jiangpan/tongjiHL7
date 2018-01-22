/**
 * 
 */
package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.IOperationsDAO;
import com.DAO.impl.OperationsDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.OPERATIONS;

/**
 * @author baobao
 *
 */
public class OperationsDAOproxy implements IOperationsDAO
{

    /**
     * 
     */
    private DatabaseConnection dbc = null;
    private OperationsDAOimpl  dao = null;

    public OperationsDAOproxy() throws Exception
    {
        // TODO Auto-generated constructor stub

        this.dbc = new DatabaseConnection();
        this.dao = new OperationsDAOimpl( this.dbc.getConnection() );
    }

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean doCreate( ArrayList<OPERATIONS> Operations ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean flag = false;
        flag = this.dao.doCreate( Operations );
        this.dbc.close();
        return flag;
    }

}
