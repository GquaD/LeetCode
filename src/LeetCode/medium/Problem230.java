package LeetCode.medium;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem230 {
    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/solutions/2934740/java-using-treeset/
    //10-15 min
    //Runtime
    //5 ms
    //Beats
    //9.49%
    //Memory
    //43.2 MB
    //Beats
    //75.96%
    static int kthSmallest(TreeNode root, int k) {
        Set<Integer> set = new TreeSet<>();
        traverseBST(root, set);
        int count = 1;
        for (int n : set) {
            if (count++ == k) return n;
        }
        return k;
    }

    private static void traverseBST(TreeNode node, Set<Integer> set) {
        if (node == null) return;

        set.add(node.val);
        traverseBST(node.left, set);
        traverseBST(node.right, set);
    }
}
