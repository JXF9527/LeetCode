package flatten114;

import dataStructure.*;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<TreeNode> list;

    /**
     * 暴力求解
     * @param root
     */
    public void flatten2(TreeNode root) {
        list = new ArrayList<>();
        helper(root);
        TreeNode node = root;
        TreeNode p = root;
        for (int i = 1; i < list.size(); ++i) {
            p = list.get(i);
            node.left = null;
            node.right = p;
            node = p;
        }
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;
        list.add(root);
        helper(root.left);
        helper(root.right);
    }

    private TreeNode last = null;
    /**
     * 右向后序遍历，在还没操作节点右子树前，不能破坏该节点的右子树指向。所以采用后序遍历
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = last;
        last = root;
    }
}
