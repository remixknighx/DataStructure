package com.designpattern.proxy.dynamic.cglib;

/**
 * @author wangjf
 * @date 2018/2/4 0004.
 */
public class BookFacadeCglib {

    public void addBook(){
        System.out.println("增加图书的普通方法...");
    }

    public void addBook(String bookName) {
        System.out.println("增加图书：" + bookName);
    }

}
