package com.DAO;

import java.util.ArrayList;

import com.VO.TEMPERATURE;

public interface ITemperatureDAO
{
    boolean doCreate( ArrayList<TEMPERATURE> temp ) throws Throwable;
}
