package com.algorithm;

import java.util.Stack;

/**
 * 如何判定括号合法性
 */
public class ValidateBrackets {

    public static void main(String[] args) {
        System.out.println(isValid("((({}{}[[]])))"));
    }

   static boolean isValid(String str) {
        Stack<Character> left = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                left.push(c);
            else // 字符 c 是右括号
                if (!left.empty() && leftOf(c) == left.peek())
                    left.pop();
                else
                    // 和最近的左括号不匹配
                    return false;
        }
        // 是否所有的左括号都被匹配了
        return left.empty();
    }

    static char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }

}
