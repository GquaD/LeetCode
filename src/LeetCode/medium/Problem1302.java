package LeetCode.medium;

import java.util.*;

public class Problem1302 {
    //https://leetcode.com/problems/deepest-leaves-sum/
    public static void main(String[] args) {

    }

    //Runtime: 46 ms, faster than 5.11% of Java online submissions for Deepest Leaves Sum.
    //Memory Usage: 54.8 MB, less than 82.29% of Java online submissions for Deepest Leaves Sum.
    //was with ArrayList as cache and no "lastLevel" variable used

    //Runtime: 7 ms, faster than 53.12% of Java online submissions for Deepest Leaves Sum.
    //Memory Usage: 56 MB, less than 55.86% of Java online submissions for Deepest Leaves Sum.
    static int sum;
    static Set<Integer> cacheLevels;
    static int lastLevel;
    static int deepestLeavesSum(TreeNode root) {
        lastLevel = 0;
        sum = root.val;
        cacheLevels = new HashSet<>();
        cacheLevels.add(0);
        traverseBinaryTree(root.left, 1);
        traverseBinaryTree(root.right, 1);
        return sum;
    }

    private static void traverseBinaryTree(TreeNode root, int level) {
        if (root == null) return;
        if (cacheLevels.contains(level) && lastLevel == level) {
            sum += root.val;
        } else if (!cacheLevels.contains(level)) {
            sum = root.val;
            cacheLevels.add(level);
            lastLevel = level;
        }
        traverseBinaryTree(root.left, level + 1);
        traverseBinaryTree(root.right, level + 1);
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
