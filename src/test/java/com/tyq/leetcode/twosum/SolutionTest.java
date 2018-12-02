package com.tyq.leetcode.twosum;


import org.junit.Test;

/**
 * Created by TYQ on 2018/11/15.
 */
public class SolutionTest {

    @Test
    public void twoSum() {
//        Solution solution = new Solution();
//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;
//        int[] answer = solution.twoSum(nums, target);
//        System.out.println(Arrays.toString(answer));


    }

    @Test
    public void bitTest() {
        byte b = (byte) 0xf1;
        int c = (b >> 4);//有符号右移
        int d = (b >>> 4);//无符号右移（即高位自动填充0）
        byte e = (byte) ((b & 0xff) >> 4);
        System.out.println(b + " " + c + " " + d + " " + e);
    }
}
