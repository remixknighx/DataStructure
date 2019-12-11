package com.designpattern.proxy;

/**
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public class DBQueryProxy implements IDBQuery {

    private IDBQuery dbQuery = null;

    @Override
    public String request() {

        if(dbQuery == null){
            dbQuery = new DBQuery();
        }
        return dbQuery.request();
    }
}
