package LeetCode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem783 {
    //https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-distance-between-bst-nodes/solutions/3195942/java-o-n-100-faster-dfs-solution/
    //5 min, same as Problem530
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.2 MB
    //Beats
    //35.81%
    static int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        goDFS(root, list);
        int min = 100_001;
        for (int i = 1; i < list.size(); i++) {
            int diff = Math.abs(list.get(i - 1) - list.get(i));
            if (min > diff) min = diff;
        }
        return min;
    }

    private static void goDFS(TreeNode node, List<Integer> list) {
        if (node == null) return;
        goDFS(node.left, list);
        list.add(node.val);
        goDFS(node.right, list);
    }
}
