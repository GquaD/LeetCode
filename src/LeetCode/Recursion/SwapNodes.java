package LeetCode.Recursion;

public class SwapNodes {
    //not solved yet

    //task
    //Given a linked list, swap every two adjacent nodes and return its head.
    // You must solve the problem without modifying the values in the list's
    // nodes (i.e., only nodes themselves may be changed.)

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode head = swapPairs(node1);
        while (head.next != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }


    public static ListNode swapPairs(ListNode head) {
        headMain = head.next;
        recursiveSwap(head, head.next);
        return headMain;
    }
    static ListNode headMain = null;
    private static ListNode recursiveSwap(ListNode head, ListNode next) {
        if (head == null) {
            return null;
        }
        if (next == null) {
            return head;
        }
        ListNode nextPairLink = next.next;
        swap(head, next);
        if (nextPairLink == null) {
            return recursiveSwap(nextPairLink, null);
        } else {
            recursiveSwap(nextPairLink, nextPairLink.next);
        }
        return null;
    }

    static void swap(ListNode first, ListNode second) {
        //ListNode nextOfSecond = second.next;
        ListNode temp = second;
        second = first;
        first = temp;
    }

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
