package LeetCode.easy;

public class Problem112 {
    //https://leetcode.com/problems/path-sum/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/path-sum/solutions/2735219/java-dfs-in-just-0-ms/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.4 MB
    //Beats
    //87.38%
    static boolean result;
    static boolean hasPathSum(TreeNode root, int targetSum) {
        result = false;
        traverseBT(root, 0, targetSum);
        return result;
    }

    private static void traverseBT(TreeNode node, int sum, int targetSum) {
        if (node == null) return;

        sum += node.val;

        if (node.left == null && node.right == null && sum == targetSum) {
            result = true;
            return;
        }
        traverseBT(node.left, sum, targetSum);
        traverseBT(node.right, sum, targetSum);
    }
}
