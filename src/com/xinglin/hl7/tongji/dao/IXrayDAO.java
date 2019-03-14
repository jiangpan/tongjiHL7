package com.xinglin.hl7.tongji.dao;

import java.util.ArrayList;

import com.xinglin.hl7.tongji.vo.Xray;

public interface IXrayDAO
{
    boolean doCreate( ArrayList<Xray> xray ) throws Throwable;
}
