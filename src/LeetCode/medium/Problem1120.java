package LeetCode.medium;

public class Problem1120 {
    //https://leetcode.com/problems/maximum-average-subtree/
    public static void main(String[] args) {

    }

    static double maximumAverageSubtree(TreeNode root) {
        double[] arr = new double[1];
        goDFS(root, arr);
        return arr[0];
    }

    //https://leetcode.com/problems/maximum-average-subtree/solutions/5341396/java-dfs-100-faster-solution/
    //10min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //44.99
    //MB
    //Beats
    //59.31%
    private static int[] goDFS(TreeNode node, double[] arr) {
        if (node == null) return new int[]{0, 0}; //{sum, # of nodes}

        int[] l = goDFS(node.left, arr), r = goDFS(node.right, arr);
        int sum = l[0] + r[0] + node.val, num = l[1] + r[1] + 1;
        double cur = ((sum) * 1.0) / (num);
        arr[0] = Math.max(cur, arr[0]);
        return new int[]{sum, num};
    }
}
