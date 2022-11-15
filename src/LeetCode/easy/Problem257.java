package LeetCode.easy;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem257 {
    //https://leetcode.com/problems/binary-tree-paths/
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n2.right = n5;
        n1.right = n3;
        LeetCodeUtils.printList(binaryTreePaths(n1));
    }

    //30 mins
    //https://leetcode.com/problems/binary-tree-paths/solutions/2816197/java-dfs-solution-in-6-ms/
    //Runtime
    //6 ms
    //Beats
    //70.2%
    //Memory
    //43.2 MB
    //Beats
    //51.55%
    static List<String> binaryTreePaths(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        goDFS(root, list, result);
        StringBuilder sb = new StringBuilder();
        List<String> strings = new ArrayList<>();
        for (List<Integer> l : result) {
            for (int i = 0; i < l.size() - 1; i++) {
                sb.append(l.get(i)).append("->");
            }
            sb.append(l.get(l.size() - 1));
            strings.add(sb.toString());
            sb.setLength(0);
        }

        return strings;
    }

    private static void goDFS(TreeNode node, List<Integer> list, List<List<Integer>> result) {
        if (node == null) return;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(list));
        }
        goDFS(node.left, list, result);
        goDFS(node.right, list, result);
        list.remove(list.size() - 1);
    }

    static List<String> binaryTreePaths1(TreeNode root) {
        List<String> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        goDFS1(root, list, sb);
        return list;
    }

    private static void goDFS1(TreeNode node, List<String> list, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append("->");
        if (node.left == null && node.right == null) {
            list.add(sb.substring(0, sb.length() - 2));
        }
        goDFS1(node.left, list, sb);
        goDFS1(node.right, list, sb);
        sb.replace(sb.length() - 3, sb.length(), "");
    }
}
