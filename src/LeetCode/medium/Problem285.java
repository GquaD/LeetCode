package LeetCode.medium;

public class Problem285 {
    //https://leetcode.com/problems/inorder-successor-in-bst/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/inorder-successor-in-bst/solutions/4901509/java-dfs-solution/
    //15min (because I tried to solve using in order traversal)
    //Runtime
    //3
    //ms
    //Beats
    //35.77%
    //of users with Java
    //Memory
    //45.55
    //MB
    //Beats
    //63.36%
    //of users with Java
    static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode[] res = new TreeNode[1];
        int[] arr = new int[]{100_001};
        traverseDFS(root, p, res, arr);
        return res[0];
    }

    private static void traverseDFS(TreeNode node, TreeNode p, TreeNode[] res, int[] arr) {
        if (node == null) return;

        if (node.val > p.val && arr[0] > node.val) {
            arr[0] = node.val;
            res[0] = node;
        }

        traverseDFS(node.left, p, res, arr);
        traverseDFS(node.right, p, res, arr);
    }
}
