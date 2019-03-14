package com.xinglin.hl7.tongji.vo;

public class Temperature
{
    private String msgType;  // MSH.9
    private String msgId;    // MSH.1
    private String patientid;// PID.2
    private String idNo;     // PID.3.1
    private String name;     // PID.5
    private String visitid;  // PV1.19
    private String dept;     // PV1.3.1
    private String ward;     // PV1.3.2
    private String bedno;    // PV1.3.3
    private String orcId;    // ORC.1
    private String orcType;  // ORC.29
    private String obrNo;    // OBR.1
    private String obrName;  // OBR.4
    private String obxNo;    // OBX.1
    private String obxType;  // OBX.2
    private String obxName;  // OBX.3
    private String obxResult;// OBX.5
    private String obxUnit;  // OBX.6
    private String obxFlag;  // OBX.11
    private String obxTime;  // OBX.14

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

    public void setMsgId( String mSGID )
    {
        this.msgId = mSGID;
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

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getVisitid()
    {
        return visitid;
    }

    public void setVisitid( String visitd )
    {
        this.visitid = visitd;
    }

    public String getDept()
    {
        return dept;
    }

    public void setDept( String dept )
    {
        this.dept = dept;
    }

    public String getWard()
    {
        return ward;
    }

    public void setWard( String ward )
    {
        this.ward = ward;
    }

    public String getBedno()
    {
        return bedno;
    }

    public void setBedno( String bedno )
    {
        this.bedno = bedno;
    }

    public String getObrName()
    {
        return obrName;
    }

    public void setObrName( String obrName )
    {
        this.obrName = obrName;
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

    public String getObxResult()
    {
        return obxResult;
    }

    public void setObxResult( String obxResult )
    {
        this.obxResult = obxResult;
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

    public String getObxTime()
    {
        return obxTime;
    }

    public void setObxTime( String obxTime )
    {
        this.obxTime = obxTime;
    }

    public String getOrcId()
    {
        return orcId;
    }

    public void setOrcId( String orcId )
    {
        this.orcId = orcId;
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
}