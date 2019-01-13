package com.interview;

/**
 * @author wangjf
 * @date 2019/1/13 0013.
 */
public class Child extends Parent {

    static {
        System.out.println("child static");
    }

    {
        System.out.println("child code block");
    }

    public Child(){
        System.out.println("child construct method ");
    }

    public Child(String childName){
        System.out.println("child construct method childName: " + childName);
    }

    public void doSomething(){
        System.out.println("child do something");
    }

}
