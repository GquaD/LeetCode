package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem83 {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public static void main(String[] args) {

    }

    //Runtime
    //3 ms
    //Beats
    //5.9%
    //Memory
    //44.5 MB
    //Beats
    //24.33%

    static ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode prev = head, curr = head;
        while (curr != null) {
            if (!set.add(curr.val)) {
                curr = curr.next;
                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
