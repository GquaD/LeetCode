package LeetCode.easy;

public class Problem141 {
    //https://leetcode.com/problems/linked-list-cycle/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/linked-list-cycle/solutions/2810093/java-o-1-memory-no-two-pointers-original-solution/
    //5 mins
    //Runtime
    //2 ms
    //Beats
    //50.37%
    //Memory
    //45.9 MB
    //Beats
    //47.43%
    //since constraints for value are -10^5 <= Node.val <= 10^5
    //then I use 1_000_000 as indicator that this node has been
    //visited
    static boolean hasCycle(ListNode head) {
        while (head != null) {
            if (head.val == 100_001) return true;
            head.val = 100_001;
            head = head.next;
        }
        return false;
    }
}
