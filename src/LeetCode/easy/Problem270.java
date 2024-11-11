package LeetCode.easy;

public class Problem270 {
    //https://leetcode.com/problems/closest-binary-search-tree-value/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/closest-binary-search-tree-value/solutions/6033928/java-100-faster/
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //43.07
    //MB
    //Beats
    //44.00%
    public int closestValue(TreeNode root, double target) {
        double[] arr = new double[]{1_000_000_000, 1_000_000_000};
        goDFS(root, target, arr);
        return (int) arr[1];
    }

    private void goDFS(TreeNode node, double target, double[] arr) {
        if (node == null) return;

        double diff = Math.abs(target - node.val);
        if (diff <= arr[0]) {
            arr[0] = diff;
            arr[1] = Math.abs(target - arr[1]) == Math.abs(target - node.val) ?  Math.min(node.val, arr[1]) : node.val;
        }
        goDFS(node.left, target, arr);
        goDFS(node.right, target, arr);
    }
}
