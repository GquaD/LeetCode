package LeetCode.easy;

import LeetCode.Recursion.TreeNode;

public class Problem226 {
    //https://leetcode.com/problems/invert-binary-tree/submissions/
    public static void main(String[] args) {

    }

    //Runtime: 1 ms, faster than 11.42% of Java online submissions for Invert Binary Tree.
    //Memory Usage: 41.1 MB, less than 78.64% of Java online submissions for Invert Binary Tree.
    static TreeNode invertTree(TreeNode root) {
        invertRecursively(root);
        return root;
    }

    private static void invertRecursively(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertRecursively(root.left);
        invertRecursively(root.right);
    }
}
