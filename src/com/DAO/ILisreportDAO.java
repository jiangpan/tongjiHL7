/**
 * 
 */
package com.DAO;

import java.util.ArrayList;

import com.VO.LISREPORT;

/**
 * @author baobao
 *
 */
public interface ILisreportDAO
{

    // 增加
    public boolean doCreate( ArrayList<LISREPORT> temp ) throws Throwable;
}
