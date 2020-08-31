package maxPathSum124;

import dataStructure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        //左右子树和为负则置为0， 表示最大路径不包含子树
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0 , dfs(node.right));
        //最大路径包含左右两子树
        max = Math.max(node.val + left + right, max);
        //最大路径包含一子树
        return (right > left ? right : left) + node.val;
    }
}