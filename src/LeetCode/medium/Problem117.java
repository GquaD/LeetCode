package LeetCode.medium;

import java.util.*;
import java.util.LinkedList;

public class Problem117 {
    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
    public static void main(String[] args) {

    }

    //
    //15 min
    //Runtime
    //3 ms
    //Beats
    //14.92%
    //Memory
    //42.1 MB
    //Beats
    //51.47%

    static Node connect(Node root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        goDFS(root, 0, map);
        for (List<Node> list : map.values()) {
            for (int i = 1; i < list.size(); i++) {
                list.get(i - 1).next = list.get(i);
            }
        }
        return root;
    }

    private static void goDFS(Node node, int lvl, Map<Integer, List<Node>> map) {
        if (node == null) return;

        List<Node> list = map.computeIfAbsent(lvl, ArrayList::new);
        list.add(node);
        lvl++;
        goDFS(node.left, lvl, map);
        goDFS(node.right, lvl, map);
    }
}
