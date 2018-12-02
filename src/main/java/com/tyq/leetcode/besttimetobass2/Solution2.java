package com.tyq.leetcode.besttimetobass2;

import java.util.Arrays;
import java.util.Random;

class Solution2 {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            test();
        }
    }

    private static void test() {
        Random random = new Random();
        int len = random.nextInt(20);
        int[] prices = new int[len];
        for (int i = 0; i < len; i++) {
            prices[i] = random.nextInt(random.nextInt(9) + 1) + 1;
        }
        System.out.println(Arrays.toString(prices));
        System.out.println(new Solution2().maxProfit(prices));
    }
}
