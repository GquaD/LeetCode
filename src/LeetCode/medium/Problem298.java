package LeetCode.medium;

public class Problem298 {
    //https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
    public static void main(String[] args) {

    }

    //10min
    //Runtime
    //1
    //ms
    //Beats
    //81.76%
    //of users with Java
    //Memory
    //45.12
    //MB
    //Beats
    //95.87%
    //of users with Java
    static int longestConsecutive(TreeNode root) {
        int[] res = new int[1];
        goDFS(root, 1, res);
        return res[0];
    }

    private static void goDFS(TreeNode node, int len, int[] res) {
        if (node == null) return;

        res[0] = Math.max(len, res[0]);
        if (node.left != null && node.left.val - 1 == node.val) {
            goDFS(node.left, len + 1, res);
        } else {
            goDFS(node.left, 1, res);
        }

        if (node.right != null && node.right.val - 1 == node.val) {
            goDFS(node.right, len + 1, res);
        } else {
            goDFS(node.right, 1, res);
        }
    }
}
