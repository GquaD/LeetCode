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

    static boolean swapDone;
    static void recoverTree(TreeNode root) {
        swapDone = false;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        recoverTreeRecursive(root.left, list, new ArrayList<>());
        if (swapDone) return;
        list.clear();
        list.add(root);
        recoverTreeRecursive(root.right, new ArrayList<>(), list);
    }

    private static void recoverTreeRecursive(TreeNode node, List<TreeNode> parentsToBeLessFrom, List<TreeNode> parentsToBeGreaterFrom) {
        if (node == null) return;

        for (int i = 0; i < parentsToBeLessFrom.size(); i++) {
            TreeNode parent = parentsToBeLessFrom.get(i);
            if (node.val > parent.val) {
                swapValues(node, parent);
                return;
            }
        }
        for (int i = 0; i < parentsToBeGreaterFrom.size(); i++) {
            TreeNode parent = parentsToBeGreaterFrom.get(i);
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

        parentsToBeLessFrom.add(node);
        recoverTreeRecursive(node.left, parentsToBeLessFrom, parentsToBeGreaterFrom);
        parentsToBeLessFrom.remove(parentsToBeLessFrom.size() - 1);
        parentsToBeGreaterFrom.add(node);
        recoverTreeRecursive(node.right, parentsToBeLessFrom, parentsToBeGreaterFrom);
        parentsToBeGreaterFrom.remove(parentsToBeGreaterFrom.size() - 1);
    }

    private static void swapValues(TreeNode one, TreeNode two) {
        int temp = one.val;
        one.val = two.val;
        two.val = temp;
        swapDone = true;
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
