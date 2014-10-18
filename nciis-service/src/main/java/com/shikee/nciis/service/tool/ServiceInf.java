package com.shikee.nciis.service.tool;

/**
 * Created by Administrator on 14-10-15.
 */
public interface ServiceInf {
    // 核查方法  
    public String nciicCheck(String inLicense,String inConditions);
    // 取得条件文件模板 
    public String nciicGetCondition(String inLicense) throws Exception;
}
