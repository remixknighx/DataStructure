package com.leetcode.easy;

/**
 * 458. Poor Pigs
 * @link https://leetcode.com/problems/poor-pigs/description/
 *
 * @author wangjf
 * @date 2018/3/25 0025.
 */
public class PoorPigs {

    public static void main(String[] args) {
        System.out.println(new PoorPigs().poorPigs(4, 20, 30));
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if(buckets <= 1)
            return 0;
        // How many buckets is 1 pig can try in $minutesToTest
        int k = (minutesToTest / minutesToDie) + 1;
        int x = 1;
        while(x <= buckets){
            if(Math.pow(k, x) >= buckets)
                return x;
            ++x;
        }
        return -1;
    }

}
