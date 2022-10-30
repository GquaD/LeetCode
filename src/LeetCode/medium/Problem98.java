package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem98 {
    static boolean isValid;
    static List<TreeNode> list;

    //https://leetcode.com/problems/validate-binary-search-tree/submissions/
    //!
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        root.left = node4;
        root.right = node6;

        node6.left = node3;
        node6.right = node7;

        System.out.println(isValidBST4(root));
    }
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
    //Memory Usage: 43.9 MB, less than 55.20% of Java online submissions for Validate Binary Search Tree.
    public static boolean isValidBST4(TreeNode root) {
        return isValidBST4(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST4(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST4(root.left, minVal, root.val) && isValidBST4(root.right, root.val, maxVal);
    }


    public static boolean isValidBST3(TreeNode root) {
        searchBST3(root.left, root);
        searchBST3(root.right, root);
        return isValid;
    }

    private static void searchBST3(TreeNode current, TreeNode root) {
        if (current == null) {
            return;
        }
        if (current.val == root.val) {
            isValid = false;
            return;
        }
        if (current.left != null) {
            if (current.left.val >= current.val || current.val >= root.val){
                isValid = false;
                return;
            }
        }
        searchBST3(current.left, root);

        if (current.right != null) {
            if (current.right.val <= current.val || current.val <= root.val) {
                isValid = false;
                return;
            }
        }
        searchBST3(current.right, root);
    }


    static boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        isValid = true;
        if (root.right == null && root.left == null) {
            return isValid;
        }
        searchBST(root, root);
        return isValid;
    }

    private static void searchBST(TreeNode currentNode, TreeNode root) {
        if (currentNode == null) {
            return;
        }

        if (currentNode.left != null) {
            for (TreeNode node : list) {
                if (!node.equals(root) && node.val <= currentNode.val) {
                    isValid = false;
                    return;
                }
            }

            list.add(currentNode);
            searchBST(currentNode.left, root);
            list.remove(list.size() - 1);
        }

        if (currentNode.right != null) {
            for (TreeNode node : list) {
                if (!node.equals(root) && node.val >= currentNode.val) {
                    isValid = false;
                    return;
                }
            }

            list.add(currentNode);
            searchBST(currentNode.right, root);
            list.remove(list.size() - 1);
        }
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
