package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * @link https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * @author wangjf
 * @date 2018/2/16 0016.
 */
public class FindDisappearedNums {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            nums[idx] = (nums[idx] > 0) ? -nums[idx]: nums[idx];
        }

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] > 0){
                result.add(j + 1);
            }
        }

        return result;
    }

}
