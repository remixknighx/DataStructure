package com.leetcode;

/**
 * 1475. Final Prices With a Special Discount in a Shop
 * @link https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * @author wangjianfeng
 */
public class FinalPricesWithSpecialDiscount {

    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        System.out.println(new FinalPricesWithSpecialDiscount().finalPrices(prices));
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println(new FinalPricesWithSpecialDiscount().finalPrices(prices2));
        int[] prices3 = {10, 1, 1, 6};
        System.out.println(new FinalPricesWithSpecialDiscount().finalPrices(prices3));
    }

    public int[] finalPrices(int[] prices) {

        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            result[i] = prices[i];
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return result;
    }

}
