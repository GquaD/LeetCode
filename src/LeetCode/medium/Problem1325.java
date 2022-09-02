package LeetCode.medium;

public class Problem1325 {
    //https://leetcode.com/problems/delete-leaves-with-a-given-value/
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        node1.left = node2;
        node1.right = node5;
        node2.left =node3;
        node5.left = node4;
        node5.right = node6;
        removeLeafNodes(node1, 2);
        System.out.println("sd");

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        System.out.println(removeLeafNodes(n1, 1));
        System.out.println();
    }

    //wow, 1 hour to solve
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Leaves With a Given Value.
    //Memory Usage: 42.1 MB, less than 89.16% of Java online submissions for Delete Leaves With a Given Value.
    static TreeNode removeLeafNodes(TreeNode root, int target) {
        traverseRootAndDelete(root, target);
        if (root != null && root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    private static void traverseRootAndDelete(TreeNode node, int target) {
        if (node == null) {
            return;
        }

        if (node.left != null && node.left.val == target && node.left.left == null && node.left.right == null) {
            node.left = null;
        } else {
            traverseRootAndDelete(node.left, target);
        }

        if (node.right != null && node.right.val == target && node.right.left == null && node.right.right == null) {
            node.right = null;
        } else {
            traverseRootAndDelete(node.right, target);
        }
        if (node.left != null && node.left.val == target && node.left.left == null && node.left.right == null) {
            node.left = null;
        }
        if (node.right != null && node.right.val == target && node.right.left == null && node.right.right == null) {
            node.right = null;
        }
        /*if (node.val == target && node.left == null && node.right == null) {
            node = null;
            return;
        }

        traverseRootAndDelete(node.left, target);
        traverseRootAndDelete(node.right, target);*/
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
