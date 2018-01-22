/**
 * 
 */
package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.ILisreportDAO;
import com.DAO.impl.LisreportDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.LISREPORT;

/**
 * @author baobao
 *
 */
public class LisreportDAOproxy implements ILisreportDAO
{

    /**
     * 
     */
    private DatabaseConnection dbc = null;
    private LisreportDAOimpl   dao = null;

    public LisreportDAOproxy() throws Exception
    {
        // TODO Auto-generated constructor stub

        this.dbc = new DatabaseConnection();
        this.dao = new LisreportDAOimpl( this.dbc.getConnection() );
    }

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean doCreate( ArrayList<LISREPORT> Temperature ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean flag = false;
        flag = this.dao.doCreate( Temperature );
        this.dbc.close();
        return flag;
    }

}
