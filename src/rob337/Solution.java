package rob337;

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
     * 递归，当前节点不抢劫，则其左右孩子可抢；当前节点抢劫，则其左右孩子的左右孩子可抢；取其中和最大的
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = 0, right = 0;
        if (node.left != null)
            left = dfs(node.left.left) + dfs(node.left.right);

        if (node.right != null)
            right = dfs(node.right.left) + dfs(node.right.right);

        return Math.max(dfs(node.left) + dfs(node.right), left + right + node.val);
    }

    /**
     * 后序遍历，修改节点val为最大可抢值
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {
        if (root == null)
            return 0;
        tryRob(root);
        return root.val;
    }

    private void tryRob(TreeNode node) {
        if (node.left != null)
            tryRob(node.left);

        if (node.right != null)
            tryRob(node.right);

        int sum1 = 0;
        int sum2 = node.val;

        if (node.left != null) {
            sum1 += node.left.val;
            if (node.left.left != null)
                sum2 += node.left.left.val;
            if (node.left.right != null)
                sum2 += node.left.right.val;
        }

        if (node.right != null) {
            sum1 += node.right.val;
            if (node.right.left != null)
                sum2 += node.right.left.val;
            if (node.right.right != null)
                sum2 += node.right.right.val;
        }

        node.val = sum1 > sum2 ? sum1 : sum2;
    }
}
