package com.xinglin.hl7.tongji.vo;

public class Diagnosis
{
    private String msgType;
    private String msgId;
    private String pName;
    private String patientid;
    private String visitid;
    private String diagnosisNo;
    private String diagnosisType;
    private String diagnosisType2;
    private String diagnosisDesc;
    private String diagnosisCode;
    private String diagnosisDate;

    public String getPatientid()
    {
        return patientid;
    }

    public void setPatientid( String patientid )
    {
        this.patientid = patientid;
    }

    public String getVisitid()
    {
        return visitid;
    }

    public void setVisitid( String visitid )
    {
        this.visitid = visitid;
    }

    public String getDiagnosisNo()
    {
        return diagnosisNo;
    }

    public void setDiagnosisNo( String diagnosisNo )
    {
        this.diagnosisNo = diagnosisNo;
    }

    public String getDiagnosisType()
    {
        return diagnosisType;
    }

    public void setDiagnosisType( String diagnosisType )
    {
        this.diagnosisType = diagnosisType;
    }

    public String getDiagnosisType2()
    {
        return diagnosisType2;
    }

    public void setDiagnosisType2( String diagnosisType )
    {
        this.diagnosisType2 = diagnosisType;
    }

    public String getDiagnosisDesc()
    {
        return diagnosisDesc;
    }

    public void setDiagnosisDesc( String diagnosisDesc )
    {
        this.diagnosisDesc = diagnosisDesc;
    }

    public String getDiagnosisCode()
    {
        return diagnosisCode;
    }

    public void setDiagnosisCode( String diagnosisCode )
    {
        this.diagnosisCode = diagnosisCode;
    }

    public String getDiagnosisDate()
    {
        return diagnosisDate;
    }

    public void setDiagnosisDate( String diagnosisDate )
    {
        this.diagnosisDate = diagnosisDate;
    }

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

    public String getPName()
    {
        return pName;
    }

    public void setPName( String pName )
    {
        this.pName = pName;
    }
}
