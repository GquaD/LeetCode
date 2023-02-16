package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem199 {
    //https://leetcode.com/problems/binary-tree-right-side-view/
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        n3.right = n4;
        LeetCodeUtils.printList(rightSideView(n1));
    }

    //https://leetcode.com/problems/binary-tree-right-side-view/solutions/3191943/java-100-8-lines-o-n-dfs/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.1 MB
    //Beats
    //54.84%
    static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        goDFS(root, 0, list);
        return list;
    }

    private static void goDFS(TreeNode node, int lvl, List<Integer> list) {
        if (node == null) return;
        if (list.size() < lvl++ + 1) list.add(node.val);
        goDFS(node.right, lvl, list);
        goDFS(node.left, lvl, list);
    }

/*    static List<Integer> result;
    static boolean found;
    static List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        found = false;
        goDFS(root, new ArrayList<>());
        return result;
    }

    private static void goDFS(TreeNode node, List<Integer> list) {
        if (node == null || found) return;

        list.add(node.val);

        if (node.left == null && node.right == null) {
            result = list;
            found = true;
            return;
        }
        goDFS(node.right, list);
        goDFS(node.left, list);
    }*/
}
