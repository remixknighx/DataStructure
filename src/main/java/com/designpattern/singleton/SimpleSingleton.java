package com.designpattern.singleton;

/**
 * 1.简单的单例实现
 * */
public class SimpleSingleton {

    private SimpleSingleton(){}

    private static SimpleSingleton singleton = new SimpleSingleton();

    public static SimpleSingleton getSingleton() {
        return singleton;
    }

}
