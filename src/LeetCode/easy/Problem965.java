package LeetCode.easy;

public class Problem965 {
    //https://leetcode.com/problems/univalued-binary-tree/

    static boolean isUni;
    static boolean isUnivalTree(TreeNode root) {
        isUni = true;
        traverseAndCompare(root, root.val);
        return isUni;
    }

    private static void traverseAndCompare(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val != val) {
            isUni = false;
            return;
        }
        traverseAndCompare(root.left, val);
        traverseAndCompare(root.right, val);
    }
}
