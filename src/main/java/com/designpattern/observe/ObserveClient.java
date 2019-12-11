package com.designpattern.observe;

import java.util.Observer;

/**
 * @author wangjf
 * @date 2018/2/4 0004.
 */
public class ObserveClient {

    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer binaryObserver = new BinaryObserver();
        Observer octalObserver = new OctalObserver();
        subject.addObserver(binaryObserver);
        subject.addObserver(octalObserver);

        subject.printSubject();
    }

}
