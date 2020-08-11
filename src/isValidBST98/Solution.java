package isValidBST98;

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

    /**
     * dfs，或者中序遍历为升序
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        boolean lf = dfs(root.left, Long.MIN_VALUE, root.val);

        boolean rf = dfs(root.right, root.val, Long.MAX_VALUE);

        return lf && rf;

    }

    private boolean dfs(TreeNode node, long low, long high) {
        if (node == null)
            return true;

        if (node.val <= low || node.val >= high) {
            return false;
        }

        if (!dfs(node.left, low, node.val))
            return false;
        if (!dfs(node.right, node.val, high))
            return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(Integer.MAX_VALUE);
        node.right = new TreeNode(Integer.MIN_VALUE);

    }

}
