package LeetCode.medium;

import java.util.*;

public class Problem103 {
    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solutions/3088870/java-3-solutions-from-4ms-to-1ms-o-n/?orderBy=most_votes
    //5 min
    //Runtime
    //1 ms
    //Beats
    //90.17%
    //Memory
    //42.2 MB
    //Beats
    //41.3%
    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        goDFSLeft(0, root, lists);
        goDFSRight(0, root, lists);
        return lists;
    }

    private static void goDFSLeft(int lvl, TreeNode node, List<List<Integer>> lists) {
        if (node == null) return;

        if (lvl % 2 == 0) {
            if (lists.size() < lvl + 1) {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                lists.add(list);
            } else {
                lists.get(lvl).add(node.val);
            }
        } else if (lists.size() < lvl + 1){
            lists.add(new ArrayList<>());
        }
        lvl++;
        goDFSLeft(lvl, node.left, lists);
        goDFSLeft(lvl, node.right, lists);
    }

    private static void goDFSRight(int lvl, TreeNode node, List<List<Integer>> lists) {
        if (node == null) return;

        if (lvl % 2 == 1) {
            if (lists.size() < lvl + 1) {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                lists.add(list);
            } else {
                lists.get(lvl).add(node.val);
            }
        }
        lvl++;
        goDFSRight(lvl, node.right, lists);
        goDFSRight(lvl, node.left, lists);
    }

    //5 min
    //Runtime
    //1 ms
    //Beats
    //90.17%
    //Memory
    //42.9 MB
    //Beats
    //23.56%
    static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        goDFS2(0, root, lists);
        for (int i = 1; i < lists.size(); i+=2) Collections.reverse(lists.get(i));
        return lists;
    }

    private static void goDFS2(int lvl, TreeNode node, List<List<Integer>> lists) {
        if (node == null) return;

        if (lists.size() < lvl + 1) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            lists.add(list);
        } else {
            lists.get(lvl).add(node.val);
        }
        lvl++;
        goDFS2(lvl, node.left, lists);
        goDFS2(lvl, node.right, lists);
    }

    //10 min
    //Runtime
    //4 ms
    //Beats
    //6.72%
    //Memory
    //42.6 MB
    //Beats
    //31.7%

    static List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        goDFS1(0, root, map);

        List<List<Integer>> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (key % 2 == 1) Collections.reverse(map.get(key));
            list.add(map.get(key));
        }

        return list;
    }

    private static void goDFS1(int lvl, TreeNode node, TreeMap<Integer, List<Integer>> map) {
        if (node == null) return;

        List<Integer> list = map.computeIfAbsent(lvl, k -> new ArrayList<>());
        list.add(node.val);
        lvl++;
        goDFS1(lvl, node.left, map);
        goDFS1(lvl, node.right, map);
    }
}
