package com.kris.leetcode.easy.array;

/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Note that you cannot sell a stock before you buy one.

 Example 1:

 Input: [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
              Not 7-1 = 6, as selling price needs to be larger than buying price.
 Example 2:

 Input: [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transaction is done, i.e. max profit = 0.
 **/

/**
 * 1 暴力算法：双重 for 循环
 * 2 求出最小值，得到最大的差值
 */
public class BestTimetoBuyandSellStock {


    /**
     * 算法思路： 遍历得到最小的值，得到与最小值之间的最大的差值
     *
     * 想得到最小值，这里设置的时候就要初始化为最大值。
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1;i < prices.length;i ++){
            if(min < prices[i]){
                min = prices[i];
            } else {
                if(prices[i] - min > maxProfit){
                    maxProfit = prices[i] - min;
                }
            }
        }
        return maxProfit;
    }


    /**
     * 暴力解法
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0;i < prices.length-1;i ++){
            for(int j = i+1;j < prices.length;j ++){
                if(prices[j] - prices[i] > maxProfit){
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }
}
