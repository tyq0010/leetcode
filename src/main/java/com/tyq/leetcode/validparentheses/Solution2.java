package com.tyq.leetcode.validparentheses;

class Solution2 {
    public boolean isValid(String s) {
        final int len = s.length();
        if (len % 2 == 1) {
            return false;
        } else if (len == 0) {
            return true;
        }
        final char[] stack = new char[len / 2];
        int index = -1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                if (index < stack.length - 1) {
                    stack[++index] = c;
                } else {
                    return false;
                }
            } else if (c == ')' && (index < 0 || stack[index--] != '(')) {
                return false;
            } else if (c == '}' && (index < 0 || stack[index--] != '{')) {
                return false;
            } else if (c == ']' && (index < 0 || stack[index--] != '[')) {
                return false;
            }
        }
        return index < 0;
    }

    public static void main(String[] args) {
        boolean palindrome = new Solution2().isValid("(()(");
        System.out.println(palindrome);
    }
}