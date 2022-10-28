package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem99 {
    //https://leetcode.com/problems/recover-binary-search-tree/
    public static void main(String[] args) {
        /*TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        recoverTree(n1);*/
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n2.right = n3;
        recoverTree(n1);
    }

    static void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        recoverTreeRecursiveLeft(root.left, list);
        list.clear();
        list.add(root);
        recoverTreeRecursiveRight(root.right, list);
    }

    static void recoverTreeRecursiveLeft(TreeNode node, List<TreeNode> parents) {
        if (node == null) return;

        for (int i = 0; i < parents.size(); i++) {
            TreeNode parent = parents.get(i);
            if (node.val > parent.val) {
                swapValues(node, parent);
                return;
            }
        }
        if (node.left != null && node.left.val > node.val) {
            swapValues(node, node.left);
            return;
        }
        if (node.right != null && node.right.val < node.val) {
            swapValues(node, node.right);
            return;
        }

        parents.add(node);
        recoverTreeRecursiveLeft(node.left, parents);
        recoverTreeRecursiveLeft(node.right, parents);
    }

    static void recoverTreeRecursiveRight(TreeNode node, List<TreeNode> parents) {
        if (node == null) return;

        for (int i = 0; i < parents.size(); i++) {
            TreeNode parent = parents.get(i);
            if (node.val < parent.val) {
                swapValues(node, parent);
                return;
            }
        }
        if (node.left != null && node.left.val > node.val) {
            swapValues(node, node.left);
            return;
        }
        if (node.right != null && node.right.val < node.val) {
            swapValues(node, node.right);
            return;
        }

        parents.add(node);
        recoverTreeRecursiveRight(node.left, parents);
        recoverTreeRecursiveRight(node.right, parents);
    }

    static void swapValues(TreeNode one, TreeNode two) {
        int temp = one.val;
        one.val = two.val;
        two.val = temp;
    }

    static void recoverTreeRecursive(TreeNode root, List<TreeNode> parents) {
        if (root == null) return;
        if (root.left != null && root.left.val > root.val) {
            int temp = root.val;
            root.val = root.left.val;
            root.left.val = temp;
            return;
        }
        if (root.right != null && root.right.val < root.val) {
            int temp = root.val;
            root.val = root.right.val;
            root.right.val = temp;
            return;
        }
        parents.add(root);
        recoverTreeRecursive(root.left, parents);
        recoverTreeRecursive(root.right, parents);
    }

    /*private static void traverseTreeAndRecover(TreeNode root, TreeNode parent) {
        if (root == null) return;

        if (parent != null) {
            if (root.val)
        }
    }*/
}
