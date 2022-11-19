package LeetCode.easy;

public class Problem897 {
    //https://leetcode.com/problems/increasing-order-search-tree/
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n7 = new TreeNode(7);
        n5.left = n1;
        n5.right = n7;
        increasingBST(n5);
    }
    static TreeNode head;
    static TreeNode current;
    static TreeNode increasingBST(TreeNode root) {
        current = null;
        head = null;
        traverseBSTInorder(root);
        return head;
    }

    private static void traverseBSTInorder(TreeNode node) {
        if (node == null) return;

        if (current != null) {
            current.right = new TreeNode(node.val);
        }

        traverseBSTInorder(node.left);
        traverseBSTInorder(node.right);
        if (head == null) {
            head = new TreeNode(node.val);
            current = head;
        }
    }
}
