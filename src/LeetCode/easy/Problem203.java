package LeetCode.easy;

public class Problem203 {
    //https://leetcode.com/problems/remove-linked-list-elements/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/remove-linked-list-elements/solutions/2802541/java-o-n-solution/
    //15-20mins
    //Runtime
    //2 ms
    //Beats
    //57.50%
    //Memory
    //48.5 MB
    //Beats
    //76.68%
    static ListNode removeElements(ListNode head, int val) {
        //check for first node' val == val
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode temp = head;
        while (head != null) {
            if (head.next != null && head.next.val == val) {
                head.next = head.next.next;
                continue;
            }
            head = head.next;
        }
        return temp;
    }
}
