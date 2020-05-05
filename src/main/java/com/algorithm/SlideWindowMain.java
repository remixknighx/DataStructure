package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口算法技巧
 *
 * @author wangjianfeng
 */
public class SlideWindowMain {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(16523));
        System.out.println(Integer.toBinaryString(8 & 7));
    }

    /**
     * 最小覆盖子串
     * 给定一个字符串S，一个字符串T，请在字符串S里面找出：包含T所有字母的最小子串
     */
    private static String minWindow(String s, String t) {
        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();

        for(char c: t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int match = 0;

        while (right < s.length()) {
            char c1 = s.toCharArray()[right];
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (window.get(c1).equals(needs.get(c1))) {
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char c2 = s.toCharArray()[left];
                if (needs.containsKey(c2)) {
                    int oldCnt = window.get(c2);
                    window.put(c2, --oldCnt);
                    if (window.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE? "": s.substring(start, start+minLen);
    }

    /**
     * 无重复字符的最长子串
     */
    private static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int result = 0;

        Map<Character, Integer> window = new HashMap<>();

        while (right < s.length()) {
            char c1 = s.toCharArray()[right];
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            right++;

            while (window.get(c1) > 1) {
                char c2 = s.toCharArray()[left];
                int c2Cnt = window.get(c2);
                window.put(c2, --c2Cnt);
                left++;
            }
            result = Math.max(result, right - left);
        }

        return result;
    }

}
