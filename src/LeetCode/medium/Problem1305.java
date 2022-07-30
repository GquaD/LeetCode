package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1305 {
    //https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
    public static void main(String[] args) {

    }
    //Runtime: 20 ms, faster than 82.50% of Java online submissions for All Elements in Two Binary Search Trees.
    //Memory Usage: 45.4 MB, less than 86.53% of Java online submissions for All Elements in Two Binary Search Trees.
    static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> first = new ArrayList<>();
        traverseBST(root1, first);
        List<Integer> second = new ArrayList<>();
        traverseBST(root2, second);
        first.addAll(second);
        Collections.sort(first);
        return first;
    }

    private static void traverseBST(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        traverseBST(root.left, list);
        traverseBST(root.right, list);
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
