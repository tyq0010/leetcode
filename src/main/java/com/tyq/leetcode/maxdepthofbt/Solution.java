package com.tyq.leetcode.maxdepthofbt;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        root.val = 1;
        int max = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.add(node.left);
                node.left.val = node.val + 1;
                max = max < node.left.val ? node.left.val : max;
            }
            if (node.right != null) {
                q.add(node.right);
                node.right.val = node.val + 1;
                max = max < node.right.val ? node.right.val : max;
            }
        }
        return max;
    }
}