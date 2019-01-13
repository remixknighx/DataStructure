package com.interview;

/**
 * @author wangjf
 * @date 2019/1/13 0013.
 */
public class Parent {

    static {
        System.out.println("parent static");
    }

    {
        System.out.println("parent code block");
    }

    public Parent(){
        System.out.println("parent construct method");
    }

    private void doSomethind(){
        System.out.println("parent do something");
    }

}
