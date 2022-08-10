package LeetCode.medium;

public class Problem2181 {
    //https://leetcode.com/problems/merge-nodes-in-between-zeros/
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        System.out.println(mergeNodes(node1).val);
    }

    //Runtime: 12 ms, faster than 55.41% of Java online submissions for Merge Nodes in Between Zeros.
    //Memory Usage: 302.6 MB, less than 41.05% of Java online submissions for Merge Nodes in Between Zeros.
    static ListNode mergeNodes(ListNode head) {
        int tempSum = 0;
        ListNode root = new ListNode();
        head = head.next;
        ListNode currentNode = root;
        while (head != null) {
            if (head.val == 0) {
                if (root.val == 0) {
                    root.val = tempSum;
                } else {
                    ListNode node = new ListNode(tempSum);
                    currentNode.next = node;
                    currentNode = node;
                }
                tempSum = 0;
            } else {
                tempSum += head.val;
            }
            head = head.next;
        }
        return root;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
