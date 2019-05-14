package com.guice;

import javax.inject.Singleton;

@Singleton
public class SimpleHelloPrinter implements IHelloPrinter{

    @Override
    public void print() {
        System.out.println("Simple Hello Printer");
    }

}
