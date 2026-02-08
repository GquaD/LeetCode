package LeetCode.easy;

public class Problem110 {
    //10 min

    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.97
    //MB
    //Beats
    //10.71%

    public boolean isBalanced(TreeNode root) {
        boolean[] result = new boolean[]{true};
        checkBalanced(root, 0, result);
        return result[0];
    }

    private int checkBalanced(TreeNode node, int level, boolean[] result) {
        if (node == null) return 0;

        int left = checkBalanced(node.left, level + 1, result), right = checkBalanced(node.right, level + 1, result);

        if (Math.abs(left - right) > 1) {
            result[0] = false;
            return 0;
        }

        return Math.max(left, right) + 1;
    }

}
