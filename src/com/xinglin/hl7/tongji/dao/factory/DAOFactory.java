/**
 * 
 */
package com.xinglin.hl7.tongji.dao.factory;

import com.xinglin.hl7.tongji.dao.IAntibioticsDAO;
import com.xinglin.hl7.tongji.dao.IBasicinfoDAO;
import com.xinglin.hl7.tongji.dao.IDiagnosisDAO;
import com.xinglin.hl7.tongji.dao.ILisreportDAO;
import com.xinglin.hl7.tongji.dao.IOperationsDAO;
import com.xinglin.hl7.tongji.dao.ITemperatureDAO;
import com.xinglin.hl7.tongji.dao.IXrayDAO;
import com.xinglin.hl7.tongji.dao.proxy.AntibioticsDAOproxy;
import com.xinglin.hl7.tongji.dao.proxy.BasicinfoDAOproxy;
import com.xinglin.hl7.tongji.dao.proxy.DiagnosisDAOproxy;
import com.xinglin.hl7.tongji.dao.proxy.LisreportDAOproxy;
import com.xinglin.hl7.tongji.dao.proxy.OperationsDAOproxy;
import com.xinglin.hl7.tongji.dao.proxy.TemperatureDAOproxy;
import com.xinglin.hl7.tongji.dao.proxy.XrayDAOproxy;

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
