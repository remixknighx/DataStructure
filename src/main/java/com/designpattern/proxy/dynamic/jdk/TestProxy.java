package com.designpattern.proxy.dynamic.jdk;

/**
 * @author wangjf
 * @date 2018/2/4 0004.
 */
public class TestProxy {

    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookFacade.addBook();
    }

}
