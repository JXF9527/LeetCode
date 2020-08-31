package Codec297;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // 层次遍历解决
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuffer ans = new StringBuffer();
        TreeNode node;
        int length;
        while (!queue.isEmpty()) {
            length = queue.size();
            while (length > 0) {
                node = queue.poll();
                if (node != null) {
                    ans.append(node.val + ",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
                else {
                    ans.append("n,");
                }
                --length;
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dt = data.split(",");
        TreeNode[] nodearray = new TreeNode[dt.length];
        TreeNode node;
        int parent;
        nodearray[0] = stringToTree(dt[0]);
        //子节点除以2所得序号为父节点
        for (int i = 1; i < dt.length; i++) {
            node = stringToTree(dt[i]);
            nodearray[i] = node;
            if (node == null)
                continue;
            parent = ((i + 1) >> 1) - 1;
            for (int j = parent; j < dt.length; j++) {
                if (nodearray[j] != null) {
                    if (i % 2 == 0) {
                        if (nodearray[j].right == null)
                            nodearray[j].right = node;
                        else
                            continue;
                    }
                    else {
                        if (nodearray[j].left == null)
                            nodearray[j].left = node;
                        else
                            continue;
                    }
                    break;
                }
            }

        }
        return nodearray[0];
    }


    public TreeNode deserialize2(String data) {
        String[] dt = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode ans = stringToTree(dt[0]);
        TreeNode node;
        queue.add(ans);
        int i = 1;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node == null)
                continue;
            node.left = stringToTree(dt[i]);
            node.right = stringToTree(dt[i + 1]);
            i += 2;
            queue.add(node.left);
            queue.add(node.right);
        }
        return ans;
    }

    private TreeNode stringToTree(String str) {
        TreeNode node = null;
        switch (str) {
            case "n" :
                break;
            case "":
                break;
            default:
                node = new TreeNode(Integer.valueOf(str));
                break;
        }

        return node;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        codec.deserialize(codec.serialize(new TreeNode(5,new TreeNode(2),new TreeNode(3,
                new TreeNode(2,new TreeNode(3), new TreeNode(1)), new TreeNode(4)))));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
