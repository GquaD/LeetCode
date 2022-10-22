package LeetCode.easy;

public class Problem111 {
    //https://leetcode.com/problems/minimum-depth-of-binary-tree/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-depth-of-binary-tree/solutions/2732156/java-dfs-solution/
    //Runtime
    //18 ms
    //Beats
    //23.54%
    //Memory
    //87.2 MB
    //Beats
    //69.76%
    static int minDepth;

    static int minDepth(TreeNode root) {
        if (root == null) return 0;
        minDepth = Integer.MAX_VALUE;
        traverseBT(root, 1);
        return minDepth;
    }

    private static void traverseBT(TreeNode node, int depth) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            if (minDepth > depth) {
                minDepth = depth;
            }
        }
        depth++;
        traverseBT(node.left, depth);
        traverseBT(node.right, depth);
    }
}
