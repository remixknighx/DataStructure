package com.designpattern.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理类
 * 缺陷：JDK需要绑定接口, cglib中修复了该缺陷
 *
 * @author wangjf
 * @date 2018/2/4 0004.
 */
public class JdkDynamicProxy<T> implements InvocationHandler {

    private Class<T> subClass;

    public JdkDynamicProxy(Class<T> subClass) {
        this.subClass = subClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(subClass.newInstance(), args);
        return result;
    }
}
