package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem2487 {
    //https://leetcode.com/problems/remove-nodes-from-linked-list/
    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(13);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        removeNodes(n1);
    }

    //https://leetcode.com/problems/remove-nodes-from-linked-list/solutions/2910255/java-o-n-93-faster-solution/
    //Runtime
    //12 ms
    //Beats
    //92.79%
    //Memory
    //60.2 MB
    //Beats
    //96.87%
    static ListNode removeNodes(ListNode head) {
        ListNode cur = head;
        List<ListNode> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int max = 0;
        int[] arr = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            if (max <= list.get(i).val) {
                arr[i] = 1;
                max = list.get(i).val;
            }
        }
        boolean headSet = false;
        cur = head;
        for (int i = 0; i < list.size(); i++) {
            if (arr[i] == 1) {
                if (!headSet) {
                    headSet = true;
                    head = list.get(i);
                    cur = head;
                } else {
                    cur.next = list.get(i);
                    cur = cur.next;
                }
            }
        }
        cur.next = null;
        return head;
    }

    static ListNode removeNodes1(ListNode head) {
        ListNode current = head, headNew = null, prevNew = head;
        while (current != null) {
            if (current.next != null) {
                if (current.val >  current.next.val) {
                    if (headNew == null) {
                        headNew = current.next;
                        prevNew = headNew;
                    } else {
                        prevNew.next = current.next;
                        prevNew = prevNew.next;
                    }
                }
            }
            current = current.next;
        }
        if (headNew == null) return head;
        prevNew.next = null;
        return headNew;
    }
}
