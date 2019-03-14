package com.xinglin.hl7.tongji.dao;

import java.util.ArrayList;

import com.xinglin.hl7.tongji.vo.Basicinfo;

public interface IBasicinfoDAO
{
    boolean doCreate( ArrayList<Basicinfo> basicinfo ) throws Throwable;
}
