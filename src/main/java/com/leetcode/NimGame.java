package com.leetcode;

/**
 * 292. Nim Game
 * @link https://leetcode.com/problems/nim-game/tabs/description
 *
 * @author wangjf
 * @date 2017 - 07 - 28 23:51
 */
public class NimGame {

    public static void main(String[] args) {
        int n = 6;
        System.out.println(new NimGame().canWinNim(n));
    }

    /**
     * 当n∈[1,3]时，先手必胜。
     *
     * 当n == 4时，无论先手第一轮如何选取，下一轮都会转化为n∈[1,3]的情形，此时先手必负。
     *
     * 当n∈[5,7]时，先手必胜，先手分别通过取走[1,3]颗石头，可将状态转化为n == 4时的情形，此时后手必负。
     *
     * 当n == 8时，无论先手第一轮如何选取，下一轮都会转化为n∈[5,7]的情形，此时先手必负。
     */
    public boolean canWinNim(int n) {
        if (n % 4 == 0){
            return false;
        }

        return true;
    }

}
