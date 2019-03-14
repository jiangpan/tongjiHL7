package com.xinglin.hl7.tongji.dao;

import java.util.ArrayList;

import com.xinglin.hl7.tongji.vo.Diagnosis;

public interface IDiagnosisDAO
{
    boolean doCreate( ArrayList<Diagnosis> diagnosis ) throws Throwable;
}
