package com.xinglin.hl7.tongji.dao;

import java.util.ArrayList;

import com.xinglin.hl7.tongji.vo.Operation;

public interface IOperationsDAO
{
    boolean doCreate( ArrayList<Operation> operations ) throws Throwable;
}
