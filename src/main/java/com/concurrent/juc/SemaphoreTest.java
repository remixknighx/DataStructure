package com.concurrent.juc;

import java.util.regex.Pattern;

public class SemaphoreTest {

    public static void main(String[] args) {
        String strEl = "^\\d{8}$";
        Pattern pattern = Pattern.compile(strEl);

        String num = "01905439";
        System.out.println(num.matches(strEl));

        Long nullLong = null;
        System.out.println(nullLong.longValue());
    }

}
