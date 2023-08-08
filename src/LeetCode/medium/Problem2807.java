package LeetCode.medium;


public class Problem2807 {
    //https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/solutions/3882277/java-100-faster-recursive-gcd/
    //5-10 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //43.8 MB
    //Beats
    //77.67%
    static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev = null, temp = head;
        while (temp != null) {
            if (prev != null) {
                ListNode gcd = new ListNode(gcd(prev.val, temp.val));
                prev.next = gcd;
                gcd.next = temp;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
