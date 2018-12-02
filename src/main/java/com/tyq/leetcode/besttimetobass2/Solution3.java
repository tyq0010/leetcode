package com.tyq.leetcode.besttimetobass2;

import java.util.Arrays;
import java.util.Random;

class Solution3 {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
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
        System.out.println(new Solution3().maxProfit(prices));
    }
}