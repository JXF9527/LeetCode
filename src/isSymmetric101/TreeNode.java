package isSymmetric101;


import java.util.*;

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
    /**
     * 层次遍历法
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int length = 0;
        int i = 0;
        TreeNode emptynode = new TreeNode(0);
        TreeNode node = null;
        if(root == null)
            return true;
        queue.add(root);
        while (!queue.isEmpty()){
            length = queue.size();
            TreeNode[] aTree = new TreeNode[length];
            queue.toArray(aTree);
            for(i = 0; i < length/2; ++i){
                if(aTree[i] == emptynode && aTree[length - 1 - i] == emptynode)
                    continue;
                if((aTree[i] == emptynode && aTree[length - 1 - i] != emptynode) || (aTree[i] != emptynode && aTree[length - 1 - i] == emptynode))
                    return false;
                if(aTree[i].val != aTree[length - 1 - i].val)
                    return false;
            }
            for(i = 0; i < length; ++i){
                node = queue.poll();
                if(node != emptynode) {
                    queue.add(node.left == null ? emptynode : node.left);
                    queue.add(node.right == null ? emptynode : node.right);
                }
            }
        }
        return true;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        if(t1.val != t2.val)
            return false;
        return helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
