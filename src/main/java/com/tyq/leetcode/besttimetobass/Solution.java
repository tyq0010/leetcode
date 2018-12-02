package com.tyq.leetcode.besttimetobass;

import java.util.Arrays;
import java.util.Random;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int high = prices[prices.length - 1];
        int low;
        int maxValue = 0;

        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > high) {
                high = prices[i];
            } else if (prices[i] < high) {
                if (high - prices[i] > maxValue) {
                    low = prices[i];
                    maxValue = high - low;
                }
            }
        }
        return maxValue;
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
        System.out.println(new Solution().maxProfit(prices));
    }
}