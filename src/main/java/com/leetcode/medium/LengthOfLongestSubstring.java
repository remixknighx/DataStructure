package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * [3] Longest Substring Without Repeating Characters
 *
 * @link https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("ab"));
//        System.out.println(lengthOfLongestSubstring(" "));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 滑动窗口解法
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int res = 0, l = 0;

        for (int i = 0; i < s.length(); i++) {
            while (charSet.contains(s.charAt(i))) {
                charSet.remove(s.charAt(l));
                l+=1;
            }
            charSet.add(s.charAt(i));
            res = Math.max(res, i-l+1);
        }
        return res;
    }

//    public static int lengthOfLongestSubstring(String s) {
//        if (s.length() == 1) {
//            return 1;
//        }
//
//        int result = 0;
//        List<Character> containedList = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            int count = 1;
//            containedList.add(s.charAt(i));
//            for (int j = i+1; j < s.length(); j++) {
//                count++;
//                if (containedList.contains(s.charAt(j))) {
//                    count--;
//                    containedList.clear();
//                    break;
//                } else {
//                    containedList.add(s.charAt(j));
//                }
//            }
//            result = count > result ? count : result;
//        }
//        return result;
//    }

}
