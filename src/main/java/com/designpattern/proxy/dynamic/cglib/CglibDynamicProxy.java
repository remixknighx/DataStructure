package com.designpattern.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib动态代理
 *
 * @author wangjf
 * @date 2018/2/4 0004.
 */
public class CglibDynamicProxy implements MethodInterceptor {

    public static <T> T getInstance(Class<T> targetClass){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        // 回调方法
        enhancer.setCallback(new CglibDynamicProxy());
        // 创建代理对象
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        Object result = methodProxy.invokeSuper(obj, args);
        return result;
    }
}
