package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem1290 {
    //https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
    public static void main(String[] args) {

    }

    //Runtime: 1 ms, faster than 36.96% of Java online submissions for Convert Binary Number in a Linked List to Integer.
    //Memory Usage: 41.6 MB, less than 57.52% of Java online submissions for Convert Binary Number in a Linked List to Integer.
    static int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int pow = 0;
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i) * (int) Math.pow(2, pow++);
        }
        return sum;
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
