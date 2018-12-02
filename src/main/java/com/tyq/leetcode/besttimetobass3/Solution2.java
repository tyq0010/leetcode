package com.tyq.leetcode.besttimetobass3;

import java.util.Arrays;
import java.util.Random;

class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int m = 2;
        int n = prices.length;
        int[][] dp = new int[m + 1][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            //maxdiff is maximum difference of dp[i-1][k] - prices[k] before and include j-2;
            int maxdiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                maxdiff = Math.max(maxdiff, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxdiff);
            }
        }
        return dp[m][n - 1];
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
        System.out.println(new Solution2().maxProfit(prices));
    }

    private static void test() {
        Random random = new Random();
        int len = random.nextInt(20);
        int[] prices = new int[len];
        for (int i = 0; i < len; i++) {
            prices[i] = random.nextInt(random.nextInt(20) + 1) + 1;
        }
        System.out.println(Arrays.toString(prices));
        System.out.println(new Solution2().maxProfit(prices));
    }
}
