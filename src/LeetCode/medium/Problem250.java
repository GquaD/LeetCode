package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem250 {
    //https://leetcode.com/problems/count-univalue-subtrees/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-univalue-subtrees/solutions/4914439/java-dfs-o-n-hashset-solution/
    //15-20min
    //Runtime
    //3
    //ms
    //Beats
    //9.61%
    //of users with Java
    //Memory
    //42.90
    //MB
    //Beats
    //8.79%
    //of users with Java
    static int countUnivalSubtrees(TreeNode root) {
        int[] res = new int[1];
        Set<Integer> set = traverseDFS(root, res);
        if (set.size() == 1) res[0]++;
        return res[0];
    }

    private static Set<Integer> traverseDFS(TreeNode node, int[] arr) {
        if (node == null) return new HashSet<>();

        Set<Integer> left = traverseDFS(node.left, arr), right = traverseDFS(node.right, arr);
        if (left.size() < 2 && right.size() < 2) {
            if (left.size() == 1 && right.size() == 1) {
                arr[0]+=2;
            } else if (left.size() == 1 || right.size() == 1) {
                arr[0]++;
            }
        } else if (left.size() == 1 || right.size() == 1) {
            arr[0]++;
        }
        left.addAll(right);
        left.add(node.val);
        return left;
    }
}
