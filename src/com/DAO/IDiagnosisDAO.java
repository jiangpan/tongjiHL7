package com.DAO;

import java.util.ArrayList;

import com.VO.DIAGNOSIS;

public interface IDiagnosisDAO
{
    boolean doCreate( ArrayList<DIAGNOSIS> diagnosis ) throws Throwable;
}
