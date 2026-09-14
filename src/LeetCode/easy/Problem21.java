package LeetCode.easy;

public class Problem21 {
    //solution for https://leetcode.com/problems/merge-two-sorted-lists/
    public static void main(String[] args) {

    }

    //15min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //44.45
    //MB
    //Beats
    //19.87%
    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        ListNode head, temp;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
            head.next = null;
        } else {
            head = list2;
            list2 = list2.next;
            head.next = null;
        }

        temp = head;

        while (!(list1 == null || list2 == null)) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
            temp.next = null;
        }

        temp.next = list1 == null ? list2 : list1;

        return head;
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
