package com.designpattern.observe;

import java.util.Observable;

/**
 * @author wangjf
 * @date 2018/2/4 0004.
 */
public class Subject extends Observable {

    public void printSubject(){
        System.out.println("print subject");
        setChanged();
        notifyObservers();
    }

}
