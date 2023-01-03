package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.math.BigInteger;

public class Problem445 {
    //https://leetcode.com/problems/add-two-numbers-ii/description/
    public static void main(String[] args) {
        ListNode l1 = LeetCodeUtils.generateList(new int[]{7,2,4,3});
        ListNode l2 = LeetCodeUtils.generateList(new int[]{5,6,4});
        System.out.println(addTwoNumbers(l1, l2));
    }

    //I could omit using biginteger and use stringbuilder instead
    //Runtime
    //7 ms
    //Beats
    //36.79%
    //Memory
    //42.8 MB
    //Beats
    //69%
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger one = BigInteger.ZERO, ten = BigInteger.valueOf(10);
        while (l1 != null) {
            one = one.add(BigInteger.valueOf(l1.val));
            l1 = l1.next;
            if (l1 != null) one = one.multiply(ten);
        }
        BigInteger two = BigInteger.ZERO;
        while (l2 != null) {
            two = two.add(BigInteger.valueOf(l2.val));
            l2 = l2.next;
            if (l2 != null) two = two.multiply(ten);
        }
        one = one.add(two);
        String res = one.toString();
        ListNode head = new ListNode(res.charAt(0) - '0'), t = head;
        for (int i = 1; i < res.length(); i++) {
            t.next = new ListNode(res.charAt(i) - '0');
            t = t.next;
        }
        return head;
    }
}
