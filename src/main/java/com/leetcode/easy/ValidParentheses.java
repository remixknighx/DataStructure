package com.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 20. Valid Parentheses
 * @link https://leetcode.com/problems/valid-parentheses/#/description
 *
 * @author wangjf
 * @date 2017/7/2 0002.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        String brackets = "(){}[]";
        LinkedList<Character> stack = new LinkedList<Character>();

        for (int i = 0; i < s.length(); i ++) {
            char character = s.charAt(i);
            if (brackets.indexOf(character) != -1) {
                if (stack.size() == 0) {
                    stack.addLast(character);
                } else {
                    int fist = Bracket.getNum(stack.getLast()) + 1;
                    int second = Bracket.getNum(character);
                    if (fist == second && second % 2 ==0) {
                        stack.removeLast();
                    } else {
                        stack.addLast(character);
                    }
                }
            }
        }

        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    enum Bracket {
        LEFT_CURVE(1, '('),
        RIGHT_CURVE(2, ')'),
        LEFT_BRACE(3, '{'),
        RIGHT_BRACE(4, '}'),
        LEFT_SQURE(5, '['),
        RIGHT_SQURE(6, ']');

        private char bracket;
        private int num;

        Bracket(int num, char bracket) {
            this.num = num;
            this.bracket = bracket;
        }

        public static int getNum(char s) {
            for (Bracket bracket: Bracket.values()) {
                if(bracket.getBracket() == s) {
                    return bracket.getNum();
                }
            }
            return -1;
        }

        /* get and set */
        public char getBracket() {
            return bracket;
        }

        public void setBracket(char bracket) {
            this.bracket = bracket;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

}
