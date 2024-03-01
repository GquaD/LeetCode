package LeetCode.medium;
import java.util.*;

public class Problem3063 {
    //https://leetcode.com/problems/linked-list-frequency/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/linked-list-frequency/solutions/4805285/java-o-n-hashmap-100-faster-solution/
    //5min
    //Runtime
    //33
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //57.70
    //MB
    //Beats
    //100.00%
    //of users with Java
    static ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        while (head != null) {
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }
        ListNode prev = null, h = null;
        for (int k : map.keySet()) {
            int v = map.get(k);
            if (prev == null) {
                h = new ListNode(v);
                prev = h;
            } else {
                prev.next = new ListNode(v);
                prev = prev.next;
            }
        }
        return h;
    }
}
