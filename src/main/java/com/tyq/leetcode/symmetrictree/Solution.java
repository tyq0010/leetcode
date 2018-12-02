package com.tyq.leetcode.symmetrictree;


import java.util.Stack;

/**
 * Definition for a binary tree node.
 * <pre>{@code
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * }</pre>
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        TreeNode leftP = root.left;
        TreeNode rightP = root.right;
        while (leftP != null || rightP != null || !leftStack.isEmpty() || !rightStack.isEmpty()) {
            if (leftP != null && rightP != null) {
                if (leftP.val != rightP.val) {
                    return false;
                }
                leftStack.push(leftP);
                rightStack.push(rightP);
                leftP = leftP.left;
                rightP = rightP.right;
            } else {
                if (leftP != null || rightP != null) {
                    return false;
                }
                leftP = leftStack.pop();
                rightP = rightStack.pop();
                leftP = leftP.right;
                rightP = rightP.left;
            }
        }
        return true;
    }
}