package LeetCode.medium;

import java.util.*;

public class Problem742 {
    //https://leetcode.com/problems/closest-leaf-in-a-binary-tree/

    //https://leetcode.com/problems/closest-leaf-in-a-binary-tree/solutions/5307047/java-o-n-dfs-bfs-approach/
    //15min
    //Runtime
    //3
    //ms
    //Beats
    //76.99%
    //Memory
    //44.40
    //MB
    //Beats
    //30.09%
    public int findClosestLeaf(TreeNode root, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> leaves = new HashSet<>();

        goDFS(root, null, map, leaves);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);

        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (visited.contains(cur)) {
                    continue;
                }
                visited.add(cur);
                if (leaves.contains(cur)) {
                    return cur;
                }
                List<Integer> l = map.get(cur);
                if (l != null) {
                    queue.addAll(l);
                }
            }
        }
        return root.val;
    }

    private void goDFS(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> map, Set<Integer> leaves) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }

        List<Integer> list = new ArrayList<>();
        if (parent != null) list.add(parent.val);
        if (node.left != null) list.add(node.left.val);
        if (node.right != null) list.add(node.right.val);
        map.put(node.val, list);

        goDFS(node.left, node, map, leaves);
        goDFS(node.right, node, map, leaves);
    }
}
