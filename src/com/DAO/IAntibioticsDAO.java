package com.DAO;

import java.util.ArrayList;

import com.VO.ANTIBIOTICS;

public interface IAntibioticsDAO
{
    boolean doCreate( ArrayList<ANTIBIOTICS> antibiotics ) throws Throwable;
}
