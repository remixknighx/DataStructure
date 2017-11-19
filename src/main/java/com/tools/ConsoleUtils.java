/* Created on 2007-12-12 12:21:44
 *
 * FileName: MyUtils.java Package: project.fjdl.tools.gwcs Version: 1.0 */
package com.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhzeng
 * @history
 *
 * Copyright (C) 2000, 2007, KOAL SOFT.
 */
public class ConsoleUtils {

    public static void pause() {
        try {
            final BufferedReader d = new BufferedReader(new InputStreamReader(
                    System.in));
            d.readLine();
        } catch (final Exception e) {
            // ignore it ...
        }
    }

    public static int inputParam(final String tip, final int defaultValue) {
        ConsoleUtils.writeInt(tip, defaultValue);
        return ConsoleUtils.readInt(defaultValue);
    }

    public static String inputParam(final String tip, final String defaultValue) {
        ConsoleUtils.writeString(tip, defaultValue);
        return readString(defaultValue);
    }

    public static boolean inputParam(final String tip, final boolean defaultValue) {
        ConsoleUtils.writeString(tip, defaultValue ? "Y" : "N");
        return readBoolean(defaultValue);
    }

    public static String readString(final String defaultValue) {

        String sz = null;
        final BufferedReader d = new BufferedReader(new InputStreamReader(
                System.in));
        try {
            sz = d.readLine();
        } catch (final IOException e) {
            // ignore it.
        }

        if ((sz == null) || (sz.length() == 0))
            return defaultValue;

        return sz;
    }

    public static int readInt(final int defaultValue) {
        int choose = defaultValue;
        try {

            choose = Integer.parseInt(ConsoleUtils.readString(String
                    .valueOf(defaultValue)));
        } catch (final Exception e) {
            e.printStackTrace();
            // ignore it.
        }
        return choose;
    }

    public static boolean readBoolean(final boolean defaultValue) {
        boolean b = defaultValue;
        try {
            final String sz = ConsoleUtils.readString(String
                    .valueOf(defaultValue));

            if (sz.equalsIgnoreCase("Y") || sz.equalsIgnoreCase("YES")
                    || sz.equalsIgnoreCase("TRUE")) {
                b = true;
            } else {
                b = false;
            }
        } catch (final Exception e) {
            // ignore it ...
        }

        return b;
    }

    public static void writeString(final String name, final String value) {
        System.out.print(name + ": ");
        if ((value != null) && (value.length() > 0)) {
            System.out.print(value);
            System.out.print("? ");
        }
    }

    public static void writeInt(final String name, final int value) {
        System.out.print(name + ": ");
        System.out.print(value);
        System.out.print("? ");
    }
}