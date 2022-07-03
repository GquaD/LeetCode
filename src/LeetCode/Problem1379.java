package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Problem1379 {
    //https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
    public static void main(String[] args) {

    }
    //Runtime: 2 ms, faster than 79.31% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
    //Memory Usage: 105.8 MB, less than 14.17% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.

    static TreeNode node;
    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original.equals(target)) {
            return cloned;
        }

        node = getTargetCopy(original.right, cloned.right, target);
        if (node == null) {
            node = getTargetCopy(original.left, cloned.left, target);
        }
        return node;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
