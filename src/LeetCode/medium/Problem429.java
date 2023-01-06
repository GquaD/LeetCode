package LeetCode.medium;

import java.util.*;

public class Problem429 {
    //https://leetcode.com/problems/n-ary-tree-level-order-traversal/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/n-ary-tree-level-order-traversal/solutions/3006398/java-dfs-map-optimized-from-7-ms-to-4-ms/
    //Runtime
    //4 ms
    //Beats
    //56.1%
    //Memory
    //46.9 MB
    //Beats
    //53.55%
    static List<List<Integer>> levelOrder(NTreeNode node) {
        if (node == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        traverseTree(node, map, 0);
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        List<List<Integer>> res = new ArrayList<>();
        for (int key : keys) {
            res.add(map.get(key));
        }
        return res;
    }

    //20 min
    //Runtime
    //7 ms
    //Beats
    //35.60%
    //Memory
    //46.8 MB
    //Beats
    //57.31%

    static List<List<Integer>> levelOrder1(NTreeNode node) {
        if (node == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        traverseTree(node, map, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (int key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private static void traverseTree(NTreeNode node, Map<Integer, List<Integer>> map, int lvl) {
        if (node == null) return;

        lvl++;

        List<Integer> list = map.get(lvl);
        if (list == null) {
            list = new ArrayList<>();
            list.add(node.val);
            map.put(lvl, list);
        } else list.add(node.val);

        for (int i = 0; i < node.children.size(); i++) {
            NTreeNode child = node.children.get(i);
            traverseTree(child, map, lvl);
        }
    }
}
