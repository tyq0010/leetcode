package com.tyq.leetcode.palindromenumber;

class Solution2 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int s = 0;
        while (s < x) {
            s = s * 10 + x % 10;
            if (s == x || s == x / 10) {
                return true;
            }
            x /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean palindrome = new Solution2().isPalindrome(4321);
        System.out.println(palindrome);
    }
}