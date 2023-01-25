package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem116 {
    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/solutions/3096780/java-o-n-memory/
    //15 min
    //Runtime
    //5 ms
    //Beats
    //19.77%
    //Memory
    //47.1 MB
    //Beats
    //28.54%
    static Node connect(Node node) {
        Map<Integer, List<Node>> map = new HashMap<>();
        goDFS(0, node, map);
        for (int key : map.keySet()) {
            List<Node> list = map.get(key);
            for (int i = 1; i < list.size(); i++) {
                list.get(i - 1).next = list.get(i);
            }
        }
        return node;
    }

    private static void goDFS(int lvl, Node node, Map<Integer, List<Node>> map) {
        if (node == null) return;

        List<Node> list = map.computeIfAbsent(lvl, k -> new ArrayList<>());
        list.add(node);
        lvl++;
        goDFS(lvl, node.left, map);
        goDFS(lvl, node.right, map);
    }
}
