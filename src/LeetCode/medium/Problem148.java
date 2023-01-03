package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem148 {
    //https://leetcode.com/problems/sort-list/
    public static void main(String[] args) {

    }

    //Runtime
    //39 ms
    //Beats
    //15.4%
    //Memory
    //74.6 MB
    //Beats
    //57.56%
    static ListNode sortList(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        head = new ListNode(list.get(0));
        ListNode resHead = head;
        for (int i = 1; i < list.size(); i++) {
            ListNode n = new ListNode(list.get(i));
            head.next = n;
            head = head.next;
        }
        return resHead;
    }

    static ListNode sortList2(ListNode head) {
        if (head == null) return null;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        Collections.sort(list, Comparator.comparing(n -> n.val));
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).next = list.get(i);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }

    //TLE on 26/30
    static ListNode sortList1(ListNode head) {
        int count = 1;
        ListNode dummyHead = head;
        while (count != 0) {
            count = 0;
            while (head != null) {
                if (head.next != null && head.next.val > head.val) {
                    int temp = head.val;
                    head.val = head.next.val;
                    head.next.val = temp;
                    count++;
                }
                head = head.next;
            }
            head = dummyHead;
        }
        return dummyHead;
    }
}
