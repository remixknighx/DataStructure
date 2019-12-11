package com.reactor;


import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author wangjf
 * @date 2019/3/17 0017.
 */
public class IKMProcessor {

    class Dece{

    }

    public static void main(String[] args) {
        Predicate<String> lengther = (s) -> s.length()<2;
        Predicate<String> equlizer = Predicate.isEqual("car");
        Function<Boolean, String> booleaner = i -> Boolean.toString(i);
        Function<String, Boolean> stringer = s -> Boolean.parseBoolean(s);
        System.out.println(stringer.compose(booleaner).apply(true));
        System.out.println(lengther.negate().or(equlizer).test("CAR"));
        System.out.println(booleaner.compose(stringer).apply("true").substring(0, 3));
        System.out.println(booleaner.apply(true));

    }

}

interface MyInterface{
    void method1();
    default void method2(){
        System.out.println("test");
    }
}

class Parent implements MyInterface{

    @Override
    public void method1() {

    }

    @Override
    public void method2() {
        MyInterface.super.method2();
    }
}
