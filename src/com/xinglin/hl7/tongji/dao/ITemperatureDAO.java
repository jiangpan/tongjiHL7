package com.xinglin.hl7.tongji.dao;

import java.util.ArrayList;

import com.xinglin.hl7.tongji.vo.Temperature;

public interface ITemperatureDAO
{
    boolean doCreate( ArrayList<Temperature> temp ) throws Throwable;
}
