package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem2641 {
    //https://leetcode.com/problems/cousins-in-binary-tree-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/cousins-in-binary-tree-ii/solutions/5352017/java-2xdfs-solution/
    //5min
    //Runtime
    //29
    //ms
    //Beats
    //42.75%
    //Analyze Complexity
    //Memory
    //85.45
    //MB
    //Beats
    //25.95%
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        goDFSSum(root, list, 0);
        goDFS(root, list, 1);
        root.val = 0;
        return root;
    }

    private void goDFSSum(TreeNode node, List<Integer> list, int lvl) {
        if (node == null) return;

        if (lvl > list.size() - 1) {
            list.add(node.val);
        } else {
            list.set(lvl, list.get(lvl) + node.val);
        }

        goDFSSum(node.left, list, ++lvl);
        goDFSSum(node.right, list, lvl);
    }

    private void goDFS(TreeNode node, List<Integer> list, int lvl) {
        if (node == null) return;

        if (node.left != null && node.right != null) {
            int children = node.left.val + node.right.val;
            int newVal = list.get(lvl) - children;
            node.left.val = newVal;
            node.right.val = newVal;
        } else if (node.left != null) {
            int newVal = list.get(lvl) - node.left.val;
            node.left.val = newVal;
        } else if (node.right != null) {
            int newVal = list.get(lvl) - node.right.val;
            node.right.val = newVal;
        }
        goDFS(node.left, list, ++lvl);
        goDFS(node.right, list, lvl);
    }

    //
    //5-10min
    //Runtime
    //49
    //ms
    //Beats
    //29.77%
    //Analyze Complexity
    //Memory
    //91.01
    //MB
    //Beats
    //11.07%
    /*private TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        goDFSSum(root, map, 0);
        goDFS(root, map, 1);
        root.val = 0;
        return root;
    }

    private void goDFSSum(TreeNode node, Map<Integer, Integer> map, int lvl) {
        if (node == null) return;

        map.put(lvl, map.getOrDefault(lvl, 0) + node.val);

        goDFSSum(node.left, map, ++lvl);
        goDFSSum(node.right, map, lvl);
    }

    private void goDFS(TreeNode node, Map<Integer, Integer> map, int lvl) {
        if (node == null) return;

        if (node.left != null && node.right != null) {
            int children = node.left.val + node.right.val;
            int newVal = map.get(lvl) - children;
            node.left.val = newVal;
            node.right.val = newVal;
        } else if (node.left != null) {
            int newVal = map.get(lvl) - node.left.val;
            node.left.val = newVal;
        } else if (node.right != null) {
            int newVal = map.get(lvl) - node.right.val;
            node.right.val = newVal;
        }
        goDFS(node.left, map, ++lvl);
        goDFS(node.right, map, lvl);
    }*/
}
