package LeetCode.easy;

public class Problem404 {
    //https://leetcode.com/problems/sum-of-left-leaves/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/sum-of-left-leaves/solutions/2869136/java-100-faster-0ms-dfs-solution/
    //5 mins
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.8 MB
    //Beats
    //61.72%
    static int sum;
    static int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        traverseBST(root);
        return sum;
    }

    private static void traverseBST(TreeNode node) {
        if (node == null) return;
        if (node.left != null && node.left.left == null && node.left.right == null) sum += node.left.val;
        traverseBST(node.left);
        traverseBST(node.right);
    }
}
