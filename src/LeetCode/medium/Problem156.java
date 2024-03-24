package LeetCode.medium;

public class Problem156 {
    //https://leetcode.com/problems/binary-tree-upside-down/

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/binary-tree-upside-down/solutions/4919401/java-dfs-o-n-1-run-solution/
    //10min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //41.40
    //MB
    //Beats
    //36.36%
    //of users with Java
    static TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode[] res = new TreeNode[1];
        traverseDFS(root, res);
        return res[0] == null ? root : res[0];
    }

    private static void traverseDFS(TreeNode node, TreeNode[] res) {
        if (node == null) return;

        traverseDFS(node.left, res);
        traverseDFS(node.right, res);
        if (node.left != null) {
            if (res[0] == null) {
                res[0] = node.left;
            }

            node.left.right = node;
            node.left.left = node.right;

            node.left = null;
            node.right = null;
        }
    }
}
