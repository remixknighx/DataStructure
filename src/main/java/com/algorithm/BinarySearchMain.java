package com.algorithm;

/**
 * 二分查找
 *
 * @author wangjianfeng
 */
public class BinarySearchMain {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(new BinarySearchMain().binary_search(nums1, 2));

        int[] nums2 = {1, 2, 2, 2, 4};
        System.out.println(new BinarySearchMain().left_bound(nums2, 2));

        System.out.println(new BinarySearchMain().right_bound(nums2, 2));
    }

    /**
     * 二分查找
     */
    int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }


    /**
     * 寻找左侧边界的二分查找
     */
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }

    /**
     * 寻找右侧边界的二分查找
     */
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

}
