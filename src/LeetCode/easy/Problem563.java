package LeetCode.easy;

public class Problem563 {
    //https://leetcode.com/problems/binary-tree-tilt/
    public static void main(String[] args) {

    }

    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.5 MB
    //Beats
    //50.31%
    static int result;
    static int findTilt(TreeNode root) {
        result = 0;
        goDFS(root);
        return result;
    }

    static int goDFS(TreeNode node) {
        if (node == null) return 0;
        int l = goDFS(node.left), r = goDFS(node.right);
        result += Math.abs(l - r);
        return l + r + node.val;
    }

}
