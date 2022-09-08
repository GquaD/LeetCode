package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Problem94 {
    //https://leetcode.com/problems/binary-tree-inorder-traversal/
    public static void main(String[] args) {

    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
    //Memory Usage: 40.5 MB, less than 93.17% of Java online submissions for Binary Tree Inorder Traversal.
    static List<Integer> result;
    static List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        traverseInorder(root);
        return result;
    }

    private static void traverseInorder(TreeNode node) {
        if (node == null) return;

        if (node.left != null) {
            traverseInorder(node.left);
        }
        result.add(node.val);
        if (node.right != null) {
            traverseInorder(node.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
