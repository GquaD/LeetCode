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
    //todo
    //Runtime: 276 ms, faster than 5.06% of Java online submissions for Design a Stack With Increment Operation.
    //Memory Usage: 62 MB, less than 5.21% of Java online submissions for Design a Stack With Increment Operation.
    static class CustomStack {
        int capacity;
        List<Integer> list;

        public CustomStack(int maxSize) {
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
