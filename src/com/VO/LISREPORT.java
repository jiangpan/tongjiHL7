/**
 * 
 */
package com.VO;

/**
 * @author Administrator
 *
 */
public class LISREPORT
{
    private String MSGTYPE;    // MSH.9
    private String MSGID;      // MSH.1
    private String PATIENTID;  // PID.2
    private String IDNO;       // PID.3.1
    private String PNAME;      // PID.5
    private String VISITD;     // PV1.19
    private String PDEPT;      // PV1.3.1
    private String PWARD;      // PV1.3.2
    private String PBEDNO;     // PV1.3.3
    private String ORCID;      // ORC.1
    private String ORCUNIT;    // ORC.16
    private String ORCTYPE;    // ORC.29
    private String OBRNO;      // OBR.1
    private String REQNO;      // OBR.2
    private String REPNO;      // OBR.3
    private String OBRNAME;    // OBR.4
    private String REQTIME;    // OBR.7
    private String REPTIME;    // OBR.22
    private String OBRSTATUS;  // OBR.25
    private String OBRREPNAME; // OBR.47.2
    private String OBXNO;      // OBX.1
    private String OBXTYPE;    // OBX.2
    private String OBXNAMECODE;// OBX.3.1
    private String OBXNAME;    // OBX.3.2
    private String OBXNAMEID;  // OBX.4
    private String OBXRESULT;  // OBX.5
    private String OBXRANGE;   // OBX.7
    private String OBXUNIT;    // OBX.8
    private String OBXFLAG;    // OBX.11
    private String OBXMETHOD;  // OBX.17
    private String SPECIMEN;   // obr.15
    private String rectime;    // obr.14

    public String getMSGTYPE()
    {
        return MSGTYPE;
    }

    public void setMSGTYPE( String mSGTYPE )
    {
        MSGTYPE = mSGTYPE;
    }

    public String getMSGID()
    {
        return MSGID;
    }

    public void setMSGID( String mSGID )
    {
        MSGID = mSGID;
    }

    public String getPATIENTID()
    {
        return PATIENTID;
    }

    public void setPATIENTID( String pATIENTID )
    {
        PATIENTID = pATIENTID;
    }

    public String getIDNO()
    {
        return IDNO;
    }

    public void setIDNO( String iDNO )
    {
        IDNO = iDNO;
    }

    public String getPNAME()
    {
        return PNAME;
    }

    public void setPNAME( String pNAME )
    {
        PNAME = pNAME;
    }

    public String getVISITD()
    {
        return VISITD;
    }

    public void setVISITD( String vISITD )
    {
        VISITD = vISITD;
    }

    public String getPDEPT()
    {
        return PDEPT;
    }

    public void setPDEPT( String pDEPT )
    {
        PDEPT = pDEPT;
    }

    public String getPWARD()
    {
        return PWARD;
    }

    public void setPWARD( String pWARD )
    {
        PWARD = pWARD;
    }

    public String getPBEDNO()
    {
        return PBEDNO;
    }

    public void setPBEDNO( String pBEDNO )
    {
        PBEDNO = pBEDNO;
    }

    public String getORCID()
    {
        return ORCID;
    }

    public void setORCID( String oRCID )
    {
        ORCID = oRCID;
    }

    public String getORCUNIT()
    {
        return ORCUNIT;
    }

    public void setORCUNIT( String oRCUNIT )
    {
        ORCUNIT = oRCUNIT;
    }

    public String getORCTYPE()
    {
        return ORCTYPE;
    }

    public void setORCTYPE( String oRCTYPE )
    {
        ORCTYPE = oRCTYPE;
    }

    public String getOBRNO()
    {
        return OBRNO;
    }

    public void setOBRNO( String oBRNO )
    {
        OBRNO = oBRNO;
    }

    public String getREQNO()
    {
        return REQNO;
    }

    public void setREQNO( String rEQNO )
    {
        REQNO = rEQNO;
    }

    public String getREPNO()
    {
        return REPNO;
    }

    public void setREPNO( String rEPNO )
    {
        REPNO = rEPNO;
    }

    public String getOBRNAME()
    {
        return OBRNAME;
    }

    public void setOBRNAME( String oBRNAME )
    {
        OBRNAME = oBRNAME;
    }

    public String getREPTIME()
    {
        return REPTIME;
    }

    public void setREPTIME( String rEPTIME )
    {
        REPTIME = rEPTIME;
    }

    public String getOBRSTATUS()
    {
        return OBRSTATUS;
    }

    public void setOBRSTATUS( String oBRSTATUS )
    {
        OBRSTATUS = oBRSTATUS;
    }

    public String getOBRREPNAME()
    {
        return OBRREPNAME;
    }

    public void setOBRREPNAME( String oBRREPNAME )
    {
        OBRREPNAME = oBRREPNAME;
    }

    public String getOBXNO()
    {
        return OBXNO;
    }

    public void setOBXNO( String oBXNO )
    {
        OBXNO = oBXNO;
    }

    public String getOBXTYPE()
    {
        return OBXTYPE;
    }

    public void setOBXTYPE( String oBXTYPE )
    {
        OBXTYPE = oBXTYPE;
    }

    public String getOBXNAME()
    {
        return OBXNAME;
    }

    public void setOBXNAME( String oBXNAME )
    {
        OBXNAME = oBXNAME;
    }

    public String getOBXNAMEID()
    {
        return OBXNAMEID;
    }

    public void setOBXNAMEID( String oBXNAMEID )
    {
        OBXNAMEID = oBXNAMEID;
    }

    public String getOBXRESULT()
    {
        return OBXRESULT;
    }

    public void setOBXRESULT( String oBXRESULT )
    {
        OBXRESULT = oBXRESULT;
    }

    public String getOBXRANGE()
    {
        return OBXRANGE;
    }

    public void setOBXRANGE( String oBXRANGE )
    {
        OBXRANGE = oBXRANGE;
    }

    public String getOBXUNIT()
    {
        return OBXUNIT;
    }

    public void setOBXUNIT( String oBXUNIT )
    {
        OBXUNIT = oBXUNIT;
    }

    public String getOBXFLAG()
    {
        return OBXFLAG;
    }

    public void setOBXFLAG( String oBXFLAG )
    {
        OBXFLAG = oBXFLAG;
    }

    public String getOBXMETHOD()
    {
        return OBXMETHOD;
    }

    public void setOBXMETHOD( String oBXMETHOD )
    {
        OBXMETHOD = oBXMETHOD;
    }

    public String getREQTIME()
    {
        return REQTIME;
    }

    public void setREQTIME( String rEQTIME )
    {
        REQTIME = rEQTIME;
    }

    public String getOBXNAMECODE()
    {
        return OBXNAMECODE;
    }

    public void setOBXNAMECODE( String oBXNAMECODE )
    {
        OBXNAMECODE = oBXNAMECODE;
    }

    public String getSPECIMEN()
    {
        return SPECIMEN;
    }

    public void setSPECIMEN( String sPECIMEN )
    {
        SPECIMEN = sPECIMEN;
    }

    public String getRectime()
    {
        return rectime;
    }

    public void setRectime( String rectime )
    {
        this.rectime = rectime;
    }

    @Override
    public String toString()
    {
        return "LISREPORT [MSGTYPE=" + MSGTYPE + ", MSGID=" + MSGID + ", PATIENTID=" + PATIENTID + ", IDNO=" + IDNO + ", PNAME=" + PNAME + ", VISITD=" + VISITD + ", PDEPT=" + PDEPT + ", PWARD=" + PWARD + ", PBEDNO=" + PBEDNO + ", ORCID=" + ORCID + ", ORCUNIT=" + ORCUNIT + ", ORCTYPE=" + ORCTYPE + ", OBRNO=" + OBRNO + ", REQNO=" + REQNO + ", REPNO=" + REPNO + ", OBRNAME=" + OBRNAME + ", REQTIME=" + REQTIME + ", REPTIME=" + REPTIME + ", OBRSTATUS=" + OBRSTATUS + ", OBRREPNAME=" + OBRREPNAME + ", OBXNO=" + OBXNO + ", OBXTYPE=" + OBXTYPE + ", OBXNAMECODE=" + OBXNAMECODE + ", OBXNAME=" + OBXNAME + ", OBXNAMEID=" + OBXNAMEID + ", OBXRESULT=" + OBXRESULT + ", OBXRANGE=" + OBXRANGE + ", OBXUNIT=" + OBXUNIT + ", OBXFLAG=" + OBXFLAG + ", OBXMETHOD=" + OBXMETHOD + ", SPECIMEN=" + SPECIMEN + ", rectime=" + rectime + "]";
    }
    
}
