package com.designpattern.flyweight;

/**
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public class FlyWeightClient {

    public static void main(String[] args) {
        ReportManagerFactory rmf = new ReportManagerFactory();
        IReportManager rm = rmf.getFinancialReportManger("a");
        System.out.println(rm.createReport());
    }

}
