package LeetCode.medium;

public class Problem814 {
    //https://leetcode.com/problems/binary-tree-pruning/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/binary-tree-pruning/discuss/2597928/Java-100-faster-solution-or-DFS
    //15mins
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Pruning.
    //Memory Usage: 41.6 MB, less than 64.35% of Java online submissions for Binary Tree Pruning.
    static TreeNode pruneTree(TreeNode root) {
        deleteZeroSubtree(root);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    private static void deleteZeroSubtree(TreeNode node) {
        if (node == null) {
            return;
        }

        deleteZeroSubtree(node.left);
        deleteZeroSubtree(node.right);

        if (node.right != null) {
            if (node.right.left == null && node.right.right == null && node.right.val == 0) {
                node.right = null;
            }
        }

        if (node.left != null) {
            if (node.left.left == null && node.left.right == null && node.left.val == 0) {
                node.left = null;
            }
        }
    }
}
