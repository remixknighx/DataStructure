package com.leetcode;


/**
 * 205. Isomorphic Strings
 * @link https://leetcode.com/problems/isomorphic-strings/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 21 14:27
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (m1[(int)s.charAt(i)] != m2[(int)t.charAt(i)]) {
                return false;
            }
            m1[(int)s.charAt(i)] = i + 1;
            m2[(int)t.charAt(i)] = i + 1;
        }

        return true;

    }

}
