package LeetCode.medium;

import javafx.util.Pair;

import java.util.*;

public class Problem314 {
    //https://leetcode.com/problems/binary-tree-vertical-order-traversal/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/binary-tree-vertical-order-traversal/solutions/5188492/java-bfs-treemap-solution/
    //20min
    //Runtime
    //3
    //ms
    //Beats
    //56.24%
    //of users with Java
    //Memory
    //42.48
    //MB
    //Beats
    //87.78%
    //of users with Java
    static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while(q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> p = q.poll();

                TreeNode node = p.getKey();
                int col = p.getValue();

                List<Integer> l = map.get(col);
                if (l == null) {
                    l = new ArrayList<>();
                    map.put(col, l);
                }
                l.add(node.val);

                if (node.left != null) {
                    q.offer(new Pair<>(node.left, col - 1));
                }

                if (node.right != null) {
                    q.offer(new Pair<>(node.right, col + 1));
                }
            }
        }

        for (int key: map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }
}
