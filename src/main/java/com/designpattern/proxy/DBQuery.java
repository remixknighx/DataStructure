package com.designpattern.proxy;

/**
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public class DBQuery implements IDBQuery {

    public DBQuery(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String request() {
        return "request string";
    }
}
