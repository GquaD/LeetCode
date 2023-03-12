package LeetCode.hard;

import java.util.ArrayList;
import java.util.List;

public class Problem25 {
    //https://leetcode.com/problems/reverse-nodes-in-k-group/
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        System.out.println(reverseKGroup(n1, 2).val);

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(reverseKGroup(node1, 3).val);
    }

    //30 min
    //Runtime
    //1 ms
    //Beats
    //22.96%
    //Memory
    //42.8 MB
    //Beats
    //22.56%
    static ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];
        ListNode temp = head, prev = null;
        int count = 0;
        while (temp != null) {
            arr[count++ % k] = temp;
            temp = temp.next;
            if (count % k == 0) {
                for (int j = 0; j < arr.length / 2; j++) {
                    ListNode t = arr[j];
                    arr[j] = arr[arr.length - j - 1];
                    arr[arr.length - j - 1] = t;
                }
                for (int j = 1; j < arr.length; j++) {
                    if (arr[j - 1] != null) arr[j - 1].next = arr[j];
                }
                if (k == count) head = arr[0];
                if (prev != null) prev.next = arr[0];
                prev = arr[arr.length - 1];
                prev.next = null;
                arr = new ListNode[k];
            }
        }
        if (prev != null) prev.next = arr[0];
        return head;
    }

    //20-30 min
    //Runtime
    //2 ms
    //Beats
    //13.10%
    //Memory
    //42.7 MB
    //Beats
    //26.61%
    static ListNode reverseKGroup1(ListNode head, int k) {
        if (head.next == null) return head;
        List<ListNode[]> list = new ArrayList<>();
        int count = 0;
        while (head != null) {
            if (count % k == 0) list.add(new ListNode[k]);
            list.get(list.size() - 1)[count % k] = head;
            head = head.next;
            count++;
        }
        int n = list.size();

        if (list.size() > 0) {
            ListNode[] lastArr = list.get(list.size() - 1);
            if (lastArr[lastArr.length - 1] == null) n--;
        }

        for (int i = 0; i < n; i++) {
            ListNode[] arr = list.get(i);
            for (int j = 0; j < arr.length / 2; j++) {
                ListNode temp = arr[j];
                arr[j] = arr[arr.length - j - 1];
                arr[arr.length - j - 1] = temp;
            }
        }
        ListNode temp = null;
        for (ListNode[] arr : list) {
            if (temp != null) temp.next = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] != null) arr[i - 1].next = arr[i];
            }
            temp = arr[arr.length - 1];
        }
        if (!list.isEmpty()) {
            ListNode[] lastArr = list.get(list.size() - 1);
            if (lastArr[lastArr.length - 1] != null) {
                lastArr[lastArr.length - 1].next = null;
            } else {
                for (int i = 1; i < lastArr.length; i++) {
                    if (lastArr[i] == null) {
                        lastArr[i - 1].next = null;
                        break;
                    }
                }
            }
        }
        return list.get(0)[0];
    }
}
