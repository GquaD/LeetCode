package LeetCode.medium;

public class Problem1669 {
    //https://leetcode.com/problems/merge-in-between-linked-lists/submissions/
    public static void main(String[] args) {

    }

    //Runtime: 3 ms, faster than 32.98% of Java online submissions for Merge In Between Linked Lists.
    //Memory Usage: 108.7 MB, less than 21.08% of Java online submissions for Merge In Between Linked Lists.
    static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode firstL2 = list2;
        ListNode lastL2 = list2;
        while (list2 != null) {
            lastL2 = list2;
            list2 = list2.next;
        }

        ListNode aMinus1L1 = list1;
        ListNode bPlus1L1 = list1;
        ListNode temp = list1;
        int count = 0;
        while(list1 != null) {
            if (count == a - 1) {
                aMinus1L1 = list1;
            }
            if (count == b + 1) {
                bPlus1L1 = list1;
                break;
            }
            list1 = list1.next;
            count++;
        }

        aMinus1L1.next = firstL2;
        lastL2.next = bPlus1L1;
        return temp;
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
