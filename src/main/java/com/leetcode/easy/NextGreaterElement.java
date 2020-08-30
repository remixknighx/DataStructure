package com.leetcode.easy;

/**
 * 496. Next Greater Element I
 *
 * @author wangjf
 * @link https://leetcode.com/problems/next-greater-element-i/description/
 * @date 2018/4/30 0030.
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = {2 ,4};
        int[] nums2 = {1, 2, 3, 4};
        int[] result = new NextGreaterElement().nextGreaterElement(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        int num1Length = nums1.length;
        int num2Length = nums2.length;
        for (int i = 0; i < num1Length; i++) {
            for (int j = 0; j < num2Length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (j == num2Length - 1) {
                        result[i] = -1;
                    } else {
                        for (int k = j + 1; k < num2Length; k++) {
                            if (nums2[k] > nums1[i]) {
                                result[i] = nums2[k];
                                break;
                            }
                            if (k == num2Length - 1) {
                                result[i] = -1;
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }

        return result;
    }

}
