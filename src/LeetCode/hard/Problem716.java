package LeetCode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Problem716 {


}
//1h
//Runtime
//67
//ms
//Beats
//45.08%
//Memory
//107.29
//MB
//Beats
//50.62%
//https://leetcode.com/problems/max-stack/solutions/8559556/java-doublylinkedlist-implemented-by-tbe-e94h/
class MaxStack {
    DoublyLinkedList list;
    TreeMap<Integer, List<ListNode>> map;

    public MaxStack() {
        list = new DoublyLinkedList();
        map = new TreeMap<>();
    }

    public void push(int x) {
        List<ListNode> idxs = map.get(x);
        if (idxs == null) {
            idxs = new ArrayList<>();
            map.put(x, idxs);
        }
        idxs.add(list.add(x));
    }

    public int pop() {
        int top = list.removeLast().val;

        List<ListNode> idxs = map.get(top);
        if (idxs.size() == 1) {
            map.remove(top);
        } else {
            idxs.remove(idxs.size() - 1);
        }

        return top;
    }

    public int top() {
        return list.last.val;
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        Integer key = map.lastKey();
        List<ListNode> idxs = map.get(key);

        ListNode idx = idxs.get(idxs.size() - 1);
        if (idxs.size() == 1) {
            map.remove(key);
        } else {
            idxs.remove(idxs.size() - 1);
        }

        list.remove(idx);

        return key;
    }
}

class DoublyLinkedList {
    ListNode first, last;

    public ListNode add(int n) {
        ListNode node = new ListNode(n);
        if (first == null) {
            first = node;
        }

        if (last == null) {
            last = node;
        } else {
            node.prev = last;
            last.next = node;
            last = last.next;
        }
        return node;
    }

    public ListNode removeLast() {
        ListNode result = last;

        if (first == last) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }

        return result;
    }

    public void remove(ListNode node) {
        if (first == node && last == node) {
            first = null;
            last = null;
        } else if (first == node) {
            first = first.next;
            if (first != null) first.prev = null;
        } else if (last == node) {
            removeLast();
        } else {
            ListNode prev = node.prev, next = node.next;
            if (prev != null) prev.next = next;
            if (next != null) next.prev = prev;
        }
    }
}

class ListNode {
    ListNode prev, next;
    int val;

    public ListNode(int v) {
        val = v;
    }
}
