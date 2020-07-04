package diameterOfBinaryTree543;
import dataStructure.*;
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
    private int maxd = 0;

    /**
     * 递归
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        deepthB(root);
        return maxd;
    }
    public int deepthB(TreeNode root){
        if(root == null)
            return -1;
        int ld = deepthB(root.left) + 1;
        int rd = deepthB(root.right) + 1;
        if(ld + rd > maxd)
            maxd = ld + rd;
        return ld > rd ? ld : rd;
    }


}

