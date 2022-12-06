package LeetCode.medium;

public class Problem328 {
    //https://leetcode.com/problems/odd-even-linked-list/
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        oddEvenList(l1);
        System.out.println();
    }

    //https://leetcode.com/problems/odd-even-linked-list/solutions/2882510/java-o-1-memory-o-n-time-solution/
    //10-15 min
    //Runtime
    //1 ms
    //Beats
    //66.18%
    //Memory
    //44.8 MB
    //Beats
    //33.48%
    static ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        if (head.next.next == null) return head;
        ListNode oddHead = head, evenHead = head.next;
        ListNode oddCurrent = oddHead, evenCurrent = evenHead;
        while (oddCurrent != null) {
            ListNode tempEven = oddCurrent.next;
            if (oddCurrent.next != null) {
                oddCurrent.next = oddCurrent.next.next;
            }

            evenCurrent.next = tempEven;
            evenCurrent = evenCurrent.next;
            if (oddCurrent.next == null) break;
            oddCurrent = oddCurrent.next;
        }
        oddCurrent.next = evenHead;
        return oddHead;
    }
}
