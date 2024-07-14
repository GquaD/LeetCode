package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem3217 {
    //https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/solutions/5475711/java-o-n-in-place-solution/
    //10min
    //Runtime
    //21
    //ms
    //Beats
    //50.00%
    //Analyze Complexity
    //Memory
    //64.59
    //MB
    //Beats
    //50.00%
    static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        while (set.contains(head.val)) head = head.next;
        if (head == null) return head;
        ListNode t = head.next, prev = head;
        while (t != null) {
            if (set.contains(t.val)) {
                prev.next = t.next;
            } else {
                prev = t;
            }
            t = t.next;
        }
        return head;
    }
}
