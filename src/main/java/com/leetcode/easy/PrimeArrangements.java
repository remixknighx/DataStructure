package com.leetcode.easy;

import java.util.Arrays;

/**
 * [1175] Prime Arrangements
 *
 * @link https://leetcode.com/problems/prime-arrangements/description/
 */
public class PrimeArrangements {

    public int numPrimeArrangements(int n) {
        int MOD = 1000000007;
        int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int primesCount = Math.abs(Arrays.binarySearch(primes, n) + 1);
        int nonPrimes = n - primesCount;

        long pp = 1; // permutation of primes
        long np = 1; // permutation of non-primes
        while (primesCount > 1) {
            pp = (pp * primesCount--) % MOD;
        }
        while (nonPrimes > 1) {
            np = (np * nonPrimes--) % MOD;
        }
        return (int) ((pp * np) % MOD);
    }

}
