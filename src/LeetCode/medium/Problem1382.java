package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1382 {
    //https://leetcode.com/problems/balance-a-binary-search-tree/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.right = node2;
        node2.right = node3;
        node3.right = node4;
        balanceBST(root);
    }

    //Runtime: 27 ms, faster than 8.30% of Java online submissions for Balance a Binary Search Tree.
    //Memory Usage: 67.6 MB, less than 5.39% of Java online submissions for Balance a Binary Search Tree.
    static TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        parseAndSaveBSTToList(root, list);
        Collections.sort(list);
        root = new TreeNode(list.get(list.size() / 2));
        buildBalancedTree(list, root);
        return root;
    }

    private static void buildBalancedTree(List<Integer> list, TreeNode node) {
        if (list.size() == 0) return;
        List<Integer> left = list.subList(0, list.size() / 2);
        if (left.size() != 0) {
            node.left = new TreeNode(left.get(left.size() / 2));
        }
        List<Integer> right = list.subList(list.size() / 2 + 1, list.size());
        if (right.size() != 0) {
            node.right = new TreeNode(right.get(right.size() / 2));
        }
        //node = new TreeNode(list.get(list.size() / 2));
        buildBalancedTree(left, node.left);
        buildBalancedTree(right, node.right);
    }

    private static void parseAndSaveBSTToList(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        parseAndSaveBSTToList(root.left, list);
        parseAndSaveBSTToList(root.right, list);
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
