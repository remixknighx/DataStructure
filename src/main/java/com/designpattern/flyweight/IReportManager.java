package com.designpattern.flyweight;

/**
 * 享元模式
 * 以提高系统性能为目的的模式之一
 * 核心思想是：如果在一个系统中存在多个相同的对象，那么只需要共享一份对象的拷贝，
 * 而不必为每一次使用都创建新的对象
 *
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public interface IReportManager {

    public String createReport();

}
