package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * @link https://leetcode.com/problems/word-pattern/tabs/description
 *
 * @author wangjf
 * @date 2017 - 07 - 28 23:23
 */
public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(new WordPattern().wordPattern(pattern, str));
    }

    public boolean wordPattern(String pattern, String str) {
        String[] strList = str.split(" ");

        if (pattern.length() != strList.length) {
            return false;
        }

        Map<Character, String> patternMap = new HashMap<Character, String>();
        patternMap.put(pattern.charAt(0), strList[0]);

        for (int i = 1; i < pattern.length(); i++) {
            if (patternMap.containsKey(pattern.charAt(i))) {
                if (!patternMap.get(pattern.charAt(i)).equals(strList[i])) {
                    return false;
                }
            } else {
                if (patternMap.containsValue(strList[i])) {
                    return false;
                } else {
                    patternMap.put(pattern.charAt(i), strList[i]);
                }
            }
        }

        return true;
    }

}
