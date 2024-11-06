package LeetCode.medium;

public class Problem776 {
    //https://leetcode.com/problems/split-bst/solutions/6015225/java-o-n-one-pass-solution-100-faster/
    public static void main(String[] args) {

    }

    //15min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.28
    //MB
    //Beats
    //97.99%
    public TreeNode[] splitBST(TreeNode root, int target) {
        TreeNode[] res = new TreeNode[2];
        goDFS(root, target, null, null, res);
        return res;
    }

    private void goDFS(TreeNode node, int t, TreeNode left, TreeNode right, TreeNode[] res) {
        if (node == null) return;

        if (node.val <= t) {
            if (res[0] == null) {
                res[0] = new TreeNode(node.val);
                left = res[0];
            } else if (node.val < left.val) {
                left.left = new TreeNode(node.val);
                left = left.left;
            } else if (node.val > left.val) {
                left.right = new TreeNode(node.val);
                left = left.right;
            }
        } else {
            if (res[1] == null) {
                res[1] = new TreeNode(node.val);
                right = res[1];
            } else if (node.val < right.val) {
                right.left = new TreeNode(node.val);
                right = right.left;
            } else if (node.val > right.val) {
                right.right = new TreeNode(node.val);
                right = right.right;
            }
        }
        goDFS(node.left, t, left, right, res);
        goDFS(node.right, t, left, right, res);
    }
}
