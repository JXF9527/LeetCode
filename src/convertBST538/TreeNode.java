package convertBST538;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int sum = 0;

    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            //遍历右子树
            convertBST(root.right);
            //遍历顶点
            root.val += sum;
            sum = root.val;
            //遍历左子树
            convertBST(root.left);
        }
        return root;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public TreeNode convertBST2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()){
            while (node != null){
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            node.val += sum;
            sum = node.val;
            //左子树
            node = node.left;
        }
        return root;
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
