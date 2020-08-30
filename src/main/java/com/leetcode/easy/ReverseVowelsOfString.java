package com.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangjf
 * @date 2017 - 07 - 29 20:50
 */
public class ReverseVowelsOfString {

    public static void main(String[] args) {
        ReverseVowelsOfString reverseVowelsOfString = new ReverseVowelsOfString();
        String s = "Aa";
        System.out.println(reverseVowelsOfString.reverseVowels(s));
    }

    public String reverseVowels(String s) {
        List<Character> vowelList = new LinkedList<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                vowelList.add(s.charAt(i));
            }
        }

        if (vowelList.size() == 0) {
            return s;
        }

        StringBuffer result = new StringBuffer();
        int count = vowelList.size() - 1;
        for (int j = 0; j < s.length(); j++) {
            if (isVowel(s.charAt(j))) {
                result.append(vowelList.get(count--));
            } else {
                result.append(s.charAt(j));
            }
        }

        return result.toString();
    }

    private boolean isVowel(Character character) {
        switch (character) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

}
