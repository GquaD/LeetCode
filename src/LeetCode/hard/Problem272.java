package LeetCode.hard;

import java.util.List;
import java.util.PriorityQueue;

public class Problem272 {
    //15min
    //Runtime
    //5
    //ms
    //Beats
    //20.88%
    //Memory
    //46.98
    //MB
    //Beats
    //57.58%
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.diff - a.diff > 0.0 ? 1 : b.diff - a.diff < 0.0 ? -1 : 0);
        dfs(root, target, k, pq);
        return pq.stream().map(p -> p.val).toList();
    }

    private void dfs(TreeNode node, double target, int k, PriorityQueue<Pair> pq) {
        if (node == null) return;

        double diff = Math.abs(target - (node.val * 1.0));
        pq.offer(new Pair(node.val, diff));
        if (pq.size() > k) pq.poll();

        dfs(node.left, target, k, pq);
        dfs(node.right, target, k, pq);
    }

    private static class Pair {
        int val;
        double diff;

        public Pair(int v, double d) {
            val = v;
            diff = d;
        }
    }
}
