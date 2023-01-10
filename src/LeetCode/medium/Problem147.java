package LeetCode.medium;

import LeetCode.LeetCodeUtils;

public class Problem147 {
    //https://leetcode.com/problems/insertion-sort-list/
    public static void main(String[] args) {
        /*ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n4.next = n2;
        n2.next = n1;
        n1.next = n3;
        *//*ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n5;
        n5.next = n3;
        n3.next = n4;
        n4.next = n2;*//*
        ListNode res = insertionSortList(n4);
        System.out.println(res.val);*/

        ListNode head = LeetCodeUtils.generateList(new int[]{4,19,14,5,-3,1,8,5,11,15});
        ListNode res1 = insertionSortList(head);

        ListNode head1 = LeetCodeUtils.generateList(new int[]{-1,5,3,4,0});
        res1 = insertionSortList(head1);

        ListNode head2 = LeetCodeUtils.generateList(new int[]{4,2,1,3});
        res1 = insertionSortList(head2);

        System.out.println(res1);
    }

    //https://leetcode.com/problems/insertion-sort-list/solutions/3029672/java-o-1-memory-solution/
    //1-2 hours
    //Runtime
    //3 ms
    //Beats
    //94.99%
    //Memory
    //42.2 MB
    //Beats
    //61%
    static ListNode insertionSortList(ListNode head) {
        if (head.next == null) return head;
        ListNode headNew = head, tempOuter = head.next, lastInner = headNew, prevOuter = head;
        while (tempOuter != null) {
            ListNode tempOuterCopy = tempOuter;
            tempOuter = tempOuter.next;
            if (lastInner.val > tempOuterCopy.val) {
                if (tempOuterCopy.val < headNew.val) {
                    if (headNew.next != null && headNew.next.equals(tempOuterCopy)) {
                        headNew.next = null;
                    }
                    tempOuterCopy.next = headNew;
                    headNew = tempOuterCopy;
                } else {
                    ListNode fromHead = headNew, prevInner = headNew;
                    while (fromHead != null) {
                        if (tempOuterCopy.val < fromHead.val) {
                            prevInner.next = tempOuterCopy;
                            tempOuterCopy.next = fromHead;
                            if (fromHead.next != null && fromHead.next.equals(tempOuterCopy)) fromHead.next = null;
                            break;
                        }
                        prevInner = fromHead;
                        fromHead = fromHead.next;
                    }
                }
            } else {
                tempOuterCopy.next = null;
                lastInner.next = tempOuterCopy;
                lastInner = lastInner.next;
            }
        }
        return headNew;
    }

    static ListNode insertionSortList1(ListNode head) {
        if (head.next == null) return head;
        ListNode headNew = head, temp = head;
        while (temp != null) {
            ListNode t = head, minNode = head, prev = head;
            int min = 5001;
            while (t != null) {
                if (min > t.val) {
                    min = t.val;
                    minNode = t;
                }
                prev = t;
                t = t.next;
            }
            temp = temp.next;
        }
        return headNew;
    }
}
