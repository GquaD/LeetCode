package LeetCode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem92 {
    //https://leetcode.com/problems/reverse-linked-list-ii/
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(reverseBetween(n1, 2, 4));
    }

    //https://leetcode.com/problems/reverse-linked-list-ii/solutions/2916830/java-100-faster-0ms-solution/
    //10-15min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.3 MB
    //Beats
    //81.10%
    static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        List<Integer> list = new LinkedList<>();
        goRecursively(head, list, left, right, 0);
        return head;
    }

    private static void goRecursively(ListNode node, List<Integer> list, int left, int right, int cur) {
        if (node == null) return;
        cur++;
        if (cur >= left && cur <= right) {
            list.add(node.val);
        }
        if (cur > right) {
            return;
        }

        goRecursively(node.next, list, left, right, cur);
        if (cur >= left && cur <= right) {
            node.val = list.get(0);
            list.remove(0);
        }
    }
}
