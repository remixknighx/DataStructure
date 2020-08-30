package com.leetcode.easy;

/**
 * 461 Hamming Distance
 * @link https://leetcode.com/problems/hamming-distance/description/
 *
 * @author wangjf
 * @date 2018/4/1 0001.
 */
public class HammingDistance {

    public static void main(String[] args) {
        int x = 4;
        int y = 1;
        System.out.println(new HammingDistance().hammingDistance(x, y));
    }

    public int hammingDistance(int x, int y){
        String xBinary = addZero(x);
        String yBinary = addZero(y);

        int count = 0;
        for (int i = 31; i >= 0; i--) {
            if(xBinary.charAt(i) != yBinary.charAt(i)){
                count ++;
            }
        }

        return count;
    }

    private String addZero(int num){

        String result = Integer.toBinaryString(num);
        int needNum = 32 - result.length();
        for (int i = 0; i < needNum; i++) {
            result = "0" + result;
        }

        return result;
    }

}
