/**
 * 
 */
package com.DAO;

import java.util.ArrayList;

import com.VO.XRAY;

/**
 * @author baobao
 *
 */
public interface IXrayDAO
{

    // 增加
    public boolean doCreate( ArrayList<XRAY> xray ) throws Throwable;
}
