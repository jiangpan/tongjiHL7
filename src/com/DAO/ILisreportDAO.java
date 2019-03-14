package com.DAO;

import java.util.ArrayList;

import com.VO.LISREPORT;

public interface ILisreportDAO
{
    boolean doCreate( ArrayList<LISREPORT> temp ) throws Throwable;
}
