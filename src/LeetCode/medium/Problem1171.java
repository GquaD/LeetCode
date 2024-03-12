package LeetCode.medium;


import java.util.HashMap;
import java.util.Map;

public class Problem1171 {
    //https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(-3);
        ListNode n5 = new ListNode(-2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode res = removeZeroSumSublists(n1);
        System.out.println(res.val);
    }

    //nnn
    //Runtime
    //3
    //ms
    //Beats
    //54.35%
    //of users with Java
    //Memory
    //43.70
    //MB
    //Beats
    //73.91%
    //of users with Java
    static ListNode removeZeroSumSublists(ListNode head) {
        ListNode res = new ListNode(0), temp = res;
        res.next = head;
        int sum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (temp != null) {
            sum += temp.val;
            if (map.containsKey(sum)) {
                temp = map.get(sum).next;
                int s = sum + temp.val;
                while (s != sum) {
                    map.remove(s);
                    temp = temp.next;
                    s += temp.val;
                }
                map.get(sum).next = temp.next;
            } else {
                map.put(sum, temp);
            }
            temp = temp.next;
        }
        return res.next;
    }
}
