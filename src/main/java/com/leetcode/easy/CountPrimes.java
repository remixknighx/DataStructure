package com.leetcode.easy;

import java.util.Arrays;

/**
 * 204. Count Primes
 * @link https://leetcode.com/problems/count-primes/#/description
 *
 * @author wangjf
 * @date 2017 - 07 - 21 14:04
 */
public class CountPrimes {

    public static void main(String[] args) {

        System.out.println(new CountPrimes().countPrimes(5));
    }

    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        for(int i = 2; i < n; i++){
            if(prime[i]){
                // ��i��2����3����4��...�����Ϊ������
                for(int j = i * 2; j < n; j =  j + i){
                    prime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(prime[i]) count++;
        }
        return count;
    }

    private boolean isPrime(int num){
        if (num < 2) {// ������С��2
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {// ���ܱ���������˵����������������false
                    return false;
                }
            }
        }
        return true;
    }

}
