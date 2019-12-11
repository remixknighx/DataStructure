package com.designpattern.proxy.dynamic.jdk;

/**
 * @author wangjf
 * @date 2018/2/4 0004.
 */
public class BookFacadeImpl implements BookFacade {

    @Override
    public void addBook() {
        System.out.println("增加图书方法...");
    }

    @Override
    public void addBook(String bookName) {
        System.out.println("增加图书: " + bookName);
    }


}
