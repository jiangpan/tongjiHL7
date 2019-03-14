package com.xinglin.hl7.tongji.dao;

import java.util.ArrayList;

import com.xinglin.hl7.tongji.vo.LisReport;

public interface ILisreportDAO
{
    boolean doCreate( ArrayList<LisReport> temp ) throws Throwable;
}
