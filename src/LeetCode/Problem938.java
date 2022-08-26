package LeetCode;

public class Problem938 {
    //https://leetcode.com/problems/range-sum-of-bst/
    public static void main(String[] args) {

    }

    //Runtime: 2 ms, faster than 41.05% of Java online submissions for Range Sum of BST.
    //Memory Usage: 65 MB, less than 74.49% of Java online submissions for Range Sum of BST.
    static int sum;
    static int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        searchBST(root, low, high);
        return sum;
    }

    private static void searchBST(TreeNode node, int low, int high) {
        if (node == null) return;
        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }
        searchBST(node.left, low, high);
        searchBST(node.right, low, high);
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
