package com.reactor;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author wangjf
 * @date 2019/3/16 0016.
 */
public class ReactorTest {

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.soPrivate();
    }

}

class Sup{
    static {
        System.out.println("sup static");
    }
    {
        System.out.println("sup block");
    }
    public Sup(){
        System.out.println("sup construct");
    }
    private void soPrivate(){
        System.out.println("Sup private");
    }
}

class Sub extends Sup{
    static {
        System.out.println("sub static");
    }
    {
        System.out.println("sub block");
    }
    public Sub(){
        System.out.println("sub construct");
    }

    public void soPrivate(){
        System.out.println("Sub private");
    }
}
