package LeetCode.medium;

public class LinkedList1<I extends Number> {
    Node first;

    public Node delete(int val) {
        Node current = first;
        Node previous = first;
        while (current.data != val) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    public void insertFirst(int val) {

    }

    public int deleteFirst() {
        Node temp = first;
        first = first.next;
        return temp.data;
    }

    public int getFirst(){
        return first.data;
    }
}
