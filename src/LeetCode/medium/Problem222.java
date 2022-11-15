package LeetCode.medium;

public class Problem222 {
    //https://leetcode.com/problems/count-complete-tree-nodes/
    public static void main(String[] args) {

    }
    //
    //for prev solution - 30 mins
    //for this solution - 5 mins
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //49.6 MB
    //Beats
    //63.82%
    static int inc;
    static int countNodes(TreeNode root) {
        inc = 0;
        goDFS(root);
        return inc;
    }

    private static void goDFS(TreeNode node) {
        if (node == null) return;
        inc++;
        goDFS(node.left);
        goDFS(node.right);
    }


    static int level;
    static int count;

    static int countNodes1(TreeNode root) {
        if (root == null) return 0;
        count = 0;
        level = 0;
        traverseBTFromRight(root, 0);
        return level > 1 ? (int) Math.pow(2, level) - count : 1;
    }

    private static void traverseBTFromRight(TreeNode node, int lev) {
        if (node == null) {
            level = lev;
            return;
        }
        lev++;
        if (node.left == null && node.right == null && lev == level) {
            count++;
        }
        traverseBTFromRight(node.right, lev);
        traverseBTFromRight(node.left, lev);
    }
}
