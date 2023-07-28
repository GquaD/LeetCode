package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problem1019 {
    //https://leetcode.com/problems/next-greater-node-in-linked-list/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextLargerNodes(Arrays.asList(2,1,5))));
        System.out.println(Arrays.toString(nextLargerNodes(Arrays.asList(2,7,4,3,5))));
    }

    //https://leetcode.com/problems/next-greater-node-in-linked-list/solutions/3830880/java-93-faster-arraylist-stack-o-n/
    //30 min
    //Runtime
    //23 ms
    //Beats
    //93.28%
    //Memory
    //47.6 MB
    //Beats
    //16.12%
    static int[] nextLargerNodes1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(list.get(list.size() - 1));
        for (int i = list.size() - 2; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int last = stack.peek();
                if (list.get(i) < last) {
                    arr[i] = last;
                    stack.add(list.get(i));
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) stack.add(list.get(i));
        }
        return arr;
    }

    static int[] nextLargerNodes(List<Integer> list) {
        /*List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }*/
        int[] arr = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(list.get(list.size() - 1));
        for (int i = list.size() - 2; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int last = stack.peek();
                if (list.get(i) < last) {
                    arr[i] = last;
                    stack.add(list.get(i));
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) stack.add(list.get(i));
        }
        return arr;
    }
}
