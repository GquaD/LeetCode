package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem366 {
    //https://leetcode.com/problems/find-leaves-of-binary-tree/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-leaves-of-binary-tree/solutions/4726583/java-100-faster-o-n-dfs-solution/
    //15-20min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //41.78
    //MB
    //Beats
    //47.99%
    //of users with Java
    static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        goDFS(root, list, 0);
        return list;
    }

    private static int goDFS(TreeNode node, List<List<Integer>> list, int lvl) {
        if (node == null) return -1;

        int l = goDFS(node.left, list, lvl) + 1;
        int r = goDFS(node.right, list, lvl) + 1;
        int min = Math.max(l, r);
        if (list.size() <= min) list.add(new ArrayList<>());
        list.get(min).add(node.val);
        return min;
    }
}
