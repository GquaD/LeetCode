package LeetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem82 {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        deleteDuplicates(n1);
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/solutions/2852466/java-slowpoke-solution/
    //30-40min
    //Runtime
    //6 ms
    //Beats
    //7.10%
    //Memory
    //44.9 MB
    //Beats
    //6.32%
    static ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode curr = head, insert = head, prev = null;
        while (curr != null) {
            if (!map.containsKey(curr.val)) {
                map.put(curr.val, 1);
            } else {
                map.put(curr.val, map.get(curr.val) + 1);
            }
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (map.get(curr.val) == 1) {
                insert.val = curr.val;
                prev = insert;
                insert = insert.next;
            }
            curr = curr.next;
        }
        if (prev != null) prev.next = null;
        else return null;
        return head;
    }

    static ListNode deleteDuplicates1(ListNode head) {
        ListNode curr = head, insert = head;
        int num = curr.val, prev = 101;
        while (curr != null) {
            if (curr.val != num) {
                insert.val = num;
                insert = insert.next;
                num = curr.val;
            } else {

            }
            curr = curr.next;
        }
        insert.val = num;
        insert.next = null;
        return head;
    }
}
