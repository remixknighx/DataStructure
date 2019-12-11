package com.designpattern.proxy.dynamic.jdk;

import com.google.common.reflect.Reflection;

/**
 * @author wangjianfeng
 */
public class JdkProxyHelper {

    /**
     * 创建代理对象
     */
    public static <T> T createProxy(Class<T> supClass, Class<? extends T> subClass) {
        return Reflection.newProxy(supClass,
                new JdkDynamicProxy(subClass));
    }

}
