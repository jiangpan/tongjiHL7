package com.xinglin.hl7.tongji.vo;

public class LisReport
{
    private String msgType;    // MSH.9
    private String msgId;      // MSH.1
    private String patientid;  // PID.2
    private String idNo;       // PID.3.1
    private String pName;      // PID.5
    private String visitd;     // PV1.19
    private String pDept;      // PV1.3.1
    private String pWard;      // PV1.3.2
    private String pBedno;     // PV1.3.3
    private String orcId;      // ORC.1
    private String orcUnit;    // ORC.16
    private String orcType;    // ORC.29
    private String obrNo;      // OBR.1
    private String reqNo;      // OBR.2
    private String repNo;      // OBR.3
    private String obrName;    // OBR.4
    private String reqTime;    // OBR.7
    private String repTime;    // OBR.22
    private String obrStatus;  // OBR.25
    private String obrRepname; // OBR.47.2
    private String obxNo;      // OBX.1
    private String obxType;    // OBX.2
    private String obxNameCode;// OBX.3.1
    private String obxName;    // OBX.3.2
    private String obxNameId;  // OBX.4
    private String obxResult;  // OBX.5
    private String obxRange;   // OBX.7
    private String obxUnit;    // OBX.8
    private String obxFlag;    // OBX.11
    private String obxMethod;  // OBX.17
    private String specimen;   // OBR.15
    private String recTime;    // OBR.14

    public String getMsgType()
    {
        return msgType;
    }

    public void setMsgType( String msgType )
    {
        this.msgType = msgType;
    }

    public String getMsgId()
    {
        return msgId;
    }

    public void setMsgId( String msgId )
    {
        this.msgId = msgId;
    }

    public String getPatientid()
    {
        return patientid;
    }

    public void setPatientid( String patientid )
    {
        this.patientid = patientid;
    }

    public String getIdNo()
    {
        return idNo;
    }

    public void setIdNo( String idNo )
    {
        this.idNo = idNo;
    }

    public String getPName()
    {
        return pName;
    }

    public void setPName( String pName )
    {
        this.pName = pName;
    }

    public String getVisitd()
    {
        return visitd;
    }

    public void setVisitd( String visitd )
    {
        this.visitd = visitd;
    }

    public String getPDept()
    {
        return pDept;
    }

    public void setPDept( String pDept )
    {
        this.pDept = pDept;
    }

    public String getPWard()
    {
        return pWard;
    }

    public void setPWard( String pWard )
    {
        this.pWard = pWard;
    }

    public String getPBedno()
    {
        return pBedno;
    }

    public void setPBedno( String pBedno )
    {
        this.pBedno = pBedno;
    }

    public String getOrcId()
    {
        return orcId;
    }

    public void setOrcId( String orcId )
    {
        this.orcId = orcId;
    }

    public String getOrcUnit()
    {
        return orcUnit;
    }

    public void setOrcUnit( String orcUnit )
    {
        this.orcUnit = orcUnit;
    }

    public String getOrcType()
    {
        return orcType;
    }

    public void setOrcType( String orcType )
    {
        this.orcType = orcType;
    }

    public String getObrNo()
    {
        return obrNo;
    }

    public void setObrNo( String obrNo )
    {
        this.obrNo = obrNo;
    }

    public String getReqNo()
    {
        return reqNo;
    }

    public void setReqNo( String reqNo )
    {
        this.reqNo = reqNo;
    }

    public String getRepNo()
    {
        return repNo;
    }

    public void setRepNo( String repNo )
    {
        this.repNo = repNo;
    }

    public String getObrName()
    {
        return obrName;
    }

    public void setObrName( String obrName )
    {
        this.obrName = obrName;
    }

    public String getRepTime()
    {
        return repTime;
    }

    public void setRepTime( String repTime )
    {
        this.repTime = repTime;
    }

    public String getObrStatus()
    {
        return obrStatus;
    }

    public void setObrStatus( String obrStatus )
    {
        this.obrStatus = obrStatus;
    }

    public String getObrRepname()
    {
        return obrRepname;
    }

    public void setObrRepname( String obrRepname )
    {
        this.obrRepname = obrRepname;
    }

    public String getObxNo()
    {
        return obxNo;
    }

    public void setObxNo( String obxNo )
    {
        this.obxNo = obxNo;
    }

    public String getObxType()
    {
        return obxType;
    }

    public void setObxType( String obxType )
    {
        this.obxType = obxType;
    }

    public String getObxName()
    {
        return obxName;
    }

    public void setObxName( String obxName )
    {
        this.obxName = obxName;
    }

    public String getObxNameId()
    {
        return obxNameId;
    }

    public void setObxNameId( String obxNameId )
    {
        this.obxNameId = obxNameId;
    }

    public String getObxResult()
    {
        return obxResult;
    }

    public void setObxResult( String obxResult )
    {
        this.obxResult = obxResult;
    }

    public String getObxRange()
    {
        return obxRange;
    }

    public void setObxRange( String obxRange )
    {
        this.obxRange = obxRange;
    }

    public String getObxUnit()
    {
        return obxUnit;
    }

    public void setObxUnit( String obxUnit )
    {
        this.obxUnit = obxUnit;
    }

    public String getObxFlag()
    {
        return obxFlag;
    }

    public void setObxFlag( String obxFlag )
    {
        this.obxFlag = obxFlag;
    }

    public String getObxMethod()
    {
        return obxMethod;
    }

    public void setObxMethod( String obxMethod )
    {
        this.obxMethod = obxMethod;
    }

    public String getReqTime()
    {
        return reqTime;
    }

    public void setReqTime( String reqTime )
    {
        this.reqTime = reqTime;
    }

    public String getObxNameCode()
    {
        return obxNameCode;
    }

    public void setObxNameCode( String obxNameCode )
    {
        this.obxNameCode = obxNameCode;
    }

    public String getSpecimen()
    {
        return specimen;
    }

    public void setSpecimen( String specimen )
    {
        this.specimen = specimen;
    }

    public String getRecTime()
    {
        return recTime;
    }

    public void setRecTime( String recTime )
    {
        this.recTime = recTime;
    }

    @Override
    public String toString()
    {
        return "LISREPORT [MSGTYPE=" + msgType + ", MSGID=" + msgId + ", PATIENTID=" + patientid + ", IDNO=" + idNo + ", PNAME=" + pName + ", VISITD=" + visitd + ", PDEPT=" + pDept + ", PWARD=" + pWard + ", PBEDNO=" + pBedno + ", ORCID=" + orcId + ", ORCUNIT=" + orcUnit + ", ORCTYPE=" + orcType + ", OBRNO=" + obrNo + ", REQNO=" + reqNo + ", REPNO=" + repNo + ", OBRNAME=" + obrName + ", REQTIME=" + reqTime + ", REPTIME=" + repTime + ", OBRSTATUS=" + obrStatus + ", OBRREPNAME=" + obrRepname + ", OBXNO=" + obxNo + ", OBXTYPE=" + obxType + ", OBXNAMECODE=" + obxNameCode + ", OBXNAME=" + obxName + ", OBXNAMEID=" + obxNameId + ", OBXRESULT=" + obxResult + ", OBXRANGE=" + obxRange + ", OBXUNIT=" + obxUnit + ", OBXFLAG=" + obxFlag + ", OBXMETHOD=" + obxMethod + ", SPECIMEN=" + specimen + ", rectime=" + recTime + "]";
    }
}
