package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem1214 {
    //https://leetcode.com/problems/two-sum-bsts/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/two-sum-bsts/solutions/5026494/java-dfs-hashset-2ms-solution/
    //5-10min
    //Runtime
    //2
    //ms
    //Beats
    //83.09%
    //of users with Java
    //Memory
    //45.40
    //MB
    //Beats
    //47.48%
    //of users with Java
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<>();
        goDFS(root1, set, target);

        boolean[] res = new boolean[1];
        goDFSCheck(root2, set, res);

        return res[0];
    }

    private void goDFS(TreeNode node, Set<Integer> set, int t) {
        if (node == null) return;

        set.add(t - node.val);
        goDFS(node.left, set, t);
        goDFS(node.right, set, t);
    }

    private void goDFSCheck(TreeNode node, Set<Integer> set, boolean[] res) {
        if (node == null) return;

        if (set.contains(node.val)) {
            res[0] = true;
            return;
        }
        goDFSCheck(node.left, set, res);
        goDFSCheck(node.right, set, res);
    }
}
