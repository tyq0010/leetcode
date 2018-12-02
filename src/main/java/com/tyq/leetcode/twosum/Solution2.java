package com.tyq.leetcode.twosum;

class Solution2 {

    public int[] twoSum(int[] nums, int target) {
        final int len = nums.length;
        int n = len - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        final int mask = n;
        final int bucketSize = n + 1;
        final int[] bucket = new int[bucketSize];
        final int[] linked = new int[len];

        for (int i = 1; i < len; i++) {
            int curNum = nums[i];
            int complement = target - curNum;
            if (complement == nums[0]) {
                return new int[]{0, i};
            }
            int complementIndex = bucket[complement & mask];
            while (complementIndex != 0) {
                if (nums[complementIndex] == complement) {
                    return new int[]{complementIndex, i};
                }
                complementIndex = linked[complementIndex];
            }
            int curNumIndex = curNum & mask;
            linked[i] = bucket[curNumIndex];
            bucket[curNumIndex] = i;
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}