package com.xinglin.hl7.tongji.dao;

import java.util.ArrayList;

import com.xinglin.hl7.tongji.vo.Antibiotics;

public interface IAntibioticsDAO
{
    boolean doCreate( ArrayList<Antibiotics> antibiotics ) throws Throwable;
}
