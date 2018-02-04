package com.designpattern.proxy.dynamic.cglib;

import com.designpattern.proxy.dynamic.jdk.BookFacadeImpl;

/**
 * @author wangjf
 * @date 2018/2/4 0004.
 */
public class TestCglib {

    public static void main(String[] args) {
        BookFacadeCglibProxy cglib = new BookFacadeCglibProxy();
        BookFacadeCglib bookCglib = (BookFacadeCglib) cglib.getInstance(new BookFacadeCglib());
        bookCglib.addBook();
    }

}
