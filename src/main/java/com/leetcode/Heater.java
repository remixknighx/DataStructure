package com.leetcode;

import java.util.Arrays;

/**
 * 475. Heaters
 * @link https://leetcode.com/problems/heaters/description/
 *
 * @author wangjf
 * @date 2018/4/1 0001.
 */
public class Heater {

    public static void main(String[] args) {
//        int[] houses = {1,2,3,5,15};
//        int[] heaters = {2,30};

//        int[] houses = {1,2,3,4};
//        int[] heaters = {1,4};

        int[] houses = {1};
        int[] heaters = {1,2,3,4};
        System.out.println(~ -4);
    }

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(heaters);
        int result = 0;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = ~index;
                int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

                result = Math.max(result, Math.min(dist1, dist2));
            }
        }

        return result;
    }

}
