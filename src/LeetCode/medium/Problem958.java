package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem958 {
    //https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;
        System.out.println(isCompleteTree(node1));
    }

    //https://leetcode.com/problems/check-completeness-of-a-binary-tree/solutions/3298667/java-1-ms-dfs-solution/
    //35-40 min
    //Runtime
    //1 ms
    //Beats
    //83.31%
    //Memory
    //42.2 MB
    //Beats
    //19.97%

    static boolean isCompleteTree(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        list.add(first);
        traverseBT(root, 1, list);
        for (int i = 0; i < list.size() - 2; i++) {
            List<Integer> curr = list.get(i);
            for (int j = 0; j < curr.size(); j++) {
                if (curr.get(j) == 0) return false;
            }
        }
        List<Integer> curr = list.get(list.size() - 2);
        for (int j = 1; j < curr.size(); j++) {
            if (curr.get(j - 1) == 0 && curr.get(j) != 0) return false;
        }
        return true;
    }

    private static void traverseBT(TreeNode node, int lvl, List<List<Integer>> list) {
        if (node == null) return;

        if (list.size() <= lvl) {
            List<Integer> listCur = new ArrayList<>();
            listCur.add(node.left == null ? 0 : node.val);
            listCur.add(node.right == null ? 0 : node.val);
            list.add(listCur);
        } else {
            list.get(lvl).add(node.left == null ? 0 : node.val);
            list.get(lvl).add(node.right == null ? 0 : node.val);
        }
        traverseBT(node.left, ++lvl, list);
        traverseBT(node.right, lvl, list);
    }
}
