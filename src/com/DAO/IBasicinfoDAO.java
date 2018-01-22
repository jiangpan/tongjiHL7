/**
 * 
 */
package com.DAO;

import java.util.ArrayList;

import com.VO.BASICINFO;

/**
 * @author baobao
 *
 */
public interface IBasicinfoDAO
{

    // 增加
    public boolean doCreate( ArrayList<BASICINFO> basicinfo ) throws Throwable;
}
