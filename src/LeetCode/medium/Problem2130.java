package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem2130 {
    //https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
    public static void main(String[] args) {

    }

    //Runtime: 18 ms, faster than 43.07% of Java online submissions for Maximum Twin Sum of a Linked List.
    //Memory Usage: 120.7 MB, less than 35.44% of Java online submissions for Maximum Twin Sum of a Linked List.
    static int pairSum(ListNode head) {
        //then try with known size
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int max = 0, sizeHalf = (int) Math.ceil(list.size() / 2);
        for (int i = 0; i < sizeHalf; i++) {
            int sum = list.get(i).val + list.get(list.size() - 1 - i).val;
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
