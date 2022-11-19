package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem897 {
    //https://leetcode.com/problems/increasing-order-search-tree/
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n7 = new TreeNode(7);
        n5.left = n1;
        n5.right = n7;
        increasingBST(n5);
    }

    //30 min
    //Runtime
    //1 ms
    //Beats
    //40.76%
    //Memory
    //42.5 MB
    //Beats
    //7.51%
    static List<Integer> list;
    static TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<>();
        traverseBSTInorder(root);
        TreeNode head = new TreeNode(list.get(0)), temp = head;
        for (int i = 1; i < list.size(); i++) {
            temp.right = new TreeNode(list.get(i));
            temp = temp.right;
        }
        return head;
    }

    private static void traverseBSTInorder(TreeNode node) {
        if (node == null) return;

        traverseBSTInorder(node.left);
        list.add(node.val);
        traverseBSTInorder(node.right);
    }
}
