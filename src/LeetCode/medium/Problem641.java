package LeetCode.medium;

import java.util.LinkedList;

public class Problem641 {
    //https://leetcode.com/problems/design-circular-deque/

}


//30 min
//Runtime
//5 ms
//Beats
//73.81%
//Memory
//43.2 MB
//Beats
//37.1%

class MyCircularDeque {
    LinkedList<Integer> list;
    int size;
    public MyCircularDeque(int k) {
        size = k;
        list = new LinkedList<>();
    }

    public boolean insertFront(int value) {
        if (list.size() < size) {
            list.addFirst(value);
            return true;
        } else return false;
    }

    public boolean insertLast(int value) {
        if (list.size() < size) {
            list.addLast(value);
            return true;
        } else return false;
    }

    public boolean deleteFront() {
        if (list.isEmpty()) {
            return false;
        } else {
            list.removeFirst();
            return true;
        }
    }

    public boolean deleteLast() {
        if (list.isEmpty()) {
            return false;
        } else {
            list.removeLast();
            return true;
        }
    }

    public int getFront() {
        if (list.isEmpty()) return -1;
        return list.getFirst();
    }

    public int getRear() {
        if (list.isEmpty()) return -1;
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() == size;
    }
}

class MyCircularDeque1 {

    Node front, last;
    int size, count;

    public MyCircularDeque1(int k) {
        size = k;
        count = 0;
    }

    public boolean insertFront(int value) {
        if (front == null) {
            front = new Node(value);
            last = front;
            count++;
            return true;
        } else if (count == size) {
            return false;
        } else {
            Node temp = front;
            front = new Node(value);
            front.next = temp;
            count++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (last == null) {
            last = new Node(value);
            front = last;
            count++;
            return true;
        } else if (count == size) {
            return false;
        } else {
            Node temp = last;
            last = new Node(value);
            last.next = temp;
            count++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (count == 0) return false;
        if (count == 1) {
            front = null;
            last = null;
            count = 0;
            return true;
        } else {
            front = front.next;
            count--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (count == 0) return false;
        if (count == 1) {
            last = null;
            front = null;
            count = 0;
            return true;
        } else {
            if (last != null) {
                last = last.next;
                count--;
                return true;
            } else {
                Node temp = front, prev = front;
                while (temp.next != null) {
                    prev = temp;
                    temp = temp.next;
                }
                prev.next = null;
                count--;
                return true;
            }
        }
    }

    public int getFront() {
        if (front == null) return -1;
        else return front.val;
    }

    public int getRear() {
        if (last == null) return -1;
        else return last.val;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
