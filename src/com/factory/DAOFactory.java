/**
 * 
 */
package com.factory;

import com.DAO.IAntibioticsDAO;
import com.DAO.IBasicinfoDAO;
import com.DAO.IDiagnosisDAO;
import com.DAO.ILisreportDAO;
import com.DAO.IOperationsDAO;
import com.DAO.ITemperatureDAO;
import com.DAO.IXrayDAO;
import com.DAO.proxy.AntibioticsDAOproxy;
import com.DAO.proxy.BasicinfoDAOproxy;
import com.DAO.proxy.DiagnosisDAOproxy;
import com.DAO.proxy.LisreportDAOproxy;
import com.DAO.proxy.OperationsDAOproxy;
import com.DAO.proxy.TemperatureDAOproxy;
import com.DAO.proxy.XrayDAOproxy;

/**
 * @author xinglinyg
 *
 */
public class DAOFactory
{

    /**
     * 
     */
    public static IBasicinfoDAO getBasicinfoDAOInstance() throws Throwable
    {
        return new BasicinfoDAOproxy();
    }

    public static IAntibioticsDAO getAntibioticsDAOInstance() throws Throwable
    {
        return new AntibioticsDAOproxy();
    }

    public static IDiagnosisDAO getDiagnosisDAOInstance() throws Throwable
    {
        return new DiagnosisDAOproxy();
    }

    public static IOperationsDAO getOperationsDAOInstance() throws Throwable
    {
        return new OperationsDAOproxy();
    }

    public static ITemperatureDAO getTemperatureDAOInstance() throws Throwable
    {
        return new TemperatureDAOproxy();
    }

    public static IXrayDAO getXrayDAOInstance() throws Throwable
    {
        return new XrayDAOproxy();
    }

    public static ILisreportDAO getLisreportDAOInstance() throws Throwable
    {
        return new LisreportDAOproxy();
    }

}
