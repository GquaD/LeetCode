package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem101 {
    //https://leetcode.com/problems/symmetric-tree/

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.right = n5;
        System.out.println(isSymmetric(n1));
    }


    //https://leetcode.com/problems/symmetric-tree/solutions/2810168/java-solution-using-arraylist/
    //Runtime
    //3 ms
    //Beats
    //5.15%
    //Memory
    //42.7 MB
    //Beats
    //20.46%
    static boolean isSymmetric(TreeNode root) {
        List<Integer> listLeft = new ArrayList<>();
        traverseBTLeftFirst(root.left, listLeft);
        List<Integer> listRight = new ArrayList<>();
        traverseBTRightFirst(root.right, listRight);
        if (listLeft.size() != listRight.size()) return false;
        for (int i = 0; i < listLeft.size(); i++) {
            if (listLeft.get(i) != listRight.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static void traverseBTLeftFirst(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add(101);
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null) return;

        traverseBTLeftFirst(node.left, list);
        traverseBTLeftFirst(node.right, list);
    }

    private static void traverseBTRightFirst(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add(101);
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null) return;

        traverseBTRightFirst(node.right, list);
        traverseBTRightFirst(node.left, list);
    }
}
