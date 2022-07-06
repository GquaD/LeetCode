package LeetCode;

import LeetCode.Recursion.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem102 {
    //https://leetcode.com/problems/binary-tree-level-order-traversal/
    public static void main(String[] args) {
        //1
        TreeNode root = new TreeNode(3);
        TreeNode level2_1 = new TreeNode(9);
        TreeNode level2_2 = new TreeNode(20);
        TreeNode level3_1 = new TreeNode(15);
        TreeNode level3_2 = new TreeNode(7);
        root.left = level2_1;
        root.right = level2_2;
        level2_2.left = level3_1;
        level2_2.right = level3_2;

        levelOrder(root);

        for (int i = 0; i < resultList.size(); i++) {
            for (int j = 0; j < resultList.get(i).size(); j++) {
                System.out.print(resultList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        //2
        TreeNode root1 = new TreeNode(1);
        TreeNode level12_1 = new TreeNode(2);
        TreeNode level12_2 = new TreeNode(3);
        root1.left = level12_1;
        root1.right = level12_2;

        levelOrder(root1);
        System.out.println("///////////");
        for (int i = 0; i < resultList.size(); i++) {
            for (int j = 0; j < resultList.get(i).size(); j++) {
                System.out.print(resultList.get(i).get(j) + " ");
            }
            System.out.println();
        }

        //3
        TreeNode root3 = new TreeNode(1);
        TreeNode level321 = new TreeNode(2);
        TreeNode level322 = new TreeNode(3);
        TreeNode level331 = new TreeNode(4);
        TreeNode level332 = new TreeNode(5);
        root3.left = level321;
        root3.right = level322;
        level321.left = level331;
        level321.right = level332;

        levelOrder(root3);
        System.out.println("///////////");
        for (int i = 0; i < resultList.size(); i++) {
            for (int j = 0; j < resultList.get(i).size(); j++) {
                System.out.print(resultList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }


    static List<List<Integer>> resultList;
    public static List<List<Integer>> levelOrder(TreeNode root) {
        resultList = new ArrayList<>();
        searchBST(root, -1, 0);
        return resultList;
    }

    //Runtime: 1 ms, faster than 92.08% of Java online submissions for Binary Tree Level Order Traversal.
    //Memory Usage: 43.8 MB, less than 34.68% of Java online submissions for Binary Tree Level Order Traversal.
    public static void searchBST(TreeNode root, int val, int level) {
        if (root == null) {
            return;
        }

        if (level > resultList.size() - 1){
            List<Integer> levelList = new ArrayList<>();
            levelList.add(root.val);
            resultList.add(levelList);
        } else {
            resultList.get(level).add(root.val);
        }

        searchBST(root.left, val, ++level);
        searchBST(root.right, val, level);

    }

    static void levelTraversal(Problem589.Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);

        if (root.children == null || root.children.isEmpty()) {
            return;
        }

        for (Problem589.Node child : root.children) {
            levelTraversal(child, list);
        }
    }


      //Definition for a binary tree node.
      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
}
