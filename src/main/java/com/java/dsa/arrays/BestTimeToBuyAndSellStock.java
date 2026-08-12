package com.java.dsa.arrays;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement
 *
 * You are given an integer array prices where prices[i] represents the price of a given stock on the i-th day.
 *
 * You want to maximize your profit by choosing one day to buy the stock and a different day in the future to sell it.
 *
 * Return the maximum profit you can achieve from this transaction.
 *
 * If no profit is possible, return 0.
 *
 * Constraints
 * You must buy before you sell.
 * You can complete at most one transaction.
 * You cannot sell the stock before buying it.
 * Return 0 if no profitable transaction is possible.
 *
 * Example 1
 * Input:prices = [7, 1, 5, 3, 6, 4]
 * Output:5
 *
 * Explanation: Buy on day 2 at price 1 and sell on day 5 at price 6.
 * Profit = 6 - 1 = 5
 */

public class BestTimeToBuyAndSellStock {


    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        System.out.println("maxProfit ::"+maxProfit(input));
        System.out.println("maxProfitOptimized ::"+maxProfitOptimized(input));

    }

    public static int maxProfit(int[] prices){
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){

            for(int j = i+1; j < prices.length; j++){

                maxProfit = Math.max(
                        maxProfit,
                        prices[j] - prices[i]
                );
            }
        }
        return maxProfit;
    }

    public static int maxProfitOptimized(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price: prices){

            minPrice = Math.min(price, minPrice);
            int currentProfit = price - minPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }
}
