package com.leetcode.easy;

/**
 * 492. Construct the Rectangle
 * @link https://leetcode.com/problems/construct-the-rectangle/description/
 *
 * @author wangjf
 * @date 2018/4/30 0030.
 */
public class ConstructRectangle {

    public static void main(String[] args) {
        int area = 3;
        int[] result = new ConstructRectangle().constructRectangle(area);
        System.out.println("length = " + result[0] + " width = " + result[1]);
    }

    public int[] constructRectangle(int area) {
        int[] result = new int[2];

        int smallDiff = Integer.MAX_VALUE;
        for (int l = 1; l <= area; l++) {
            int w = area / l;
            if(area % l == 0){
                if(l - w >= 0 && l - w < smallDiff){
                    smallDiff = l - w;
                    result[0] = l;
                    result[1] = w;
                }
            }
        }

        return result;
    }

}
