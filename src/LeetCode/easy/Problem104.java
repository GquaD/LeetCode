package LeetCode.easy;

public class Problem104 {
    //https://leetcode.com/problems/maximum-depth-of-binary-tree
    public static void main(String[] args) {

    }
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.67
    //MB
    //Beats
    //61.73%
    static int max;
    public static int maxDepth(TreeNode root) {
        max = 0;
        findMaxDepth(root, 1);
        return max;
    }

    private static void findMaxDepth(TreeNode root, int count) {
        if (root == null) {
            return;
        }
        if (max < count) {
            max = count;
        }
        findMaxDepth(root.left, ++count);
        findMaxDepth(root.right, count);
    }

    private class TreeNode {
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
