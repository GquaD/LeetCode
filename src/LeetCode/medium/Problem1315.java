package LeetCode.medium;

public class Problem1315 {
    //https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
    public static void main(String[] args) {

    }
    static int sumGlobal;
    static int sumEvenGrandparent(TreeNode root) {
        sumGlobal = 0;
        countGrandChildren(root);
        return sumGlobal;
    }

    //15 mins
    //Runtime: 2 ms, faster than 86.89% of Java online submissions for Sum of Nodes with Even-Valued Grandparent.
    //Memory Usage: 52.5 MB, less than 39.74% of Java online submissions for Sum of Nodes with Even-Valued Grandparent.
    private static void countGrandChildren(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return;
        if (node.val % 2 == 0) {
            if (node.left != null) {
                if (node.left.left != null) {
                    sumGlobal += node.left.left.val;
                }
                if (node.left.right != null) {
                    sumGlobal += node.left.right.val;
                }
            }
            if (node.right != null) {
                if (node.right.left != null) {
                    sumGlobal += node.right.left.val;
                }
                if (node.right.right != null) {
                    sumGlobal += node.right.right.val;
                }
            }
        }
        countGrandChildren(node.left);
        countGrandChildren(node.right);
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
