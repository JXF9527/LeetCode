package levelOrder102;

import dataStructure.TreeNode;

import java.util.*;

public class Solution {
    /**
     * 队列辅助，层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> nodelist = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list;
        TreeNode node;
        int length;
        if (root == null)
            return ans;
        nodelist.add(root);

        while (!nodelist.isEmpty()) {
            length = nodelist.size();
            list = new ArrayList<>();
            while (length-- > 0) {
                node = nodelist.poll();
                list.add(node.val);
                if (node.left != null)
                    nodelist.add(node.left);
                if (node.right != null)
                    nodelist.add(node.right);
            }
            ans.add(list);
        }

        return ans;
    }

    /**
     * 递归实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, 0, root);
        return ans;
    }

    private void helper(List<List<Integer>> ans, int deepth, TreeNode node) {
        if (node == null)
            return;
        if (deepth >= ans.size())
            ans.add(new ArrayList<>());

        ans.get(deepth).add(node.val);

        helper(ans, deepth + 1, node.left);
        helper(ans, deepth + 1, node.right);
    }
}
