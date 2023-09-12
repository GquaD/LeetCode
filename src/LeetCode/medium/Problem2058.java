package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem2058 {
    //https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(n1)));
    }

    //https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/solutions/4036085/java-o-nlogn-solution/
    //20min
    //Runtime
    //14 ms
    //Beats
    //20.48%
    //Memory
    //55.8 MB
    //Beats
    //93.73%
    static int[] nodesBetweenCriticalPoints(ListNode head) {
        int prev = 0, mid = 0, curr = 0, count = 0;
        List<Integer> listIdx = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            if (prev != 0 && mid != 0 && curr != 0) {
                if (prev > mid && mid < curr) listIdx.add(count);
                if (prev < mid && mid > curr) listIdx.add(count);
            }

            prev = mid;
            mid = curr;
            curr = temp.val;

            count++;
            temp = temp.next;
        }
        if (prev != 0 && mid != 0 && curr != 0) {
            if (prev > mid && mid < curr) listIdx.add(count);
            if (prev < mid && mid > curr) listIdx.add(count);
        }
        if (listIdx.size() < 2) return new int[]{-1, -1};
        Collections.sort(listIdx);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < listIdx.size(); i++) min = Math.min(listIdx.get(i) - listIdx.get(i - 1), min);
        return new int[]{min, listIdx.get(listIdx.size() - 1) - listIdx.get(0)};
    }
}
