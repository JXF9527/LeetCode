package buildTree105;

import dataStructure.TreeNode;
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
public class Solution {
    private int pre = 0;

    /**
     * 遍历先序数组，在中序数组中寻找根，以根为界限划分左右子树，递归左右子树。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if(pre >= preorder.length)
            return null;
        if(start > end)
            return null;
        TreeNode node = new TreeNode(preorder[pre]);
        int i;
        for (i = start; i <= end; ++i) {
            if(inorder[i] == preorder[pre])
                break;
        }
        ++pre;
        if(start == end)
            i = start;
        node.left = helper(preorder, inorder, start, i - 1);
        node.right = helper(preorder, inorder, i + 1, end);
        return node;
    }

}