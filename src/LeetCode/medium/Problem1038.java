package LeetCode.medium;

import java.util.*;

public class Problem1038 {


    //https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
    public static void main(String[] args) {

    }

    //Runtime: 4 ms, faster than 10.52% of Java online submissions for Binary Search Tree to Greater Sum Tree.
    //Memory Usage: 41 MB, less than 83.62% of Java online submissions for Binary Search Tree to Greater Sum Tree.
    static Set<Integer> set;
    static int sum;
    public TreeNode bstToGst1(TreeNode root) {
        set = new TreeSet<>();
        sum = 0;
        traverseBST(root);
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : set) {
            sum -= i;
            map.put(i, sum);
        }
        traverseBSTAndPutNewValues(root, map);
        return root;
    }

    private static void traverseBSTAndPutNewValues(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        if (map.containsKey(node.val)) {
            node.val = map.get(node.val);
        }
        traverseBSTAndPutNewValues(node.left, map);
        traverseBSTAndPutNewValues(node.right, map);
    }

    private static void traverseBST(TreeNode node) {
        if (node == null) {
            return;
        }

        if (set.add(node.val)) {
            sum += node.val;
        }
        traverseBST(node.left);
        traverseBST(node.right);
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
