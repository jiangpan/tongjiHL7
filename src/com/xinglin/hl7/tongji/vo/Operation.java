package com.xinglin.hl7.tongji.vo;

public class Operation
{
    private String msgType;         // MSH.9
    private String msgId;           // MSH.10
    private String sapplyId;        // SCH.1
    private String sapplyReason;    // SCH.6
    private String sapplyTime;      // SCH.11.4
    private String sDept;           // SCH.28
    private String patientid;       // PID.2
    private String pType;           // PV1.2
    private String visitid;         // PV1.19
    private String operNo;          // AIS.1
    private String operCode;        // AIS.3.1
    private String operName;        // AIS.3.2
    private String operClass;       // AIS.3.3
    private String operStarttime;   // AIS.4
    private String quantum;         // AIS.7
    private String quantumUnit;     // AIS.8
    private String location;        // AIS.11
    private String grade;           // AIS.12
    private String operEndtime;     // AIS.13
    private String woundGrade;      // AIS.14
    private String nnis;            // AIS.15
    private String heal;            // AIS.16
    private String operType;        // AIS.17
    private String embed;           // AIS.18
    private String endoscopic;      // AIS.19
    private String bloodout;        // AIS.20
    private String bloodin;         // AIS.21
    private String anesthesiaMethod;// AIG.4
    private String asa;             // AIG.14
    private String room;            // AIL.3.2
    private String tableNo;         // AIL.3.9
    private String aipNo;           // AIP.1
    private String aipsNo;          // AIP.3.1
    private String aipsName;        // AIP.3.2
    private String aipsCode;        // AIP.4.1
    private String aipsType;        // AIP.4.2
    private String surgeon;
    private String surgeonCode;
    private String firstAs;
    private String firstAsCode;
    private String anesthesia;
    private String anesthesiaCode;

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

    public String getSapplyId()
    {
        return sapplyId;
    }

    public void setSapplyId( String sapplyId )
    {
        this.sapplyId = sapplyId;
    }

    public String getSapplyReason()
    {
        return sapplyReason;
    }

    public void setSapplyReason( String sapplyReason )
    {
        this.sapplyReason = sapplyReason;
    }

    public String getSapplyTime()
    {
        return sapplyTime;
    }

    public void setSapplyTime( String sapplyTime )
    {
        this.sapplyTime = sapplyTime;
    }

    public String getSDept()
    {
        return sDept;
    }

    public void setSDept( String sDept )
    {
        this.sDept = sDept;
    }

    public String getPatientid()
    {
        return patientid;
    }

    public void setPatientid( String patientid )
    {
        this.patientid = patientid;
    }

    public String getPType()
    {
        return pType;
    }

    public void setPType( String pType )
    {
        this.pType = pType;
    }

    public String getVisitid()
    {
        return visitid;
    }

    public void setVisitid( String visitid )
    {
        this.visitid = visitid;
    }

    public String getOperNo()
    {
        return operNo;
    }

    public void setOperNo( String operNo )
    {
        this.operNo = operNo;
    }

    public String getOperCode()
    {
        return operCode;
    }

    public void setOperCode( String operCode )
    {
        this.operCode = operCode;
    }

    public String getOperName()
    {
        return operName;
    }

    public void setOperName( String operName )
    {
        this.operName = operName;
    }

    public String getOperClass()
    {
        return operClass;
    }

    public void setOperClass( String operClass )
    {
        this.operClass = operClass;
    }

    public String getOperStarttime()
    {
        return operStarttime;
    }

    public void setOperStarttime( String operStarttime )
    {
        this.operStarttime = operStarttime;
    }

    public String getQuantum()
    {
        return quantum;
    }

    public void setQuantum( String quantum )
    {
        this.quantum = quantum;
    }

    public String getQuantumUnit()
    {
        return quantumUnit;
    }

    public void setQuantumUnit( String quantumUnit )
    {
        this.quantumUnit = quantumUnit;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation( String location )
    {
        this.location = location;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade( String grade )
    {
        this.grade = grade;
    }

    public String getOperEndtime()
    {
        return operEndtime;
    }

    public void setOperEndtime( String operEndtime )
    {
        this.operEndtime = operEndtime;
    }

    public String getWoundGrade()
    {
        return woundGrade;
    }

    public void setWoundGrade( String woundGrade )
    {
        this.woundGrade = woundGrade;
    }

    public String getNnis()
    {
        return nnis;
    }

    public void setNnis( String nnis )
    {
        this.nnis = nnis;
    }

    public String getHeal()
    {
        return heal;
    }

    public void setHeal( String heal )
    {
        this.heal = heal;
    }

    public String getOperType()
    {
        return operType;
    }

    public void setOperType( String operType )
    {
        this.operType = operType;
    }

    public String getEmbed()
    {
        return embed;
    }

    public void setEmbed( String embed )
    {
        this.embed = embed;
    }

    public String getEndoscopic()
    {
        return endoscopic;
    }

    public void setEndoscopic( String endoscopic )
    {
        this.endoscopic = endoscopic;
    }

    public String getBloodout()
    {
        return bloodout;
    }

    public void setBloodout( String bloodout )
    {
        this.bloodout = bloodout;
    }

    public String getBloodin()
    {
        return bloodin;
    }

    public void setBloodin( String bloodin )
    {
        this.bloodin = bloodin;
    }

    public String getAnesthesiaMethod()
    {
        return anesthesiaMethod;
    }

    public void setAnesthesiaMethod( String anesthesiaMethod )
    {
        this.anesthesiaMethod = anesthesiaMethod;
    }

    public String getAsa()
    {
        return asa;
    }

    public void setAsa( String asa )
    {
        this.asa = asa;
    }

    public String getRoom()
    {
        return room;
    }

    public void setRoom( String room )
    {
        this.room = room;
    }

    public String getTableNo()
    {
        return tableNo;
    }

    public void setTableNo( String tableNo )
    {
        this.tableNo = tableNo;
    }

    public String getAipNo()
    {
        return aipNo;
    }

    public void setAipNo( String aipNo )
    {
        this.aipNo = aipNo;
    }

    public String getAipsNo()
    {
        return aipsNo;
    }

    public void setAipsNo( String aipsNo )
    {
        this.aipsNo = aipsNo;
    }

    public String getAipsName()
    {
        return aipsName;
    }

    public void setAipsName( String aipsName )
    {
        this.aipsName = aipsName;
    }

    public String getAipsCode()
    {
        return aipsCode;
    }

    public void setAipsCode( String aipsCode )
    {
        this.aipsCode = aipsCode;
    }

    public String getAipsType()
    {
        return aipsType;
    }

    public void setAipsType( String aipsType )
    {
        this.aipsType = aipsType;
    }

    public String getSurgeon()
    {
        return surgeon;
    }

    public void setSurgeon( String surgeon )
    {
        this.surgeon = surgeon;
    }

    public String getSurgeonCode()
    {
        return surgeonCode;
    }

    public void setSurgeonCode( String surgeonCode )
    {
        this.surgeonCode = surgeonCode;
    }

    public String getFirstAs()
    {
        return firstAs;
    }

    public void setFirstAs( String firstAs )
    {
        this.firstAs = firstAs;
    }

    public String getFirstAsCode()
    {
        return firstAsCode;
    }

    public void setFirstAsCode( String firstAsCode )
    {
        this.firstAsCode = firstAsCode;
    }

    public String getAnesthesia()
    {
        return anesthesia;
    }

    public void setAnesthesia( String anesthesia )
    {
        this.anesthesia = anesthesia;
    }

    public String getAnesthesiaCode()
    {
        return anesthesiaCode;
    }

    public void setAnesthesiaCode( String anesthesiaCode )
    {
        this.anesthesiaCode = anesthesiaCode;
    }
}