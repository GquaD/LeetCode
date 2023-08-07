package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1609 {
    //https://leetcode.com/problems/even-odd-tree/description/
    public static void main(String[] args) {

    }


    //15-20min
    //Runtime
    //23 ms
    //Beats
    //22.22%
    //Memory
    //97.2 MB
    //Beats
    //5.9%
    static boolean isEvenOddTree(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, 0);
        if (list.size() >= 1 && list.get(0).get(0) % 2 == 0) return false;
        for (int i = 1; i < list.size(); i++) {
            List<Integer> t = list.get(i);
            if (i % 2 == 0) {
                if (t.get(0) % 2 == 0) return false;
            } else {
                if (t.get(0) % 2 == 1) return false;
            }
            for (int j = 1; j < t.size(); j++) {
                if (i % 2 == 0) {
                    if (t.get(j - 1) >= t.get(j) || t.get(j) % 2 == 0) return false;
                } else {
                    if (t.get(j - 1) <= t.get(j) || t.get(j) % 2 == 1) return false;
                }
            }
        }
        return true;
    }

    private static void dfs(TreeNode node, List<List<Integer>> list, int lvl) {
        if (node == null) return;

        if (list.size() == lvl) list.add(new ArrayList<>());
        list.get(lvl).add(node.val);
        dfs(node.left, list, lvl + 1);
        dfs(node.right, list, lvl + 1);
    }
}
