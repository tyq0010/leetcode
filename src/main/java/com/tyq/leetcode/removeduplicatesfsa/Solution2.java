package com.tyq.leetcode.removeduplicatesfsa;

class Solution2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int last = nums[0];
        int len = nums.length;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (last >= num) {
                int duplicates = 1;
                for (int j = k + 1; j < nums.length; j++) {
                    int bigger = nums[j];
                    if (last >= bigger) {
                        duplicates++;
                    } else {
                        break;
                    }
                }
                k += duplicates;
                nums[i] = k > nums.length - 1 ? nums[nums.length - 1] : nums[k];
                last = nums[i];
                len = nums.length - (k - i);
                if (i >= len - 1) {
                    break;
                }
            } else {
                last = num;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = new Solution2().removeDuplicates(nums);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}