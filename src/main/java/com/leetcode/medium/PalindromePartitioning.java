package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * [131] Palindrome Partitioning
 *
 * @link https://leetcode.com/problems/palindrome-partitioning/description/
 */
public class PalindromePartitioning {

    List<List<String>> resultLst;
    ArrayList<String> currLst;

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new PalindromePartitioning().partition(s));
    }

    public List<List<String>> partition(String s) {
        resultLst = new ArrayList<>();
        currLst = new ArrayList<>();
        backTrack(s, 0);
        return resultLst;
    }

    public void backTrack(String s, int l) {
        if (currLst.size() > 0 //the initial str could be palindrome
                && l >= s.length()) {
            resultLst.add(new ArrayList<>(currLst));
            return;
        }
        for (int i = l; i < s.length(); i++) {
            if (isPalindrome(s, l, i)) {
                if (l == i) {
                    currLst.add(Character.toString(s.charAt(i)));
                } else {
                    currLst.add(s.substring(l, i + 1));
                }
                backTrack(s, i + 1);
                currLst.remove(currLst.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int l, int r) {
        if (l == r) {
            return true;
        }
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


}
