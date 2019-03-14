package com.DAO;

import java.util.ArrayList;

import com.VO.BASICINFO;

public interface IBasicinfoDAO
{
    boolean doCreate( ArrayList<BASICINFO> basicinfo ) throws Throwable;
}
