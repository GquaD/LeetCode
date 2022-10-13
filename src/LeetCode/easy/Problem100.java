package LeetCode.easy;

public class Problem100 {
    //https://leetcode.com/problems/same-tree/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/same-tree/solutions/2697557/java-simple-100-faster-solution/
    //less than 5 minutes
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.8 MB
    //Beats
    //30.71%

    static boolean areSame;
    static boolean isSameTree(TreeNode p, TreeNode q) {
        areSame = true;
        traverseBT(p, q);
        return areSame;
    }

    private static void traverseBT(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return;
        }
        if (p == null && q != null || p != null && q == null) {
            areSame = false;
            return;
        }
        if (p.val != q.val) {
            areSame = false;
            return;
        }
        traverseBT(p.left, q.left);
        traverseBT(p.right, q.right);
    }
}
