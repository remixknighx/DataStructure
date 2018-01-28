package com.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public class ReportManagerFactory {

    Map<String, IReportManager> financilReportManager = new HashMap<String, IReportManager>();

    IReportManager getFinancialReportManger(String tenantId){
        IReportManager r = financilReportManager.get(tenantId);
        if(r == null){
            r = new FinancialReportManager(tenantId);
            financilReportManager.put(tenantId, r);
        }

        return r;
    }

}
