package LeetCode.Recursion;

public class BinaryTreeSearch {
    //SOLVED!
    //https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3233/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        root.left.left = node3;
        root.left.right = node4;
        TreeNode result = searchBST(root, 2);
        System.out.println("Result node val is " + result.val);

        result = searchBST(root, 5);

        System.out.println("Result node val is " + (result == null ? "null" : result.val));
    }

    static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.left == null && root.right == null) return null;
        if (root.left != null && root.left.val == val) return root.left;
        if (root.right != null && root.right.val == val) return root.right;

        TreeNode result = searchBST(root.left, val);
        if (result != null) {
            return result;
        } else {
            return searchBST(root.right, val);
        }
    }
}
