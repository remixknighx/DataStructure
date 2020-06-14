package com.algorithm.dynamic;

import java.util.*;

/**
 * 凑零钱问题
 *
 * @author wangjianfeng
 */
public class PocketMoney {

    public static void main(String[] args) {
        List<Integer> coins = Arrays.asList(1, 2, 5);
        int amount = 8;
        System.out.println(new CoinChange3().coinChange(coins, amount));
    }

}

/**
 * 暴力递归
 *  时间复杂度 O(k * n^k)
 */
class CoinChange1 {

    public int coinChange(List<Integer> coins, Integer amount) {
        return this.doCoinChange(coins, amount);
    }

    private int doCoinChange(List<Integer> coins, Integer n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = this.doCoinChange(coins, n - coin);
            if (subProblem == -1) {
                continue;
            }
            result = Math.min(result, 1 + subProblem);
        }
        return result != Integer.MAX_VALUE ? result : -1;
    }

}

/**
 * 带备忘录的递归
 * 时间复杂度  O(kn)
 */
class CoinChange2 {

    Map<Integer, Integer> memo;

    public CoinChange2(){
        memo = new HashMap<>();
    }

    public int coinChange(List<Integer> coins, Integer amount) {
        return this.doCoinChange(coins, amount);
    }

    private int doCoinChange(List<Integer> coins, Integer n) {

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = this.doCoinChange(coins, n - coin);
            if (subProblem == -1) {
                continue;
            }
            result = Math.min(result, 1 + subProblem);
        }
        memo.put(n, result != Integer.MAX_VALUE ? result : -1);
        return memo.get(n);
    }

}

/**
 * dp数组的迭代解法
 */
class CoinChange3 {

    public int coinChange(List<Integer> coins, int amount) {

        // 数组大小为 amount + 1，初始值也为 amount + 1
        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i <= amount + 1; i++) {
            dp.add(i);
        }

        // base case
        for (int i = 0; i < dp.size(); i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp.set(i, Math.min(dp.get(i), 1 + dp.get(i - coin)));
            }
        }

        return dp.get(amount) == amount + 1 ? -1 : dp.get(amount);
    }

}
