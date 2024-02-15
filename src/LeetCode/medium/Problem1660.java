package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem1660 {
    //https://leetcode.com/problems/correct-a-binary-tree/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/correct-a-binary-tree/solutions/4731831/java-o-n-dfs-solution/
    //10-15min
    //Runtime
    //5
    //ms
    //Beats
    //71.11%
    //of users with Java
    //Memory
    //46.56
    //MB
    //Beats
    //71.85%
    //of users with Java
    static TreeNode correctBinaryTree(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        goDFS(root, null, set);
        return root;
    }

    private static void goDFS(TreeNode node, TreeNode parent, Set<Integer> set) {
        if (node == null) return;

        if (node.right != null && set.contains(node.right.val)) {
            if (parent != null) {
                if (parent.left != null && parent.left.val == node.val) {
                    parent.left = null;
                    return;
                } else if (parent.right != null && parent.right.val == node.val) {
                    parent.right = null;
                    return;
                }
            }
        }
        set.add(node.val);
        goDFS(node.right, node, set);
        goDFS(node.left, node, set);
    }
}
