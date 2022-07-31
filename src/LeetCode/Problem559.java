package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem559 {
    //https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
    public static void main(String[] args) {
        Node root = new Node(1);
        Node nodeA2 = new Node(2);
        Node nodeA3 = new Node(3);
        Node nodeA4 = new Node(4);
        Node nodeA5 = new Node(5);
        List<Node> a1 = new ArrayList<>();
        a1.add(nodeA2);
        a1.add(nodeA3);
        a1.add(nodeA4);
        a1.add(nodeA5);
        root.children = a1;

        Node nodeB5 = new Node(6);
        Node nodeB6 = new Node(7);
        List<Node> b1 = new ArrayList<>();
        b1.add(nodeB5);
        b1.add(nodeB6);
        nodeA3.children = b1;

        Node nodeB8 = new Node(8);
        List<Node> b2 = new ArrayList<>();
        b2.add(nodeB8);
        nodeA4.children = b2;



        System.out.println(maxDepth(root));
    }

    //Runtime: 3 ms, faster than 23.36% of Java online submissions for Maximum Depth of N-ary Tree.
    //Memory Usage: 43.8 MB, less than 69.48% of Java online submissions for Maximum Depth of N-ary Tree.
    static int maxDepth(Node root) {
        depth = 0;
        set = new HashSet<>();
        recursiveTraverseNaryTree(root);
        int max = 0;
        for (Integer i : set) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    static int depth;
    static Set<Integer> set;

    private static void recursiveTraverseNaryTree(Node root) {
        if (root == null) return;
        set.add(++depth);
        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                recursiveTraverseNaryTree(root.children.get(i));
                depth--;
            }
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
