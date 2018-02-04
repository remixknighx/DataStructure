package com.designpattern.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理类
 * 缺陷：JDK需要绑定接口, cglib中修复了该缺陷
 *
 * @author wangjf
 * @date 2018/2/4 0004.
 */
public class BookFacadeProxy implements InvocationHandler {

    private Object target;

    /**
     * 绑定委托对象并返回一个代理类
     * */
    public Object bind(Object target){
        this.target = target;

        // 取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        System.out.println("事物开始");
        result = method.invoke(target, args);
        System.out.println("事物结束");

        return result;
    }
}
