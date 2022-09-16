package LeetCode.easy;

public class Problem21 {
    //solution for https://leetcode.com/problems/merge-two-sorted-lists/
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result;
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null || list2 == null) {
            if (list1 == null) {
                result = list2;
                list2 = list2.next;
            } else {
                result = list1;
                list1 = list1.next;
            }
        } else {
            if (list1.val > list2.val) {
                result = list2;
                list2 = list2.next;
            } else {
                result = list1;
                list1 = list1.next;
            }
        }
        mergeAction(list1, list2, result);
        return result;
    }

    static void mergeAction(ListNode list1, ListNode list2, ListNode result) {
        if (list1 == null && list2 == null) {
            return;
        }
        if (list1 == null || list2 == null) {
            if (list1 == null) { 
                result.next = list2;
                list2 = list2.next;
            } else {
                result.next = list1;
                list1 = list1.next;
            }
        } else {
            if (list1.val > list2.val) {
                result.next = list2;
                list2 = list2.next;
            } else {
                result.next = list1;
                list1 = list1.next;
            }
        }
        mergeAction(list1, list2, result.next);
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
