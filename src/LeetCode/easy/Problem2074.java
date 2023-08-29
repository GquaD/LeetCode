package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem2074 {
    //https://leetcode.com/problems/reverse-nodes-in-even-length-groups/
    public static void main(String[] args) {
//        ListNode n1 = new ListNode(5);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(6);
//        ListNode n4 = new ListNode(3);
//        ListNode n5 = new ListNode(9);
//        ListNode n6 = new ListNode(1);
//        ListNode n7 = new ListNode(7);
//        ListNode n8 = new ListNode(3);
//        ListNode n9 = new ListNode(8);
//        ListNode n10 = new ListNode(4);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
//        n7.next = n8;
//        n8.next = n9;
//        n9.next = n10;
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        reverseEvenLengthGroups(n1);
    }

    //https://leetcode.com/problems/reverse-nodes-in-even-length-groups/solutions/3976647/java-o-n-solution/
    //20-25 min
    //Runtime
    //20 ms
    //Beats
    //26.69%
    //Memory
    //63.5 MB
    //Beats
    //83.74%
    static ListNode reverseEvenLengthGroups(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int idx = 0, count = 0;
        while (idx < list.size()) {
            if ((Math.min(idx + count, list.size() - 1) - idx) % 2 == 1)
                reverse(list, idx, Math.min(idx + count, list.size() - 1));
            idx += count + 1;
            count++;
        }
        temp = head;
        count = 0;
        while (temp != null) {
            temp.val = list.get(count++);
            temp = temp.next;
        }
        return head;
    }

    private static void reverse(List<Integer> list, int l, int r) {
        for (int i = l, k = 0; i <= (r + l) / 2; i++) {
            int t = list.get(r - k);
            list.set(r - k++, list.get(i));
            list.set(i, t);
        }
    }
}
