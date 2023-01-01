package LeetCode.medium;

public class Problem129 {
    //https://leetcode.com/problems/sum-root-to-leaf-numbers/
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(0);
        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        n1.right = n5;
        System.out.println(sumNumbers(n1));
    }

    //
    //15 min
    //Runtime
    //1 ms
    //Beats
    //32.41%
    //Memory
    //40.2 MB
    //Beats
    //71.85%
    static int sum;
    static int sumNumbers(TreeNode root) {
        sum = 0;
        traverseBT(root, new StringBuilder());
        return sum;
    }

    private static void traverseBT(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        sb.append(node.val);

        if (node.left == null && node.right == null) {
            sum += Integer.parseInt(sb.toString());
        }
        traverseBT(node.left, sb);
        traverseBT(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
