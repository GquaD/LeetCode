package LeetCode;

import LeetCode.Recursion.SwapNodes;

public class Problem237 {
    //https://leetcode.com/problems/delete-node-in-a-linked-list/
    public static void main(String[] args) {

    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
    //Memory Usage: 44.4 MB, less than 13.54% of Java online submissions for Delete Node in a Linked List.
    static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
}
