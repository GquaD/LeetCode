package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem145 {
    //https://leetcode.com/problems/binary-tree-postorder-traversal/

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/binary-tree-postorder-traversal/solutions/2745944/java-recursive-dfs-postorder-100-faster/
    //5 mins, refer problem94
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.9 MB
    //Beats
    //7.32%
    static List<Integer> result;

    static List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        traversePostOrder(root);
        return result;
    }

    private static void traversePostOrder(TreeNode node) {
        if (node == null) return;

        if (node.left != null) {
            traversePostOrder(node.left);
        }
        if (node.right != null) {
            traversePostOrder(node.right);
        }
        result.add(node.val);
    }
}
