package LeetCode.easy;

public class Problem965 {
    //https://leetcode.com/problems/univalued-binary-tree/

    static boolean isUni;
    static boolean isUnivalTree(TreeNode root) {
        isUni = true;
        traverseAndCompare(root, root.val);
        return isUni;
    }
    //https://leetcode.com/problems/univalued-binary-tree/discuss/2618155/Java-100-faster-or-Recursive
    //10 mins
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Univalued Binary Tree.
    //Memory Usage: 41.5 MB, less than 60.39% of Java online submissions for Univalued Binary Tree.
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
