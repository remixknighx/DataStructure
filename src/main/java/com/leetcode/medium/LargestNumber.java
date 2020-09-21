package com.leetcode.medium;

import java.util.*;

/**
 * [179] Largest Number
 * @link https://leetcode.com/problems/largest-number/description/
 */
public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {0, 0};

        System.out.println(new LargestNumber().largestNumber(nums));
//        System.out.println("999999999999999999".compareTo("999999999999999998"));
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        List<Integer> numList = new ArrayList<>();
        for (int num: nums) {
            numList.add(num);
        }
        Collections.sort(numList, (o1, o2) -> (String.valueOf(o2) + String.valueOf(o1)).compareTo(String.valueOf(o1) + String.valueOf(o2)));

        StringBuilder result = new StringBuilder();
        for (int num: numList) {
            result.append(num);
        }

        while (result.charAt(0) == '0' && result.length() > 1) {
            result.deleteCharAt(0);
        }

        return result.toString();
    }

}
