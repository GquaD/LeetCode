package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem1469 {
    //https://leetcode.com/problems/find-all-the-lonely-nodes/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-all-the-lonely-nodes/solutions/4998844/java-dfs-o-n-solution/
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //44.40
    //MB
    //Beats
    //84.79%
    //of users with Java
    private List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        goDFS(root, list);
        return list;
    }

    private void goDFS(TreeNode node, List<Integer> list) {
        if (node == null) return;

        if (node.left != null && node.right == null) {
            list.add(node.left.val);
        }

        if (node.left == null && node.right != null) {
            list.add(node.right.val);
        }

        goDFS(node.left, list);
        goDFS(node.right, list);
    }
}
