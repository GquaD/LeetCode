package LeetCode.medium;

import java.util.*;

public class Problem2476 {
    //https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/solutions/5346549/java-dfs-treemap-solution/
    //5-10min
    //Runtime
    //170
    //ms
    //Beats
    //24.27%
    //Memory
    //110.08
    //MB
    //Beats
    //8.19%
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        goDFS(root, set);
        List<List<Integer>> res = new ArrayList<>(queries.size());
        for (int q : queries) {
            List<Integer> l = new ArrayList<>();
            Integer min = set.floor(q), max = set.ceiling(q);
            min = min == null ? -1 : min;
            max = max == null ? -1 : max;
            l.add(min);
            l.add(max);
            res.add(l);
        }
        return res;
    }

    private void goDFS(TreeNode node, TreeSet<Integer> set) {
        if (node == null) return;

        set.add(node.val);

        goDFS(node.left, set);
        goDFS(node.right, set);
    }
}
