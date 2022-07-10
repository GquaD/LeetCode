package LeetCode;

public class Problem104 {
    //
    public static void main(String[] args) {

    }
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
    //Memory Usage: 42.9 MB, less than 69.71% of Java online submissions for Maximum Depth of Binary Tree.
    static int max;
    public static int maxDepth(TreeNode root) {
        max = 0;
        findMaxDepth(root, 1);
        return max;
    }

    private static void findMaxDepth(TreeNode root, int count) {
        if (root == null) {
            return;
        }
        if (max < count) {
            max = count;
        }
        findMaxDepth(root.left, ++count);
        findMaxDepth(root.right, count);
    }

    private class TreeNode {
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
