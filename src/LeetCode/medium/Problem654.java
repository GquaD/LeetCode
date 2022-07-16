package LeetCode.medium;

public class Problem654 {
    //https://leetcode.com/problems/maximum-binary-tree/
    public static void main(String[] args) {
        constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

    //Runtime: 6 ms, faster than 23.39% of Java online submissions for Maximum Binary Tree.
    //Memory Usage: 54 MB, less than 49.50% of Java online submissions for Maximum Binary Tree.
    static TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = construct(nums);
        return root;
    }

    static TreeNode construct(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        //find max
        int max = 0, maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode node = new TreeNode(max);

        int[] left = new int[maxIndex];
        for (int i = 0; i < left.length; i++) {
            left[i] = nums[i];
        }
        int[] right = new int[nums.length - 1 - maxIndex];
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[maxIndex + 1 + i];
        }
        node.left = construct(left);
        node.right = construct(right);
        return node;
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
