package LeetCode;

public class Problem606 {
    //https://leetcode.com/problems/construct-string-from-binary-tree/submissions/
    public static void main(String[] args) {

    }

    static String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverseBT(root, sb);
        return sb.toString();
    }

    //15 mins
    //Runtime: 3 ms, faster than 89.01% of Java online submissions for Construct String from Binary Tree.
    //Memory Usage: 45.2 MB, less than 68.39% of Java online submissions for Construct String from Binary Tree.
    private static void traverseBT(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        sb.append(node.val);
        if (node.left != null) {
            sb.append("(");
            traverseBT(node.left, sb);
            sb.append(")");
        } else if (node.left == null && node.right != null) {
            sb.append("()");
        }
        if (node.right != null) {
            sb.append("(");
            traverseBT(node.right, sb);
            sb.append(")");
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
