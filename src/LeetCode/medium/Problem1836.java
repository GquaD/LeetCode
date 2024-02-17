package LeetCode.medium;
import java.util.*;

public class Problem1836 {
    //https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/solutions/4741990/java-o-n-using-hashbrown/
    //10 min
    //Runtime
    //67
    //ms
    //Beats
    //91.32%
    //of users with Java
    //Memory
    //64.76
    //MB
    //Beats
    //33.06%
    //of users with Java
    static ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode t = head, prev = null;
        while (t != null) {
            map.put(t.val, map.getOrDefault(t.val, 0) + 1);
            t = t.next;
        }
        t = head;
        while (head != null && map.get(head.val) > 1) head = head.next;
        t = head;
        while (t != null && t.next != null) {
            int freq = map.get(t.next.val);
            if (freq > 1) {
                if (t.next.next == null) {
                    t.next = null;
                } else {
                    t.next = t.next.next;
                }
            } else {
                t = t.next;
            }
        }
        return head;
    }
}
