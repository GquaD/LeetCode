package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem653 {
    //https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/two-sum-iv-input-is-a-bst/solutions/2680420/java-recursive-solution-with-memoization/
    //5 min
    //Runtime
    //9 ms
    //Beats
    //27.49%
    //Memory
    //53.8 MB
    //Beats
    //11%
    static Set<Integer> set;
    static boolean result;
    static boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        result = false;
        traverseBST(root, k);
        return result;
    }

    private static void traverseBST(TreeNode root, int k) {
        if (root == null) return;

        if (set.contains(k - root.val)) {
            result = true;
            return;
        } else {
            set.add(root.val);
        }

        traverseBST(root.left, k);
        traverseBST(root.right, k);
    }
}
