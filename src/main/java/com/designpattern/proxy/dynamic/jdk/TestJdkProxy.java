package com.designpattern.proxy.dynamic.jdk;

/**
 * @author wangjf
 * @date 2018/2/4 0004.
 */
public class TestJdkProxy {

    public static void main(String[] args) {
        BookFacade bookFacade = JdkProxyHelper.createProxy(BookFacade.class, BookFacadeImpl.class);
        bookFacade.addBook();
        bookFacade.addBook("The Ring");
    }

}
