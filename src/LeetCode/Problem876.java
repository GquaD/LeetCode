package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Problem876 {

    //https://leetcode.com/problems/middle-of-the-linked-list/

    public static void main(String[] args) {
        //System.out.println(middleNode());
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
    //Memory Usage: 42.3 MB, less than 9.36% of Java online submissions for Middle of the Linked List.
    public static ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2);
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
