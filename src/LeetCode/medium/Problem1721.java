package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1721 {
    //https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        swapNodes1(l1, 1);
        System.out.println(l1.val + "->" + l2.val + "->" + l3.val + "->" + l4.val + "->" + l5.val);
        ListNode l6 = new ListNode(100);
        ListNode l7 = new ListNode(90);
        l6.next = l7;
        swapNodes1(l6, 2);
        System.out.println(l6.val + "->" + l7.val);
    }

    //Runtime: 4 ms, faster than 60.83% of Java online submissions for Swapping Nodes in a Linked List.
    //Memory Usage: 169.7 MB, less than 73.47% of Java online submissions for Swapping Nodes in a Linked List.
    static ListNode swapNodes(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        ListNode left = head;
        while (current != null) {
            if (++count == k) {
                left = current;
            }
            current = current.next;
        }
        current = head;
        int count2 = 0;
        int check = count - k + 1;
        while (current != null) {
            if (++count2 == check) {
                break;
            }
            current = current.next;
        }
        swap(left, current);
        return head;
    }

    //Runtime: 17 ms, faster than 10.49% of Java online submissions for Swapping Nodes in a Linked List.
    //Memory Usage: 183.9 MB, less than 24.03% of Java online submissions for Swapping Nodes in a Linked List.
    static ListNode swapNodes1(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }
        k -= 1;
        ListNode left = list.get(k);
        ListNode right = list.get(list.size() - 1 - k);
        //swap
        swap(left, right);

        return head;
    }

    private static void swap(ListNode left, ListNode right) {
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
    }
}
