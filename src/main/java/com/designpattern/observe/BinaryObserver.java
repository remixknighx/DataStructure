package com.designpattern.observe;

import java.util.Observable;
import java.util.Observer;

/**
 * @author wangjf
 * @date 2018/2/4 0004.
 */
public class BinaryObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Binary String:");
    }
}
