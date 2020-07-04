package maxDepth104;

import java.util.LinkedList;
import java.util.Queue;
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
    /**
     * 递归实现
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int maxleft = maxDepth(root.left) + 1;
        int maxright = maxDepth(root.right) + 1;
        return (maxleft > maxright ? maxleft : maxright);
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int deepth = 0;
        int i = 0;
        int size = 0;
        TreeNode node = null;
        if(root != null)
            queue.add(root);
        while (!queue.isEmpty()){
            size = queue.size();
            ++deepth;
            //扩展当前层次所有节点
            for (i = 0; i < size; ++i){
                node = queue.remove();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        return deepth;
    }
}
