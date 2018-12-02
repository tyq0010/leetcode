package com.tyq.leetcode.besttimetobass2;

import java.util.Arrays;
import java.util.Random;

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
                maxPrice = 0;
            } else {
                if (price > maxPrice) {
                    if (price > minPrice) {
                        if (maxPrice == 0) {
                            maxProfit = maxProfit + price - minPrice;
                        } else {
                            maxProfit = maxProfit + price - maxPrice;
                        }
                        maxPrice = price;
                        minPrice = maxPrice;
                    }
                } else {
                    minPrice = price;
                    maxPrice = 0;
                }

            }
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
            prices[i] = random.nextInt(random.nextInt(2) + 1) + 1;
        }
        System.out.println(Arrays.toString(prices));
        System.out.println(new Solution().maxProfit(prices));
    }
}