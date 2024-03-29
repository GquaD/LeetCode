package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem426 {
    //https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/solutions/4942101/java-o-n-100-faster-solution/
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //41.64
    //MB
    //Beats
    //78.55%
    //of users with Java
    static Node treeToDoublyList(Node root) {
        if (root == null) return root;
        List<Node> list = new ArrayList<>();
        goDFS(root, list);
        for (int i = 1; i < list.size(); i++) {
            Node prev = list.get(i - 1), cur = list.get(i);
            prev.right = cur;
            cur.left = prev;
        }

        Node first = list.get(0), last = list.get(list.size() - 1);
        last.right = first;
        first.left = last;

        return first;
    }

    private static void goDFS(Node node, List<Node> list) {
        if (node == null) return;

        goDFS(node.left, list);
        list.add(node);
        goDFS(node.right, list);
    }
}
