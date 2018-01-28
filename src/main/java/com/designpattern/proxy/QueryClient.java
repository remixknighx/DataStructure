package com.designpattern.proxy;

/**
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public class QueryClient {

    public static void main(String[] args) {
        IDBQuery idbQuery = new DBQueryProxy();
        System.out.println(idbQuery.request());
    }

}
