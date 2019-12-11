package com.designpattern.flyweight;

/**
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public class FinancialReportManager implements IReportManager{

    protected String tenantId = null;

    public FinancialReportManager(String tenantId){
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a financial report";
    }
}
