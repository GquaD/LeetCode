package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem1430 {
    //https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree

    //https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/solutions/5317336/java-dfs-100-faster-solution/
    //10min
    //Runtime
    //8
    //ms
    //Beats
    //100.00%
    //Memory
    //45.12
    //MB
    //Beats
    //32.61%
    public boolean isValidSequence(TreeNode root, int[] arr) {
        Set<String> paths = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        goDFS(root, sb, paths);

        sb.setLength(0);
        for (int n : arr) sb.append(n);
        String target = sb.toString();
        return paths.contains(target);
    }

    private void goDFS(TreeNode node, StringBuilder sb, Set<String> paths) {
        if (node == null) {
            return;
        }

        sb.append(node.val);

        if (node.left == null && node.right == null) {
            paths.add(sb.toString());
        }

        goDFS(node.left, sb, paths);
        goDFS(node.right, sb, paths);

        String t = sb.substring(0, sb.length() - 1);
        sb.setLength(0);
        sb.append(t);
    }
}
