package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem515 {
    //https://leetcode.com/problems/find-largest-value-in-each-tree-row/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-largest-value-in-each-tree-row/solutions/3295584/java-1-ms-100-faster-solution/
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //42.6 MB
    //Beats
    //45.98%
    static List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        list.add(root.val);
        goDFS(root, 0, list);
        return list;
    }

    private static void goDFS(TreeNode node, int lvl, List<Integer> list) {
        if (node == null) return;

        if (list.size() <= lvl) list.add(node.val);
        else if (list.get(lvl) < node.val) list.set(lvl, node.val);

        goDFS(node.left, ++lvl, list);
        goDFS(node.right, ++lvl, list);
    }
}
