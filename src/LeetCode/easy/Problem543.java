package LeetCode.easy;

public class Problem543 {
    //https://leetcode.com/problems/diameter-of-binary-tree/description/
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        int res = diameterOfBinaryTree(n1);
        System.out.println(res);
    }

    //https://leetcode.com/problems/diameter-of-binary-tree/solutions/4789796/java-dfs-100-faster/
    //20 min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //42.36
    //MB
    //Beats
    //93.13%
    //of users with Java
    static int sum;
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root.right == null && root.left == null) return 0;
        sum = 0;
        goDFS(root);
        return sum;
    }

    private static int goDFS(TreeNode node) {
        if (node == null) return 0;

        int l = goDFS(node.left), r = goDFS(node.right);

        sum = Math.max(l + r, sum);

        return 1 + Math.max(l, r);
    }
}
