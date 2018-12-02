package com.tyq.leetcode.validparentheses;

class Solution {
    public boolean isValid(String s) {
        final int len = s.length();
        if (len % 2 == 1) {
            return false;
        } else if (len == 0) {
            return true;
        }
        final char[] stack = new char[len / 2];
        final char[] brackets = new char[]{'(', '{', '[', ')', '}', ']'};
        int index = -1;
        for (int i = 0; i < len; i++) {
            final char c = s.charAt(i);
            boolean push = false;
            for (int j = 0; j < brackets.length / 2; j++) {
                if (c == brackets[j]) {
                    if (index < stack.length - 1) {
                        stack[++index] = c;
                        push = true;
                        break;
                    } else {
                        return false;
                    }
                }
            }
            if (push) {
                continue;
            }
            for (int j = 0; j < brackets.length / 2; j++) {
                if (c == brackets[j + brackets.length / 2]) {
                    if (index >= 0 && stack[index--] == brackets[j]) {
                        break;
                    } else {
                        return false;
                    }
                }
            }
        }
        return index < 0;
    }

    public static void main(String[] args) {
        boolean palindrome = new Solution().isValid("(())");
        System.out.println(palindrome);
    }
}