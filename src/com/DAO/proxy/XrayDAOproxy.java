/**
 * 
 */
package com.DAO.proxy;

import java.util.ArrayList;

import com.DAO.IXrayDAO;
import com.DAO.impl.XrayDAOimpl;
import com.DB.DatabaseConnection;
import com.VO.XRAY;

/**
 * @author baobao
 *
 */
public class XrayDAOproxy implements IXrayDAO
{

    /**
     * 
     */
    private DatabaseConnection dbc = null;
    private XrayDAOimpl        dao = null;

    public XrayDAOproxy() throws Exception
    {
        // TODO Auto-generated constructor stub

        this.dbc = new DatabaseConnection();
        this.dao = new XrayDAOimpl( this.dbc.getConnection() );
    }

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean doCreate( ArrayList<XRAY> Xray ) throws Throwable
    {
        // TODO Auto-generated method stub
        boolean flag = false;
        flag = this.dao.doCreate( Xray );
        this.dbc.close();
        return flag;
    }

}
