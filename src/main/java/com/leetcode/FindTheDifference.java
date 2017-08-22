package com.leetcode;

import javax.print.DocFlavor;
import java.util.LinkedList;
import java.util.List;

/**
 * 389. Find the Difference
 * @link https://leetcode.com/problems/find-the-difference/description/
 *
 * @author wangjf
 * @date 2017 - 08 - 22 17:26
 */
public class FindTheDifference {

    public static void main(String[] args) {
        String s1 = "abcdef";
        String t1 = "abcdefg";
        FindTheDifference fid = new FindTheDifference();
        System.out.println(fid.findTheDifference(s1, t1));
    }

    public char findTheDifference(String s, String t) {
        List<Character> list = new LinkedList<Character>();

        for (int i = 0; i < t.length(); i++) {
            list.add(t.charAt(i));
        }

        for (int j = 0; j < s.length(); j++) {
            list.remove((Character) s.charAt(j));
        }

        return list.get(0);
    }
}
