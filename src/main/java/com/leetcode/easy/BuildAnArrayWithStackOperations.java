package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. Build an Array With Stack Operations
 * @link https://leetcode.com/problems/build-an-array-with-stack-operations/
 *
 * @author wangjianfeng
 */
public class BuildAnArrayWithStackOperations {

    public static void main(String[] args) {
        int[] target = {1, 3};
        int n = 3;
        System.out.println(new BuildAnArrayWithStackOperations().buildArray(target, n));
    }

    public List<String> buildArray(int[] target, int n) {
        String PUSH = "Push";
        String POP = "Pop";
        List<String> result = new ArrayList<>();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (target[count] == i) {
                result.add(PUSH);
                count++;
            } else {
                result.add(PUSH);
                result.add(POP);
            }
            if (count >= target.length) {
                break;
            }
        }
        return result;
    }

}
