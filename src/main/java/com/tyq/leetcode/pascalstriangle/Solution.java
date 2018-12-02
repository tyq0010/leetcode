package com.tyq.leetcode.pascalstriangle;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        new Solution().generate(15);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i + 1);
            list.add(1);
            if (i > 0) {
                for (int j = 1; j < i; j++) {
                    List<Integer> pre = lists.get(i - 1);
                    list.add(pre.get(j - 1) + pre.get(j));
                }
                list.add(1);
            }
            lists.add(list);
        }
        return lists;
    }


}