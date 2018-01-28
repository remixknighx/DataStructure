package com.designpattern.proxy;

/**
 * 使用代理模式实现了动态加载，动态加载的核心思想是：
 * 如果当前并没有使用这个组件，则不需要真正地初始化它，使用一个代理对象替代它的原有的位置，
 * 只要在真正需要使用的时候，才对它进行加载
 *
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public interface IDBQuery {

    String request();

}
