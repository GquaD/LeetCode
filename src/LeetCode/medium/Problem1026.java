package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1026 {
    //https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/solutions/2765825/java-just-in-0ms-100-faster-3-solutions-recursion/
    //1st solution took 10 mins
    //30-40 mins to all solutions
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.8 MB
    //Beats
    //97.91%
    int maxDiff1;
    public int maxAncestorDiff2(TreeNode root) {
        maxDiff1 = 0;
        traverseBST1(root, 0, 1_000_000);
        return maxDiff1;
    }

    private void traverseBST1(TreeNode node, int max, int min) {
        if (node == null) return;

        max = Math.max(node.val, max);
        min = Math.min(node.val, min);

        if (node.left == null && node.right == null) {
            int diff = max - min;
            maxDiff1 = Math.max(maxDiff1, diff);
        }

        traverseBST1(node.left, max, min);
        traverseBST1(node.right, max, min);
    }

    //Runtime
    //1 ms
    //Beats
    //83.96%
    //Memory
    //42.5 MB
    //Beats
    //43.96%
    static int maxDiff;
    static int maxAncestorDiff(TreeNode root) {
        maxDiff = 0;
        traverseBST(root, 0, 1_000_000);
        return maxDiff;
    }

    private static void traverseBST(TreeNode node, int max, int min) {
        if (node == null) return;

        if (max < node.val) {
            max = node.val;
        }

        if (min > node.val) {
            min = node.val;
        }

        if (node.left == null && node.right == null) {
            int diff = max - min;
            if (maxDiff < diff) {
                maxDiff = diff;
            }
        }

        traverseBST(node.left, max, min);
        traverseBST(node.right, max, min);
    }

    //
    //Runtime
    //247 ms
    //Beats
    //5.27%
    //Memory
    //42.4 MB
    //Beats
    //51.43%

    static int maxAncestorDiff1(TreeNode root) {
        maxDiff = 0;
        goThruTheBST(root, new ArrayList<>());
        return maxDiff;
    }

    private static void goThruTheBST(TreeNode node, List<Integer> ancestors) {
        if (node == null) return;

        for (int n : ancestors) {
            int diff = Math.abs(n - node.val);
            if (maxDiff < diff) {
                maxDiff = diff;
            }
        }
        ancestors.add(node.val);
        goThruTheBST(node.left, ancestors);
        goThruTheBST(node.right, ancestors);
        ancestors.remove(ancestors.size() - 1);
    }
}
