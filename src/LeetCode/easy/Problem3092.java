package LeetCode.easy;

public class Problem3092 {
    //https://leetcode.com/problems/winner-of-the-linked-list-game/
    public static void main(String[] args) {

    }

    //2min
    //Runtime
    //1
    //ms
    //Beats
    //73.22%
    //of users with Java
    //Memory
    //44.05
    //MB
    //Beats
    //56.91%
    //of users with Java
    static String gameResult(ListNode head) {
        int even = 0, odd = 0;
        while (head != null && head.next != null) {
            if (head.val > head.next.val) {
                even++;
            } else if (head.val < head.next.val) {
                odd++;
            }
            head = head.next.next;
        }
        if (even == odd) return "Tie";
        return even > odd ? "Even" : "Odd";
    }
}
