/**
 * 
 */
package com.DAO;

import java.util.ArrayList;

import com.VO.ANTIBIOTICS;

/**
 * @author baobao
 *
 */
public interface IAntibioticsDAO
{

    // 增加
    public boolean doCreate( ArrayList<ANTIBIOTICS> antibiotics ) throws Throwable;
}
