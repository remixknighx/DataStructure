package com.leetcode.easy;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 * @link https://leetcode.com/problems/assign-cookies/description/
 *
 * @author wangjf
 * @date 2018/3/25 0025.
 */
public class AssignCookies {

    public static void main(String[] args) {
        int[] children = {1, 2, 3, 7, 2, 5, 4};
        int[] cookies = {3};
        System.out.println(new AssignCookies().findContentChildren(children, cookies));
    }

    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int person = 0;

        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < s.length; i++) {
            for (int j = person; j < g.length; j++) {
                if(g[j] <= s[i]){
                    count++;
                    person++;
                    break;
                }
            }
        }

        return count;
    }
}
