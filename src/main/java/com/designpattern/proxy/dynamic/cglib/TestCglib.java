package com.designpattern.proxy.dynamic.cglib;

/**
 * @author wangjf
 * @date 2018/2/4 0004.
 */
public class TestCglib {

    public static void main(String[] args) {
        BookFacadeCglib bookCglib = CglibDynamicProxy.getInstance(BookFacadeCglib.class);
        bookCglib.addBook();
        bookCglib.addBook("Harry Potter");

    }

}
