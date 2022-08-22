package LeetCode.medium;

public class Problem701 {
    static int count;

    //https://leetcode.com/problems/insert-into-a-binary-search-tree/
    public static void main(String[] args) {
        /*TreeNode node1 = new TreeNode(40);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(60);
        TreeNode node4 = new TreeNode(10);
        TreeNode node5 = new TreeNode(30);
        TreeNode node6 = new TreeNode(50);
        TreeNode node7 = new TreeNode(70);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        insertIntoBST(node1, 25);*/
        /*TreeNode node1 = new TreeNode(55);
        TreeNode node2 = new TreeNode(28);
        TreeNode node3 = new TreeNode(92);
        TreeNode node4 = new TreeNode(26);
        TreeNode node5 = new TreeNode(43);
        *//*TreeNode node6 = new TreeNode(50);
        TreeNode node7 = new TreeNode(70);*//*
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;*//*
        node3.left = node6;
        node3.right = node7;*//*
        insertIntoBST(node1, 1);*/

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(14);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(17);
        TreeNode node5 = new TreeNode(95);
        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        node4.right = node5;
        insertIntoBST(node1, 4);
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
    //Memory Usage: 54.8 MB, less than 14.06% of Java online submissions for Insert into a Binary Search Tree.
    static TreeNode insertIntoBST(TreeNode root, int val) {
        count = 0;
        if (root == null) {
            root = new TreeNode(val);
        }
        findBSTAndInsert(root, val, root.val, true);
        findBSTAndInsert(root, val, root.val, false);
        return root;
    }

    private static void findBSTAndInsert(TreeNode node, int val, int headVal, boolean isLeft) {
        if (node == null || count >= 1) {
            return;
        }

        if (val > headVal && isLeft) {
            return;
        }

        if (val < headVal && !isLeft) {
            return;
        }

        if (val > node.val && node.right == null && isLeft) {
            node.right = new TreeNode(val);
            count++;
            return;
        }

        if (val > node.val && node.right == null && !isLeft) {
            node.right = new TreeNode(val);
            count++;
            return;
        }

        if (val < node.val && node.left == null && isLeft) {
            node.left = new TreeNode(val);
            count++;
            return;
        }

        if (val < node.val && node.left == null && !isLeft) {
            node.left = new TreeNode(val);
            count++;
            return;
        }

        if (val < node.val) {
            findBSTAndInsert(node.left, val, headVal, true);
        }
        if (val > node.val) {
            findBSTAndInsert(node.right, val, headVal, false);
        }
    }


    static TreeNode insertIntoBST1(TreeNode root, int val) {
        count = 0;
        searchBSTLeft(root.left, val, root.val);
        searchBSTRight(root.right, val, root.val);
        return root;
    }

    private static void searchBSTLeft(TreeNode root, int val, int headVal) {
        if (root == null || count >= 1) {
            return;
        }

        if (val > root.val && root.right == null) {
            if (val > headVal) {
                return;
            }
            root.right = new TreeNode(val);
            count++;
            return;
        }

        if (val < root.val && root.left == null) {
            if (val > headVal) {
                return;
            }
            root.left = new TreeNode(val);
            count++;
            return;
        }

        searchBSTLeft(root.left, val, headVal);
        searchBSTLeft(root.right, val, headVal);
    }

    private static void searchBSTRight(TreeNode root, int val, int headVal) {
        if (root == null || count >= 1) {
            return;
        }

        if (val > root.val && root.right == null) {
            if (val < headVal) {
                return;
            }
            root.right = new TreeNode(val);
            count++;
            return;
        }

        if (val < root.val && root.left == null) {
            if (val < headVal) {
                return;
            }
            root.left = new TreeNode(val);
            count++;
            return;
        }

        searchBSTRight(root.left, val, headVal);
        searchBSTRight(root.right, val, headVal);
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
