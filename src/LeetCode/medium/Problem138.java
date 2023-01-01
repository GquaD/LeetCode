package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem138 {
    //https://leetcode.com/problems/copy-list-with-random-pointer/
    public static void main(String[] args) {

    }

    //20-25 min
    //Runtime
    //1 ms
    //Beats
    //55.99%
    //Memory
    //42.2 MB
    //Beats
    //65.70%
    static Node copyRandomList(Node head) {
        if (head == null) return head;
        Node temp1 = head.next, headNew = new Node(head.val), temp2 = headNew;
        //create list first
        List<Node> list1 = new ArrayList<>();
        list1.add(head);
        List<Node> list2 = new ArrayList<>();
        while (temp1 != null) {
            temp2.next = new Node(temp1.val);

            list1.add(temp1);
            list2.add(temp2);

            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        list2.add(temp2);

        for (int i = 0; i < list1.size(); i++) {
            Node n = list1.get(i);
            if (n.random != null) {
                int idx = list1.indexOf(n.random);
                if (idx > -1) list2.get(i).random = list2.get(idx);
            }
        }
        return headNew;
    }
}
