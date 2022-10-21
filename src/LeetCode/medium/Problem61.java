package LeetCode.medium;


public class Problem61 {
    //https://leetcode.com/problems/rotate-list/
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode node = rotateRight(n1, 2);
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(", ");
            node = node.next;
        }
        System.out.println(sb.toString().trim());

        ListNode no1 = new ListNode(1);
        ListNode no2 = new ListNode(2);
        no1.next = no2;
        ListNode listNode = rotateRight(no1, 2);
        sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val).append(", ");
            listNode = listNode.next;
        }
        System.out.println(sb.toString().trim());
    }


    //https://leetcode.com/problems/rotate-list/solutions/2728189/java-solution-in-just-1-ms/
    //in 32 mins
    //Runtime
    //1 ms
    //Beats
    //84.90%
    //Memory
    //43.2 MB
    //Beats
    //40%
    static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int move = k % count;
        if (k == count || move == 0) return head;
        temp = head;
        int count1 = 0;
        ListNode result = head, prev = head;

        while (count1 < count) {
            if (count - count1 == move) {
                prev.next = null;
                result = temp;
            }
            count1++;
            if (count1 == count) {
                temp.next = head;
            }
            prev = temp;
            temp = temp.next;
        }
        return result;
    }
}
