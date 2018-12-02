package com.tyq.leetcode.besttimetobass3;

import java.util.Arrays;
import java.util.Random;

class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley;
        int peak;
        int maxProfit = 0;
        int[] a = new int[]{-1, -1, -1, -1, -1, -1};
        int tradeCount = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];

            if (tradeCount == 2 && a[4] != -1 && (a[2] > a[4] || a[0] > a[4]) && a[3] - a[2] > a[5] - a[4] && valley > a[4]) {
                valley = a[4];
            }
            a[tradeCount * 2] = valley;
            a[tradeCount * 2 + 1] = peak;
            tradeCount++;
            if (tradeCount > 2) {
                tradeCount = 2;
                int profit1 = maxProfit(a, 0) + a[5] - a[4];
                int profit2 = maxProfit(a, 2) + a[1] - a[0];
                if (profit1 >= profit2) {
                    merge(a, 0);
                    maxProfit = profit1;
                } else {
                    merge(a, 2);
                    maxProfit = profit2;
                }
            } else {
                maxProfit += peak - valley;
            }
        }
        return maxProfit;
    }

    private int maxProfit(int[] a, int i) {
        return a[1 + i] < a[3 + i] ? a[3 + i] - Math.min(a[i], a[2 + i]) : Math.max(a[1 + i] - a[i], a[3 + i] - a[2 + i]);
    }

    private void merge(int[] a, int i) {
        if (a[1 + i] < a[3 + i]) {
            a[i] = Math.min(a[i], a[2 + i]);
            a[1 + i] = a[3 + i];
        } else if (a[1 + i] - a[i] <= a[3 + i] - a[2 + i]) {
            a[i] = a[2 + i];
            a[1 + i] = a[3 + i];
        }
        if (i == 0) {
            a[2] = a[4];
            a[3] = a[5];
        }
    }

    public static void main(String[] args) {
        test0();
        for (int i = 0; i < 100; i++) {
            test();
        }
    }

    private static void test0() {
        int[] prices = {18, 9957, 1, 9996, 2, 9769, 9641, 9972};

        System.out.println(Arrays.toString(prices));
        System.out.println(new Solution().maxProfit(prices));
    }

    private static void test() {
        Random random = new Random();
        int len = random.nextInt(20);
        int[] prices = new int[len];
        for (int i = 0; i < len; i++) {
            prices[i] = random.nextInt(random.nextInt(20) + 1) + 1;
        }
        System.out.println(Arrays.toString(prices));
        System.out.println(new Solution().maxProfit(prices));
    }
}
