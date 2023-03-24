package LeetCode.medium;

public class Problem707 {
    //https://leetcode.com/problems/design-linked-list/description/
    public static void main(String[] args) {

    }
}
//https://leetcode.com/problems/design-linked-list/solutions/3334346/java-singly-linked-list/
//30 min
//Runtime
//12 ms
//Beats
//12.55%
//Memory
//42.9 MB
//Beats
//60.45%
class MyLinkedList {

    Node head;
    int size;
    public MyLinkedList() {
        size = 0;
        head = null;
    }

    public int get(int index) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (count == index) return temp.val;
            count++;
            temp = temp.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node exHead = head;
        Node newHead = new Node(val);
        newHead.next = exHead;
        head = newHead;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.next == null) {
                temp.next = new Node(val);
                break;
            }
            temp = temp.next;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) addAtHead(val);
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (count == index - 1) {
                Node node = new Node(val);
                Node next = temp.next;
                temp.next = node;
                node.next = next;
            }
            count++;
            temp = temp.next;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (head != null) {
                head = head.next;
            }
        } else {
            int count = 1;
            Node temp = head.next, prev = head;
            while (temp != null) {
                if (count == index) {
                    prev.next = temp.next;
                }
                count++;
                prev = temp;
                temp = temp.next;
            }
        }
    }

    class Node {
        int val;
        Node next, prev;

        public Node(int val) {
            this.val = val;
        }
    }
}
