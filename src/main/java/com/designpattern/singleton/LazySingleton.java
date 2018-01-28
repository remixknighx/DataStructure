package com.designpattern.singleton;

/**
 * 2. 延迟加载单例
 *
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public class LazySingleton {

    private LazySingleton(){}

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

}
