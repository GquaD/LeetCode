package LeetCode.medium;

public class Problem2 {
    //https://leetcode.com/problems/add-two-numbers/
    public static void main(String[] args) {

    }
    //https://leetcode.com/problems/add-two-numbers/discuss/2596686/Java-Messy-solution-or-84-faster
    //30 mins
    //Runtime: 3 ms, faster than 81.14% of Java online submissions for Add Two Numbers.
    //Memory Usage: 47.7 MB, less than 56.04% of Java online submissions for Add Two Numbers.
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode last;
        int sum = 0;
        while (node1.next != null && node2.next != null) {
            sum += node1.val + node2.val;
            node1.val = sum % 10;
            node2.val = sum % 10;
            sum = sum / 10;
            node1 = node1.next;
            node2 = node2.next;
        }
        sum += node1.val + node2.val;
        node1.val = sum % 10;
        node2.val = sum % 10;
        sum = sum / 10;
        last = node2;
        node1 = node1.next;
        node2 = node2.next;
        if (node1 != null) {
            boolean isL1 = false;
            while (node1.next != null) {
                isL1 = true;
                sum += node1.val;
                node1.val = sum % 10;
                sum = sum / 10;
                node1 = node1.next;
            }
            isL1 = true;
            sum += node1.val;
            node1.val = sum % 10;
            sum = sum / 10;
            last = node1;
            if (isL1) {
                if (sum > 0) {
                    ListNode node = new ListNode(sum);
                    node1.next = node;
                }
                return l1;
            }
        }
        if (node2 != null) {
            while (node2.next != null) {
                sum += node2.val;
                node2.val = sum % 10;
                sum = sum / 10;
                node2 = node2.next;
            }
            sum += node2.val;
            node2.val = sum % 10;
            sum = sum / 10;
            last = node2;
            if (sum > 0) {
                ListNode node = new ListNode(sum);
                node2.next = node;
            }
            return l2;
        }
        if (sum != 0) {
            ListNode node = new ListNode(sum);
            last.next = node;
        }
        return l2;
    }
}
