package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem142 {
    //medium
    //https://leetcode.com/problems/linked-list-cycle-ii/
    public static void main(String[] args) {

    }

    //Runtime: 6 ms, faster than 15.45% of Java online submissions for Linked List Cycle II.
    //Memory Usage: 47.6 MB, less than 6.55% of Java online submissions for Linked List Cycle II.
    public static ListNode detectCycle(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        while (true) {
            if (head == null) {
                return null;
            }
            if (map.containsKey(head.hashCode())) {
                return head;
            }
            map.put(head.hashCode(), head);
            head = head.next;
        }
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
