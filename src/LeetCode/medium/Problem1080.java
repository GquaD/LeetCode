package LeetCode.medium;

public class Problem1080 {
    //https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/solutions/3626033/java-dfs-o-n-1ms-solution/
    //10-15 min
    //Runtime
    //1 ms
    //Beats
    //88.7%
    //Memory
    //44 MB
    //Beats
    //27.84%
    static TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root.left == null && root.right == null) return root.val < limit ? null : root;
        dfs(root, 0, limit);
        if (root.left == null && root.right == null) return root.val < limit ? null : root;
        return root;
    }

    private static boolean dfs(TreeNode node, int sum, int limit) {
        if (node == null) return false;

        sum += node.val;
        if (node.left == null && node.right == null) return sum >= limit;

        boolean leftHasSufficient = dfs(node.left, sum, limit);
        boolean rightHasSufficient = dfs(node.right, sum, limit);

        if (!leftHasSufficient) node.left = null;
        if (!rightHasSufficient) node.right = null;

        return leftHasSufficient || rightHasSufficient;
    }
}
