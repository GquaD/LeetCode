package LeetCode.medium;

public class Problem86 {
    //https://leetcode.com/problems/partition-list/
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        System.out.println(partition(n1, 0).val);
    }

    //https://leetcode.com/problems/partition-list/solutions/2974188/java-100-faster-solution-o-n/
    //15-20 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.2 MB
    //Beats
    //61.35%

    static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode lessCurr = null, xCurr = null, current = head;
        ListNode lessHead = null, xHead = null;
        while (current != null) {
            if (current.val < x) {
                if (lessCurr == null) {
                    lessCurr = current;
                    lessHead = lessCurr;
                }
                else {
                    lessCurr.next = current;
                    lessCurr = lessCurr.next;
                }
            } else {
                if (xCurr == null) {
                    xCurr = current;
                    xHead = xCurr;
                }
                else {
                    xCurr.next = current;
                    xCurr = xCurr.next;
                }
            }
            if (current.next == null) break;;
            current = current.next;
        }
        if (xCurr != null) xCurr.next = null;
        if (lessCurr != null) lessCurr.next = xHead;
        return lessHead != null ? lessHead : xHead;
    }
}
