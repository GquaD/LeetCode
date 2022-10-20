package LeetCode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem637 {
    //https://leetcode.com/problems/average-of-levels-in-binary-tree/

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/average-of-levels-in-binary-tree/solutions/2725388/java-o-n-solution/
    //Runtime
    //5 ms
    //Beats
    //37.61%
    //Memory
    //47.6 MB
    //Beats
    //57.52%
    static Map<Integer, Pair> map;
    static List<Double> averageOfLevels(TreeNode root) {
        map = new HashMap<>();
        traverseTree(root, 0);
        List<Double> list = new ArrayList<>(map.keySet().size());
        for (Integer key : map.keySet()) {
            Pair p = map.get(key);
            list.add(p.sum * 1.0 / p.count);
        }
        return list;
    }

    private static void traverseTree(TreeNode node, int lvl) {
        if (node == null) return;

        if (map.containsKey(lvl)) {
            Pair pair = map.get(lvl);
            pair.sum += node.val;
            pair.count++;
        } else {
            Pair pair = new Pair(node.val, 1);
            map.put(lvl, pair);
        }
        lvl++;
        traverseTree(node.left, lvl);
        traverseTree(node.right, lvl);
    }

    static class Pair {
        long sum;
        int count;

        public Pair(long sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
}
