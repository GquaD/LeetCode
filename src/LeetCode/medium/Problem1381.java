package LeetCode.medium;

import java.util.LinkedList;
import java.util.List;

public class Problem1381 {
    //https://leetcode.com/problems/design-a-stack-with-increment-operation/
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
    //improved performance
    //todo
    //Runtime: 33 ms, faster than 16.75% of Java online submissions for Design a Stack With Increment Operation.
    //Memory Usage: 50.9 MB, less than 28.29% of Java online submissions for Design a Stack With Increment Operation.
    static class CustomStack {
        int capacity;
        BaseStack baseStack;

        public CustomStack(int maxSize) {
            this.capacity = maxSize;
            this.baseStack = new BaseStack();
        }

        public void push(int x) {
            if (this.baseStack.size < this.capacity) {
                this.baseStack.push(x);
            }
        }

        public int pop() {
            return baseStack.pop();
        }

        public void increment(int k, int val) {
            int times = Math.min(this.baseStack.size, k);
            ListNode node = this.baseStack.top;
            if (this.baseStack.size > k) {
                int diff = this.baseStack.size - k;
                for (int i = 0; i < diff; i++) {
                    node = node.prev;
                }
            }
            while (node != null) {
                node.val += val;
                node = node.prev;
            }
        }
    }

    static class BaseStack {
        int size;
        ListNode top;

        public BaseStack() {
            this.size = 0;
            this.top = null;
        }

        public void push(int x) {
            ListNode node = new ListNode(x);
            node.prev = this.top;
            this.top = node;
            this.size++;
        }

        public int pop() {
            int result = -1;
            if (this.top == null) {
                System.out.println("BaseStack size = 0");
                return result;
            } else {
                result = this.top.val;
                this.top = this.top.prev;
                this.size--;
            }
            return result;
        }
    }

    static class ListNode {
        int val;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }


    //Runtime: 276 ms, faster than 5.06% of Java online submissions for Design a Stack With Increment Operation.
    //Memory Usage: 62 MB, less than 5.21% of Java online submissions for Design a Stack With Increment Operation.
    static class CustomStack1 {
        int capacity;
        List<Integer> list;

        public CustomStack1(int maxSize) {
            this.capacity = maxSize;
            this.list = new LinkedList<>();
        }

        public void push(int x) {
            if (this.list.size() < this.capacity) {
                this.list.add(x);
            }
            /*if (list.size() > this.capacity) {
                list.remove(0);
            }*/
        }

        public int pop() {
            if (this.list.size() == 0) {
                return -1;
            }
            int temp = this.list.get(this.list.size() - 1);
            this.list.remove(this.list.size() - 1);
            return temp;
        }

        public void increment(int k, int val) {
            int times = Math.min(this.list.size(), k);
//            for (int i = list.size() - times; i < list.size(); i++) {
            for (int i = 0; i < times; i++) {
                int temp = this.list.get(i);
                this.list.remove(i);
                this.list.add(i, temp + val);
            }
        }
    }
}
