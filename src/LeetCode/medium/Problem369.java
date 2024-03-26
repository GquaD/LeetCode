package LeetCode.medium;

public class Problem369 {
    //https://leetcode.com/problems/plus-one-linked-list/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/plus-one-linked-list/solutions/4928043/java-o-n-recursive-solution/
    //5-10min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //41.30
    //MB
    //Beats
    //44.22%
    //of users with Java
    static ListNode plusOne(ListNode head) {
        int[] res = new int[1];
        goRec(head, res);
        if (res[0] > 0) {
            ListNode head1 = new ListNode(1);
            head1.next = head;
            return head1;
        }
        return head;
    }

    private static void goRec(ListNode node, int[] res) {
        if (node == null) return;

        goRec(node.next, res);

        if (node.next == null) {
            if (node.val < 9) {
                node.val++;
            } else {
                res[0]++;
                node.val = 0;
            }
        } else {
            if (res[0] > 0) {
                if (node.val == 9) {
                    node.val = 0;
                } else {
                    node.val++;
                    res[0] = 0;
                }
            }
        }
    }
}
