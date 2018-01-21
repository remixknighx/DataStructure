package com.concurrent.master;

/**
 * @author wangjf
 * @date 2018/1/21 0021.
 */
public class PlusWorker extends Worker {

    public Object handle(Object input){
        Integer i = (Integer) input;
        return i * i * i;
    }

}
