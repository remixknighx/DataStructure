package com.guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class SampleMain {

    @Inject
    @Named("simple")
    private IHelloPrinter simplePrinter;

    @Inject
    @Named("complex")
    private IHelloPrinter complexPrinter;

    private void hello(){
        simplePrinter.print();
        complexPrinter.print();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GuiceModule());
        SampleMain sampleMain = injector.getInstance(SampleMain.class);
        sampleMain.hello();
    }

}
