package LeetCode.medium;
import java.util.*;

public class Problem1676 {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/solutions/4780888/java-dfs-o-n-solution/
    //1hour
    //Runtime
    //6
    //ms
    //Beats
    //31.31%
    //of users with Java
    //Memory
    //48.28
    //MB
    //Beats
    //6.31%
    //of users with Java
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (TreeNode n : nodes) {
            set.add(n.val);
            sum += n.val;
        }
        TreeNode[] res = new TreeNode[1];
        goDFS(root, 0, set, sum, res);
        return res[0];
    }

    private static int goDFS(TreeNode node, int curSum, Set<Integer> set, int sum, TreeNode[] res) {
        if (node == null) return 0;

        int left = goDFS(node.left, curSum, set, sum, res), right = goDFS(node.right, curSum, set, sum, res);

        if (set.contains(node.val)) {
            curSum += node.val;
        }

        if (res[0] == null && (left + right == sum || curSum == sum || curSum + left + right == sum)) {
            res[0] = node;
            return sum;
        }

        return curSum + left + right;
    }
}
