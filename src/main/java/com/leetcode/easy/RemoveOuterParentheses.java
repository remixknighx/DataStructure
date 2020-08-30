package com.leetcode.easy;

/**
 * [1021] Remove Outermost Parentheses
 * @link https://leetcode.com/problems/remove-outermost-parentheses/description/
 */
public class RemoveOuterParentheses {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()"));
    }

    public static String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            if (count == 0 && S.charAt(i) == '(') {
                count++;
                continue;
            }

            if (S.charAt(i) == '(') {
                result.append("(");
                count++;
            } else {
                count--;
                if (count != 0) {
                    result.append(")");
                }
            }
        }

        return result.toString();
    }

}
