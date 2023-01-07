package LeetCode.medium;

import java.util.List;
import java.util.Stack;

public class Problem143 {
    //https://leetcode.com/problems/reorder-list/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/reorder-list/solutions/3012286/java-o-n-using-stack/
    //10 min
    //Runtime
    //4 ms
    //Beats
    //50.53%
    //Memory
    //44.8 MB
    //Beats
    //95.34%
    static void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        int size = stack.size();
        for (int i = 0; i < size / 2; i++) {
            ListNode mem = temp.next;
            temp.next = stack.pop();
            temp.next.next = mem;
            temp = mem;
        }
        temp.next = null;
    }
}
