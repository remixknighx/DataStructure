package com.leetcode;

/**
 * 485. Max Consecutive Ones
 * @link https://leetcode.com/problems/max-consecutive-ones/description/
 *
 * @author wangjf
 * @date 2018/4/6 0006.
 */
public class FindMaxConsecOnes {

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(new FindMaxConsecOnes().findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 1){
            return nums[0] == 1? 1: 0;
        }

        int count = 0;
        int max = count;

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(nums[i] == 1){
                count++;
                if(max < count){
                    max = count;
                }
            }else{
                count = 0;
            }
        }

        return max;
    }

}
