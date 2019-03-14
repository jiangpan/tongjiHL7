package com.DAO;

import java.util.ArrayList;

import com.VO.XRAY;

public interface IXrayDAO
{
    boolean doCreate( ArrayList<XRAY> xray ) throws Throwable;
}
