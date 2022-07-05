package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Problem589 {
    //https://leetcode.com/problems/n-ary-tree-preorder-traversal/
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        List<Node> level1 = new ArrayList<>();
        level1.add(node2);
        level1.add(node3);
        level1.add(node4);
        root.children = level1;
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> level2 = new ArrayList<>();
        level2.add(node5);
        level2.add(node6);
        node2.children = level2;

        List<Integer> list = preorder(root);
        for (Integer num : list) {
            System.out.print(num + " ");
        }
    }

    //Runtime: 1 ms, faster than 89.94% of Java online submissions for N-ary Tree Preorder Traversal.
    //Memory Usage: 45.7 MB, less than 74.76% of Java online submissions for N-ary Tree Preorder Traversal.
    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(root, result);
        return result;
    }

    static void preOrderTraversal(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);

        if (root.children == null || root.children.isEmpty()) {
            return;
        }

        for (Node child : root.children) {
            preOrderTraversal(child, list);
        }
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
