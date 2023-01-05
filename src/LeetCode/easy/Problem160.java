package LeetCode.easy;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Problem160 {
    //https://leetcode.com/problems/intersection-of-two-linked-lists/
    public static void main(String[] args) {

    }

    //Runtime
    //19 ms
    //Beats
    //13.78%
    //Memory
    //55 MB
    //Beats
    //50.22%
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        while (headA != null) {
            headA.val = 0;
            headA = headA.next;
        }

        while (headB != null) {
            if (headB.val == 0) return headB;
            headB = headB.next;
        }
        return null;
    }
}
