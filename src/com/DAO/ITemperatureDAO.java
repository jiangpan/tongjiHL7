/**
 * 
 */
package com.DAO;

import java.util.ArrayList;

import com.VO.TEMPERATURE;

/**
 * @author baobao
 *
 */
public interface ITemperatureDAO
{

    // 增加
    public boolean doCreate( ArrayList<TEMPERATURE> temp ) throws Throwable;
}
