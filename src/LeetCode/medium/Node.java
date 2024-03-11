package LeetCode.medium;

import java.util.List;

public class Node {
    int val;
    int data;
    Node next;
    Node random;
    Node right;
    Node left;
    Node prev;
    Node child;

    List<Node> children;

    Node parent;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
        this.right = null;
        this.left = null;
        this.prev = null;
        this.child = null;
        this.parent = null;
    }
}
