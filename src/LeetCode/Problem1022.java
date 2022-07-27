package LeetCode;

import java.util.*;

public class Problem1022 {
    //https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(1);
        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;


        System.out.println(sumRootToLeaf(root));

        TreeNode rootA = new TreeNode(0);
        rootA.left = new TreeNode(1);
        rootA.right = new TreeNode(1);
        System.out.println(sumRootToLeaf(rootA));
    }

    //Runtime: 6 ms, faster than 24.65% of Java online submissions for Sum of Root To Leaf Binary Numbers.
    //Memory Usage: 44.6 MB, less than 5.71% of Java online submissions for Sum of Root To Leaf Binary Numbers.
    static List<String> listStatic;
    static int sumRootToLeaf(TreeNode root) {
        listStatic = new ArrayList<>();
        sumRootToLeaf(root, "");
        int sum = 0;
        for (String s : listStatic) {
            sum += convertToIntFromBinary(s);
        }
        return sum;
    }

    static void sumRootToLeaf(TreeNode root, String num) {
        if (root == null) return ;
        num = num.concat(root.val + "");
        if (root.left == null && root.right == null) {
            listStatic.add(num);
            return;
        }
        sumRootToLeaf(root.left, num);
        sumRootToLeaf(root.right, num);
    }

    private static int convertToIntFromBinary(String s) {
        int result = 0;
        int pow = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += (Math.pow(2, pow++) * Integer.parseInt(s.charAt(i) + ""));
        }
        return result;
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
