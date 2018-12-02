package com.tyq.leetcode.besttimetobass3;

import java.util.Arrays;
import java.util.Random;

class Solution3 {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int curPrice : prices) {
            if (firstBuy < -curPrice) firstBuy = -curPrice;
            if (firstSell < firstBuy + curPrice) firstSell = firstBuy + curPrice;
            if (secondBuy < firstSell - curPrice) secondBuy = firstSell - curPrice;
            if (secondSell < secondBuy + curPrice) secondSell = secondBuy + curPrice;
        }
        return secondSell;
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
        System.out.println(new Solution3().maxProfit(prices));
    }

    private static void test() {
        Random random = new Random();
        int len = random.nextInt(20);
        int[] prices = new int[len];
        for (int i = 0; i < len; i++) {
            prices[i] = random.nextInt(random.nextInt(20) + 1) + 1;
        }
        System.out.println(Arrays.toString(prices));
        System.out.println(new Solution3().maxProfit(prices));
    }
}
