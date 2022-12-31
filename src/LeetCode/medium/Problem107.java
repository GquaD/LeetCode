package LeetCode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class Problem107 {
    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/solutions/2974269/java-treemap-dfs-solution/
    //10-15min
    //Runtime
    //2 ms
    //Beats
    //57.57%
    //Memory
    //42.6 MB
    //Beats
    //76.64%

    static List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        traverseBST(root, map, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (int key : map.keySet()) result.add(map.get(key));
        return result;
    }

    //Runtime
    //2 ms
    //Beats
    //57.57%
    //Memory
    //42.7 MB
    //Beats
    //70.72%

    static List<List<Integer>> levelOrderBottom1(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        traverseBST(root, map, 0);
        List<Integer> keysSorted = map.keySet().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>(keysSorted.size());
        for (int key : keysSorted) result.add(map.get(key));
        return result;
    }

    private static void traverseBST(TreeNode node, Map<Integer, List<Integer>> map, int lvl) {
        if (node == null) return;

        lvl++;

        traverseBST(node.left, map, lvl);

        if (map.containsKey(lvl)) {
            map.get(lvl).add(node.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            map.put(lvl, list);
        }

        traverseBST(node.right, map, lvl);
    }
}
