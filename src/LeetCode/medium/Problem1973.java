package LeetCode.medium;

public class Problem1973 {
    //https://leetcode.com/problems/count-nodes-equal-to-sum-of-descendants
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-nodes-equal-to-sum-of-descendants/solutions/4715558/java-dfs-o-n-solution/
    //5-10min
    //Runtime
    //10
    //ms
    //Beats
    //30.70%
    //of users with Java
    //Memory
    //77.14
    //MB
    //Beats
    //22.81%
    //of users with Java
    static int equalToDescendants(TreeNode root) {
        int res[] = new int[1];
        goDFS(root, res);
        return res[0];
    }

    private static int goDFS(TreeNode node, int[] res) {
        if (node == null) return 0;

        int sum = goDFS(node.left, res) + goDFS(node.right, res);
        if (sum == node.val) res[0]++;
        return sum + node.val;
    }
}
