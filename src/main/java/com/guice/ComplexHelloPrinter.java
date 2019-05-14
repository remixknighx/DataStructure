package com.guice;

import javax.inject.Singleton;

@Singleton
public class ComplexHelloPrinter implements IHelloPrinter {

    @Override
    public void print() {
        System.out.println("Comlex Hello Printer");
    }

}
