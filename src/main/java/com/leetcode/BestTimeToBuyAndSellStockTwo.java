package com.leetcode;

/**
 * 122. Best Time to Buy and Sell Stock II
 * @link https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/#/description
 *
 * @author wangjf
 * @date 2017/7/14.
 */
public class BestTimeToBuyAndSellStockTwo {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int diff = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            diff = prices[i + 1] - prices[i];
            if (diff >= 0) {
                profit += diff;
            }
        }

        return profit;
    }

}
