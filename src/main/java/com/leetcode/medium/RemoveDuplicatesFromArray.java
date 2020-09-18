package com.leetcode.medium;

/**
 * Remove Duplicates from Sorted Array II
 * @link https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 */
public class RemoveDuplicatesFromArray {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(new RemoveDuplicatesFromArray().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        //check if it is an empty array
        if(nums.length == 0) return 0;

        //start pointer of new array
        int m = 1;

        // count the time of duplicate numbers occurence
        int count = 1;

        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] == nums[i - 1]) {
                if(count < 2) {
                    nums[m++] = nums[i];
                }
                count++;
            } else {
                count = 1;
                nums[m++] = nums[i];
            }
        }
        return m;
    }

}
