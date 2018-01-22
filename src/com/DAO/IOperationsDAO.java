/**
 * 
 */
package com.DAO;

import java.util.ArrayList;

import com.VO.OPERATIONS;

/**
 * @author baobao
 *
 */
public interface IOperationsDAO
{

    // 增加
    public boolean doCreate( ArrayList<OPERATIONS> operations ) throws Throwable;

}
