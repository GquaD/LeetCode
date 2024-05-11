package LeetCode.medium;

import java.util.Stack;

public class Problem2046 {
    //https://leetcode.com/problems/sort-linked-list-already-sorted-using-absolute-values
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/sort-linked-list-already-sorted-using-absolute-values/solutions/5143022/java-o-n-solution-using-stack/
    //15-20min
    //Runtime
    //11
    //ms
    //Beats
    //16.67%
    //of users with Java
    //Memory
    //59.50
    //MB
    //Beats
    //96.43%
    //of users with Java
    ListNode sortLinkedList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode t = head, prev = null;

        while (t != null) {
            if (t.val < 0) {
                stack.add(t);
                if (prev != null) {
                    prev.next = t.next;
                    t = t.next;
                    continue;
                } else {
                    head = head.next;
                    t = t.next;
                    continue;
                }
            }
            prev = t;
            t = t.next;
        }
        ListNode headNew = head;
        if (stack.size() > 0) {
            headNew = stack.pop();
        }

        ListNode temp = headNew;

        while (stack.size() > 0) {
            temp.next = stack.pop();
            if (stack.size() == 0) {
                temp.next.next = null;
            }
            temp = temp.next;
        }

        if (head != null && temp.val != head.val)
            temp.next = head;

        return headNew;
    }
}
