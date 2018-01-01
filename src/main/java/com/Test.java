package com;

import java.util.*;

/**
 * @author wangjf
 * @date 2017 - 07 - 29 21:26
 */
public class Test {

    public static void main(String[] args) {
        Map<Integer, String> linkedHashSet = new TreeMap<Integer, String>();
        linkedHashSet.put(1, "one");
        linkedHashSet.put(2, "two");
        linkedHashSet.put(3, "three");
        linkedHashSet.put(4, "four");
        Set<Map.Entry<Integer, String>> iterator = linkedHashSet.entrySet();
        for (Map.Entry<Integer, String> singleEntry: iterator) {
            System.out.println("Key: " + singleEntry.getKey() + "Value: " + singleEntry.getValue());
        }
    }

}
