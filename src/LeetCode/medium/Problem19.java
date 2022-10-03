package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem19 {
    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/solutions/2653594/java-o-n-solution/
    //20 mins
    //1 ms
    //Beats
    //78.71%
    //Memory
    //42 MB
    //Beats
    //71.9%
    static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        while(head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.size() == 1) return null;
        if (list.size() == 2) {
            if (n == 1) {
                list.get(0).next = null;
                return list.get(0);
            } else {
                return list.get(1);
            }
        }
        if (n == list.size()) {
            return list.get(1);
        }
        list.get(list.size() - n - 1).next = list.size() - n + 1 >= list.size() ? null : list.get(list.size() - n + 1);
        return list.get(0);
    }
}
