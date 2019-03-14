package com.DAO;

import java.util.ArrayList;

import com.VO.OPERATIONS;

public interface IOperationsDAO
{
    boolean doCreate( ArrayList<OPERATIONS> operations ) throws Throwable;
}
