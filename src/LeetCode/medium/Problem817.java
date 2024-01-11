package LeetCode.medium;
import java.util.*;

public class Problem817 {
    //https://leetcode.com/problems/linked-list-components/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/linked-list-components/solutions/4546923/java-o-n/
    //10min
    //Runtime
    //6
    //ms
    //Beats
    //86.33%
    //of users with Java
    //Memory
    //44.74
    //MB
    //Beats
    //56.71%
    //of users with Java
    static int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        boolean prev = false;
        int count = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!prev) {
                    count++;
                }
                prev = true;
            } else {
                prev = false;
            }
            head = head.next;
        }
        return count;
    }
}
