package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * [131] Palindrome Partitioning
 * @link https://leetcode.com/problems/palindrome-partitioning/description/
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new PalindromePartitioning().partition(s));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        doPartition(s, 0, "", result, new ArrayList<>());
        return result;
    }

    private void doPartition(String s, int start, String temp, List<List<String>> result, List<String> single) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(single));
            return;
        }

        for (int i = 1; i < s.length(); i++) {

        }

    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        return stack.size() <= 1;
    }

}
