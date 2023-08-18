package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2583 {
    //https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/solutions/3924770/java-dfs-list-of-longs/
    //5-10 min
    //Runtime
    //36 ms
    //Beats
    //61.81%
    //Memory
    //76.5 MB
    //Beats
    //7.87%
    static long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> list = new ArrayList<>();
        dfs(root, list, 0);

        if (k > list.size()) return -1;
        Collections.sort(list);
        return list.get(list.size() - k);
    }

    private static void dfs(TreeNode node, List<Long> list, int lvl) {
        if (node == null) return;

        if (lvl >= list.size()) list.add(0L);

        list.set(lvl, list.get(lvl) + node.val);

        dfs(node.left, list, lvl + 1);
        dfs(node.right, list, lvl + 1);
    }
}
