package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem144 {
    //https://leetcode.com/problems/binary-tree-preorder-traversal/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/binary-tree-preorder-traversal/solutions/2748299/java-o-n-recursive-100-faster-solution/
    //less than 5 mins, see problem 145
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.9 MB
    //Beats
    //70.35%

    static List<Integer> result;

    static List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        traversePreOrder(root);
        return result;
    }

    private static void traversePreOrder(TreeNode node) {
        if (node == null) return;

        result.add(node.val);
        if (node.left != null) {
            traversePreOrder(node.left);
        }
        if (node.right != null) {
            traversePreOrder(node.right);
        }
    }
}
