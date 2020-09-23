package com.leetcode.medium;

/**
 * [264] Ugly Number II
 *
 * @link https://leetcode.com/problems/ugly-number-ii/description/
 */
public class UglyNumberTwo {

    public static void main(String[] args) {
//        System.out.println(new UglyNumberTwo().nthUglyNumber(1352));
        String str = "0,1,6";
        String[] strArray = str.split(",");
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].equals("6")) {
                strArray[i] = "5";
            }
            if (strArray[i].equals("5")) {
                strArray[i] = "6";
            }
        }
        System.out.println(String.join(",", strArray));
    }

    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int ugly = 0, i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < n; i++) {
            nums[i] = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            ugly = nums[i];

            if (ugly == nums[i2] * 2) {
                i2++;
            }
            if (ugly == nums[i3] * 3) {
                i3++;
            }
            if (ugly == nums[i5] * 5) {
                i5++;
            }
        }
        return nums[n-1];
    }


}
