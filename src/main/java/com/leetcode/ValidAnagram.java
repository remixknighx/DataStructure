package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 242. Valid Anagram
 * @link https://leetcode.com/problems/valid-anagram/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 25 21:11
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        List<Character> list = new ArrayList<Character>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        for (int j = 0; j < t.length(); j++) {
            if (list.contains(t.charAt(j))) {
                list.remove((Character) t.charAt(j));
            }
        }

        if (list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
