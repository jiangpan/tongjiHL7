/**
 * 
 */
package com.DAO;

import java.util.ArrayList;

import com.VO.DIAGNOSIS;

/**
 * @author baobao
 *
 */
public interface IDiagnosisDAO
{

    // 增加
    public boolean doCreate( ArrayList<DIAGNOSIS> diagnosis ) throws Throwable;
}
