package LeetCode.medium;

import java.util.Stack;

public class Problem430 {
    //https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
    public static void main(String[] args) {
        /*Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        Node n8 = new Node(8);
        Node n9 = new Node(9);

        n1.next = n2;
        n2.prev = n1;

        n2.next = n3;
        n3.prev = n2;

        n3.next = n4;
        n3.child = n5;

        n5.next = n6;
        n6.prev = n5;

        n6.next = n7;
        n6.child = n8;

        n8.next = n9;
        n9.prev = n8;

        n7.prev = n6;

        n4.prev = n3;*/

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.child = n2;
        n2.child = n3;

        Node res = flatten(n1);

        System.out.println(res);
    }

    //https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/solutions/4167668/java-o-n-100-faster-using-stack/
    //35 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.9 MB
    //Beats
    //17.90%
    static Node flatten(Node head) {
        Node temp = head, next = head;
        Stack<Node> stack = new Stack<>();
        while (temp != null) {
            if (temp.child != null) {
                if (temp.next != null) stack.push(temp.next);
                temp.next = temp.child;
                temp.child.prev = temp;
                temp.child = null;
            }
            if (temp.next == null && !stack.isEmpty()) {
                temp.next = stack.pop();
                temp.next.prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }

/*    static Node flatten1(Node head) {
        Node prev = head, temp = head;
        while (temp != null) {
            if (temp.child != null) {
                Node next = temp.next;
                temp.next = temp.child;
                Node last = returnLast(temp.next);
                last.next = next;
                temp = next;
                prev = last;
                next.prev = last;
            }
        }
        return head;
    }*/
}
