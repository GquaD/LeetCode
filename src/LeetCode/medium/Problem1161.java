package LeetCode.medium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Problem1161 {
    //https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
    public static void main(String[] args) {

    }

    //not right solution
    static int maxLevelSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        goDFS(root, 1, list);
        int max = Integer.MIN_VALUE, lvlMax = 0;
        for (int i = 0; i < list.size(); i++) {
            int sum = list.get(i);
            if (max < sum) {
                max = sum;
                lvlMax = i;
            }
        }
        return lvlMax;
    }

    private static void goDFS(TreeNode node, int lvl, List<Integer> list) {
        if (node == null) return;

        if (list.size() <= lvl)
            list.add(node.val);
        else
            list.add(list.get(lvl) + node.val);
        lvl++;
        goDFS(node.left, lvl, list);
        goDFS(node.right, lvl, list);
    }


    //https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/solutions/3149050/java-o-n-k-linkedhashmap/
    //10-15 min
    //Runtime
    //13 ms
    //Beats
    //37.71%
    //Memory
    //44.6 MB
    //Beats
    //97.40%
    static int maxLevelSum1(TreeNode root) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        goDFS1(root, 1, map);
        int max = Integer.MIN_VALUE, lvlMax = 0;
        for (int lvl : map.keySet()) {
            int sum = map.get(lvl);
            if (max < sum) {
                max = sum;
                lvlMax = lvl;
            }
        }
        return lvlMax;
    }

    private static void goDFS1(TreeNode node, int lvl, Map<Integer, Integer> map) {
        if (node == null) return;

        int sum = map.computeIfAbsent(lvl, k -> 0);
        sum += node.val;
        map.put(lvl, sum);
        lvl++;
        goDFS1(node.left, lvl, map);
        goDFS1(node.right, lvl, map);
    }
}
