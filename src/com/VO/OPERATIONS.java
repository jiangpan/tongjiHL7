package com.VO;

public class OPERATIONS
{
    private String MSGTYPE;         // MSH.9
    private String MSGID;           // MSH.10
    private String SAPPLYID;        // SCH.1
    private String SAPPLYREASON;    // SCH.6
    private String SAPPLYTIME;      // SCH.11.4
    private String SDEPT;           // SCH.28
    private String PATIENTID;       // PID.2
    private String PTYPE;           // PV1.2
    private String VISITID;         // PV1.19
    private String OPERNO;          // AIS.1
    private String OPERCODE;        // AIS.3.1
    private String OPERNAME;        // AIS.3.2
    private String OPERCLASS;       // AIS.3.3
    private String OPERSTARTTIME;   // AIS.4
    private String QUANTUM;         // AIS.7
    private String QUANTUMUNIT;     // AIS.8
    private String LOCATION;        // AIS.11
    private String ISGRADE;         // AIS.12
    private String OPERENDTIME;     // AIS.13
    private String WOUNDGRADE;      // AIS.14
    private String NNIS;            // AIS.15
    private String HEAL;            // AIS.16
    private String OPERTYPE;        // AIS.17
    private String EMBED;           // AIS.18
    private String ENDOSCOPIC;      // AIS.19
    private String BLOODOUT;        // AIS.20
    private String BLOODIN;         // AIS.21
    private String ANESTHESIAMETHOD;// AIG.4
    private String ASA;             // AIG.14
    private String ROOM;            // AIL.3.2
    private String TAICI;           // AIL.3.9
    private String AIPNO;           // AIP.1
    private String AIPSNO;          // AIP.3.1
    private String AIPSNAME;        // AIP.3.2
    private String AIPSCODE;        // AIP.4.1
    private String AIPSTYPE;        // AIP.4.2
    private String SURGEON;
    private String SURGEONCODE;
    private String FIRSTAS;
    private String FIRSTASCODE;
    private String ANESTHESIA;
    private String ANESTHESIACODE;

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

    public String getSAPPLYID()
    {
        return SAPPLYID;
    }

    public void setSAPPLYID( String sAPPLYID )
    {
        SAPPLYID = sAPPLYID;
    }

    public String getSAPPLYREASON()
    {
        return SAPPLYREASON;
    }

    public void setSAPPLYREASON( String sAPPLYREASON )
    {
        SAPPLYREASON = sAPPLYREASON;
    }

    public String getSAPPLYTIME()
    {
        return SAPPLYTIME;
    }

    public void setSAPPLYTIME( String sAPPLYTIME )
    {
        SAPPLYTIME = sAPPLYTIME;
    }

    public String getSDEPT()
    {
        return SDEPT;
    }

    public void setSDEPT( String sDEPT )
    {
        SDEPT = sDEPT;
    }

    public String getPATIENTID()
    {
        return PATIENTID;
    }

    public void setPATIENTID( String pATIENTID )
    {
        PATIENTID = pATIENTID;
    }

    public String getPTYPE()
    {
        return PTYPE;
    }

    public void setPTYPE( String pTYPE )
    {
        PTYPE = pTYPE;
    }

    public String getVISITID()
    {
        return VISITID;
    }

    public void setVISITID( String vISITID )
    {
        VISITID = vISITID;
    }

    public String getOPERNO()
    {
        return OPERNO;
    }

    public void setOPERNO( String oPERNO )
    {
        OPERNO = oPERNO;
    }

    public String getOPERCODE()
    {
        return OPERCODE;
    }

    public void setOPERCODE( String oPERCODE )
    {
        OPERCODE = oPERCODE;
    }

    public String getOPERNAME()
    {
        return OPERNAME;
    }

    public void setOPERNAME( String oPERNAME )
    {
        OPERNAME = oPERNAME;
    }

    public String getOPERCLASS()
    {
        return OPERCLASS;
    }

    public void setOPERCLASS( String oPERCLASS )
    {
        OPERCLASS = oPERCLASS;
    }

    public String getOPERSTARTTIME()
    {
        return OPERSTARTTIME;
    }

    public void setOPERSTARTTIME( String oPERSTARTTIME )
    {
        OPERSTARTTIME = oPERSTARTTIME;
    }

    public String getQUANTUM()
    {
        return QUANTUM;
    }

    public void setQUANTUM( String qUANTUM )
    {
        QUANTUM = qUANTUM;
    }

    public String getQUANTUMUNIT()
    {
        return QUANTUMUNIT;
    }

    public void setQUANTUMUNIT( String qUANTUMUNIT )
    {
        QUANTUMUNIT = qUANTUMUNIT;
    }

    public String getLOCATION()
    {
        return LOCATION;
    }

    public void setLOCATION( String lOCATION )
    {
        LOCATION = lOCATION;
    }

    public String getISGRADE()
    {
        return ISGRADE;
    }

    public void setISGRADE( String iSGRADE )
    {
        ISGRADE = iSGRADE;
    }

    public String getOPERENDTIME()
    {
        return OPERENDTIME;
    }

    public void setOPERENDTIME( String oPERENDTIME )
    {
        OPERENDTIME = oPERENDTIME;
    }

    public String getWOUNDGRADE()
    {
        return WOUNDGRADE;
    }

    public void setWOUNDGRADE( String wOUNDGRADE )
    {
        WOUNDGRADE = wOUNDGRADE;
    }

    public String getNNIS()
    {
        return NNIS;
    }

    public void setNNIS( String nNIS )
    {
        NNIS = nNIS;
    }

    public String getHEAL()
    {
        return HEAL;
    }

    public void setHEAL( String hEAL )
    {
        HEAL = hEAL;
    }

    public String getOPERTYPE()
    {
        return OPERTYPE;
    }

    public void setOPERTYPE( String oPERTYPE )
    {
        OPERTYPE = oPERTYPE;
    }

    public String getEMBED()
    {
        return EMBED;
    }

    public void setEMBED( String eMBED )
    {
        EMBED = eMBED;
    }

    public String getENDOSCOPIC()
    {
        return ENDOSCOPIC;
    }

    public void setENDOSCOPIC( String eNDOSCOPIC )
    {
        ENDOSCOPIC = eNDOSCOPIC;
    }

    public String getBLOODOUT()
    {
        return BLOODOUT;
    }

    public void setBLOODOUT( String bLOODOUT )
    {
        BLOODOUT = bLOODOUT;
    }

    public String getBLOODIN()
    {
        return BLOODIN;
    }

    public void setBLOODIN( String bLOODIN )
    {
        BLOODIN = bLOODIN;
    }

    public String getANESTHESIAMETHOD()
    {
        return ANESTHESIAMETHOD;
    }

    public void setANESTHESIAMETHOD( String aNESTHESIAMETHOD )
    {
        ANESTHESIAMETHOD = aNESTHESIAMETHOD;
    }

    public String getASA()
    {
        return ASA;
    }

    public void setASA( String aSA )
    {
        ASA = aSA;
    }

    public String getROOM()
    {
        return ROOM;
    }

    public void setROOM( String rOOM )
    {
        ROOM = rOOM;
    }

    public String getTAICI()
    {
        return TAICI;
    }

    public void setTAICI( String tAICI )
    {
        TAICI = tAICI;
    }

    public String getAIPNO()
    {
        return AIPNO;
    }

    public void setAIPNO( String aIPNO )
    {
        AIPNO = aIPNO;
    }

    public String getAIPSNO()
    {
        return AIPSNO;
    }

    public void setAIPSNO( String aIPSNO )
    {
        AIPSNO = aIPSNO;
    }

    public String getAIPSNAME()
    {
        return AIPSNAME;
    }

    public void setAIPSNAME( String aIPSNAME )
    {
        AIPSNAME = aIPSNAME;
    }

    public String getAIPSCODE()
    {
        return AIPSCODE;
    }

    public void setAIPSCODE( String aIPSCODE )
    {
        AIPSCODE = aIPSCODE;
    }

    public String getAIPSTYPE()
    {
        return AIPSTYPE;
    }

    public void setAIPSTYPE( String aIPSTYPE )
    {
        AIPSTYPE = aIPSTYPE;
    }

    public String getSURGEON()
    {
        return SURGEON;
    }

    public void setSURGEON( String sURGEON )
    {
        SURGEON = sURGEON;
    }

    public String getSURGEONCODE()
    {
        return SURGEONCODE;
    }

    public void setSURGEONCODE( String sURGEONCODE )
    {
        SURGEONCODE = sURGEONCODE;
    }

    public String getFIRSTAS()
    {
        return FIRSTAS;
    }

    public void setFIRSTAS( String fIRSTAS )
    {
        FIRSTAS = fIRSTAS;
    }

    public String getFIRSTASCODE()
    {
        return FIRSTASCODE;
    }

    public void setFIRSTASCODE( String fIRSTASCODE )
    {
        FIRSTASCODE = fIRSTASCODE;
    }

    public String getANESTHESIA()
    {
        return ANESTHESIA;
    }

    public void setANESTHESIA( String aNESTHESIA )
    {
        ANESTHESIA = aNESTHESIA;
    }

    public String getANESTHESIACODE()
    {
        return ANESTHESIACODE;
    }

    public void setANESTHESIACODE( String aNESTHESIACODE )
    {
        ANESTHESIACODE = aNESTHESIACODE;
    }
}
