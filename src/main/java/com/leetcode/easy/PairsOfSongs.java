package com.leetcode.easy;

/**
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 * @link https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/
 */
public class PairsOfSongs {

    public static void main(String[] args) {
        int[] time1 = {30,20,150,100,40};
        int[] time2 = {60,60,60};
        System.out.println(numPairsDivisibleBy60(time1));
        System.out.println(numPairsDivisibleBy60(time2));

    }

    public static int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[60];
        int count=0;

        for(int n : time){
            int rem = n % 60;
            int comp = (60-rem);
            if(map[comp % 60] > 0) {
                count += map[comp % 60];
            }
            map[rem]++;
        }
        return count;
    }

}
