package LeetCode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Problem530 {
    //https://leetcode.com/problems/minimum-absolute-difference-in-bst/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-absolute-difference-in-bst/solutions/3116686/java-dfs-solution/
    //5 min
    //Runtime
    //4 ms
    //Beats
    //22.25%
    //Memory
    //42.9 MB
    //Beats
    //45.88%
    static int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        goDFS(root, list);
        Collections.sort(list);
        int min = 100_001;
        for (int i = 1; i < list.size(); i++) {
            int diff = Math.abs(list.get(i - 1) - list.get(i));
            if (min > diff) min = diff;
        }
        return min;
    }

    private static void goDFS(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        goDFS(node.left, list);
        goDFS(node.right, list);
    }
}
