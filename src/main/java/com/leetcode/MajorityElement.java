package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * @link https://leetcode.com/problems/majority-element/#/description
 *
 * @author wangjf
 * @date 2017/7/18 0018.
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {1,1,1,1,2,3,56,4,1};
        System.out.println(majorityElement.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int maxCount = 0;
        int maxNumber = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count.get(nums[i]) == null) {
                count.put(nums[i], 1);
            } else {
                int temp = count.get(nums[i]);
                temp++;
                count.put(nums[i], temp);

                if(temp > maxCount) {
                    maxCount = temp;
                    maxNumber = nums[i];
                }
            }
        }

        return maxNumber;
    }

}
