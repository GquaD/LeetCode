package LeetCode.hard;

import java.util.*;

public class Problem23 {
    //https://leetcode.com/problems/merge-k-sorted-lists/
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(6);
        node1.next = node5;
        node5.next = node7;

        node2.next = node4;
        node4.next = node6;

        node3.next = node8;
        ListNode[] lists = new ListNode[]{node1, node2, node3};
        System.out.println(mergeKLists(lists).val);
    }

    //https://leetcode.com/problems/merge-k-sorted-lists/solutions/3286121/java-2-solutions-priorityqueue-arraylist/
    //5 min
    //Runtime
    //5 ms
    //Beats
    //71.47%
    //Memory
    //44.4 MB
    //Beats
    //35.80%
    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            while (head != null) {
                pq.offer(head);
                head = head.next;
            }
        }
        if (pq.peek() == null) return null;
        ListNode head = pq.poll(), temp = head;
        while (!pq.isEmpty()) {
            temp.next = pq.poll();
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    //
    //15-20 min
    //Runtime
    //8 ms
    //Beats
    //28.46%
    //Memory
    //44.1 MB
    //Beats
    //64.15%
    static ListNode mergeKLists1(ListNode[] lists) {
        List<ListNode> listBig = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            while (head != null) {
                listBig.add(head);
                head = head.next;
            }
        }
        Collections.sort(listBig, (o1, o2) -> o1.val - o2.val);
        for (int i = 1; i < listBig.size(); i++) listBig.get(i - 1).next = listBig.get(i);
        return listBig.size() > 0 ? listBig.get(0) : null;
    }
}
