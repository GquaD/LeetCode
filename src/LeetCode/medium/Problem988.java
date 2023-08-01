package LeetCode.medium;

public class Problem988 {
    //https://leetcode.com/problems/smallest-string-starting-from-leaf/
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(25);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(2);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.left = n6;
        n5.right = n7;
        System.out.println(smallestFromLeaf(n1));
    }

    //https://leetcode.com/problems/smallest-string-starting-from-leaf/solutions/3848171/java-100-faster-dfs-stringbuilder/
    //20 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //43.3 MB
    //Beats
    //94.63%
    static String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        String[] smallest = new String[1];
        dfs(root, sb, smallest);
        return smallest[0];
    }

    private static void dfs(TreeNode node, StringBuilder sb, String[] smallest) {
        if (node == null) return;

        sb.append((char)(node.val + 'a'));

        if (node.left == null && node.right == null) {
            String s = sb.reverse().toString();
            if (smallest[0] == null) smallest[0] = s;
            else if (s.compareTo(smallest[0]) < 0) smallest[0] = s;
            sb.reverse().setLength(sb.length() - 1);
            return;
        }

        dfs(node.left, sb, smallest);
        dfs(node.right, sb, smallest);
        sb.setLength(sb.length() - 1);
    }
}
