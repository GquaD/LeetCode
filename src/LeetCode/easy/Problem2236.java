package LeetCode.easy;

public class Problem2236 {
    //https://leetcode.com/problems/root-equals-sum-of-children/
    public static void main(String[] args) {

    }

    public static boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }

    public class TreeNode {
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
