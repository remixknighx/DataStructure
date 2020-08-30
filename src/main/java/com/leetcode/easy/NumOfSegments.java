package com.leetcode.easy;

/**
 * 434. Number Of Segments in a String
 * @link https://leetcode.com/problems/number-of-segments-in-a-string/description/
 *
 * @author wangjf
 * @date 2017/10/2 0002.
 */
public class NumOfSegments {

    public static void main(String[] args) {
        NumOfSegments numOfSegments = new NumOfSegments();
        String s = "Hello, my name is John";
        System.out.println(numOfSegments.countSegments(s));
    }

    public int countSegments(String s) {
        int cnt=0;

        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) != ' ') cnt++;
            //如果当前不是空格,而前一个是空格,+1
            if(i>0 && s.charAt(i-1) == ' ' && s.charAt(i) != ' ')
                cnt++;
        }

        return cnt;
    }

}
