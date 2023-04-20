package LeetCode.medium;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem662 {
    //https://leetcode.com/problems/maximum-width-of-binary-tree/description/
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;

        /*TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;*/
        System.out.println(widthOfBinaryTree(n1));
    }

    //https://leetcode.com/problems/maximum-width-of-binary-tree/solutions/3436867/java-dfs-o-n-solution/
    //1.5 hours
    //Runtime
    //2 ms
    //Beats
    //41.32%
    //Memory
    //42.1 MB
    //Beats
    //69.23%
    static int widthOfBinaryTree(TreeNode root) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        goDFS(root, 0, 0, list);
        int max = 0;
        for (Pair<Integer, Integer> p : list) max = Math.max(p.getKey() == p.getValue() ? 1 : p.getValue() - p.getKey() + 1, max);
        return max;
        /*for (List<Integer> l : list) {
            int left = l.get(0), right = l.get(l.size() - 1);
            int curr = left == right ? 1 : right - left + 1;
            max = Math.max(curr, max);
        }
        return max;*/
    }

    private static void goDFS(TreeNode node, int row, int col, List<Pair<Integer, Integer>> list) {
        if (node == null) return;

        if (list.size() <= row) list.add(new Pair<>(col, -1));
        else list.set(row, new Pair<>(list.get(row).getKey(), col));

        goDFS(node.left, row + 1, col * 2, list);
        goDFS(node.right, row + 1, col * 2 + 1, list);
    }

    static int widthOfBinaryTree2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int max = 0;
        while (!list.isEmpty()) {

            int l = -1, r = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    l = i;
                    break;
                }
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) != null) {
                    r = i;
                    break;
                }
            }
            if (l == -1 && r == -1) break;
            int res = l == r ? 1 : r - l + 1;
            if (max < res) max = res;

            List<TreeNode> listNext = new ArrayList<>();
            //check if has borders and just count
            for (TreeNode node : list) {
                listNext.add(node == null ? null : node.left);
                listNext.add(node == null ? null : node.right);
            }
            list = listNext;
        }
        return max;
    }

    static int widthOfBinaryTree1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int max = 0;
        while (!list.isEmpty()) {

            int l = -1, r = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    l = i;
                    break;
                }
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) != null) {
                    r = i;
                    break;
                }
            }
            if (l == -1 && r == -1) break;
            int res = l == r ? 1 : r - l + 1;
            if (max < res) max = res;

            List<TreeNode> listNext = new ArrayList<>();

            for (TreeNode node : list) {
                listNext.add(node == null ? null : node.left);
                listNext.add(node == null ? null : node.right);
            }
            list = listNext;
        }
        return max;
    }

    //memory limit exceeded 72/114
/*    static int widthOfBinaryTree(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        goDFS(root, list, 0);
        List<Integer> res = new ArrayList<>();
        for (List<Integer> last : list) {
            int l = -1, r = -1;
            for (int i = 0; i < last.size(); i++) {
                if (last.get(i) > -101) {
                    l = i;
                    break;
                }
            }
            for (int i = last.size() - 1; i >= 0; i--) {
                if (last.get(i) > -101) {
                    r = i;
                    break;
                }
            }
            res.add(l == r ? 1 : r - l + 1);
        }

        int max = 0;
        for (int n : res) if (max < n) max = n;
        return max;
    }

    private static void goDFS(TreeNode node, List<List<Integer>> list, int lvl) {
        if (node == null) {
            if (lvl < list.size()) {
                int l = lvl, bin = 1;
                while (l < list.size()) {
                    for (int i = 0; i < bin; i++) list.get(l).add(-101);
                    bin *= 2;
                    l++;
                }
            }
            return;
        }

        if (lvl >= list.size()) {
            List<Integer> l = new ArrayList<>();
            l.add(node.val);
            list.add(l);
        } else {
            list.get(lvl).add(node.val);
        }

        goDFS(node.left, list, ++lvl);
        goDFS(node.right, list, lvl);
    }*/
}
