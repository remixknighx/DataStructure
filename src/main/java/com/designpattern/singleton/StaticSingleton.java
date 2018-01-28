package com.designpattern.singleton;

/**
 * 3. 使用内部类实现单例模式，性能最高
 *
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public class StaticSingleton {

    private StaticSingleton(){}

    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }

}
