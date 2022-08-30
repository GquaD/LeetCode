package LeetCode.medium;

public class Problem2331 {
    //https://leetcode.com/problems/evaluate-boolean-binary-tree/
    public static void main(String[] args) {

    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Evaluate Boolean Binary Tree.
    //Memory Usage: 46 MB, less than 79.98% of Java online submissions for Evaluate Boolean Binary Tree.
    static boolean evaluateTree(TreeNode root) {
        return traverseFullBinaryTree(root);
    }


    private static boolean traverseFullBinaryTree(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node.val == 1;
        }

        if (node.val == 2) {
            node.val = traverseFullBinaryTree(node.left) || traverseFullBinaryTree(node.right) ? 1 : 0;
        } else if (node.val == 3) {
            node.val = traverseFullBinaryTree(node.left) && traverseFullBinaryTree(node.right) ? 1 : 0;
        }
        return node.val == 1;
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
