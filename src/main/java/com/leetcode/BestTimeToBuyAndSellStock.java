package com.leetcode;

/**
 * 121. Best Time to Buy and Sell Stock
 * @link https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description
 *
 * @author wangjf
 * @date 2017/7/14.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i : prices) {
            min = i < min ? i : min;
            profit = (i - min) > profit ? i - min : profit;
        }

        return profit;

    }

}
