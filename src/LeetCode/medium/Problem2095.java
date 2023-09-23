package LeetCode.medium;

public class Problem2095 {
    //https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //4 ms
    //Beats
    //21.68%
    //Memory
    //63.2 MB
    //Beats
    //95.40%
    static ListNode deleteMiddle(ListNode head) {
        int len = 0, count = 0;
        ListNode temp = head, prev = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        temp = head;
        if (len == 1) return null;
        while (temp != null) {
            if (count++ == len / 2) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
