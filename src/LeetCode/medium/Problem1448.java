package LeetCode.medium;

import java.util.ArrayList;

public class Problem1448 {
    //https://leetcode.com/problems/count-good-nodes-in-binary-tree/
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        int num = goodNodes(node1);
        System.out.println(num);

        //[2,null,4,10,8,null,null,4]
        //expected 4
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(8);
        TreeNode n5 = new TreeNode(4);
        n1.right = n2;
        n2.left = n3;
        n2.right = n4;
        n4.left = n5;
        int num1 = goodNodes(n1);
        System.out.println(num1);
        //[9,null,3,6]
        //1
        TreeNode nc1 = new TreeNode(9);
        TreeNode nc2 = new TreeNode(3);
        TreeNode nc3 = new TreeNode(6);
        nc1.right = nc2;
        nc2.left = nc3;
        int num2 = goodNodes(nc1);
        System.out.println(num2);
    }
    static int count = 0;
    static int goodNodes(TreeNode root) {
        count = 0;
        traverseBT(root, new ArrayList<TreeNode>());
        return count;
    }

    private static void traverseBT(TreeNode node, ArrayList<TreeNode> treeNodesBefore) {
        if (node == null) {
            return;
        }

        boolean isGood = goThruList(treeNodesBefore, node.val);
        if (isGood) {
            count++;
        }
        treeNodesBefore.add(node);

        traverseBT(node.left, treeNodesBefore);

        //treeNodesBefore.remove(treeNodesBefore.size() - 1);

        traverseBT(node.right, treeNodesBefore);
    }

    private static boolean goThruList(ArrayList<TreeNode> treeNodesBefore, int val) {
        for (TreeNode node : treeNodesBefore) {
            if (node.val > val) {
                return false;
            }
        }
        return true;
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
