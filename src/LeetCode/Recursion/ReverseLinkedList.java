package LeetCode.Recursion;

public class ReverseLinkedList {
    //SOLVED!

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("Before reverse: " );
        ListNode before = node1;
        while (before != null) {
            System.out.print(before.val + " -> ");
            before = before.next;
        }

        ListNode after = reverseList(node1);
        System.out.println("\nAfter reverse: ");
        while (after != null) {
            System.out.print(after.val + " -> ");
            after = after.next;
        }
        System.out.println();
    }

    static ListNode reverseList(ListNode head) {
        return reverseRecursively(null, head);
    }

    static ListNode reverseRecursively(ListNode prev, ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            head.next = prev;
            return head;
        }
        ListNode tempNext = head.next;
        head.next = prev;
        return reverseRecursively(head, tempNext);
    }
}
