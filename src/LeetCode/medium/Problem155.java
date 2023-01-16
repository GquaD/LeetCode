package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem155 {
    //https://leetcode.com/problems/min-stack/
    public static void main(String[] args) {

    }


    //15 min
    //Runtime
    //5 ms
    //Beats
    //70.86%
    //Memory
    //44.6 MB
    //Beats
    //47.47%
    static class MinStack {
        List<Integer> list;
        PriorityQueue<Integer> pqueue;
        public MinStack() {
            list = new ArrayList<>();
            pqueue = new PriorityQueue<>();
        }

        public void push(int val) {
            list.add(val);
            pqueue.offer(val);
        }

        public void pop() {
            Integer n = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            pqueue.remove(n);
        }

        public int top() {
            return list.get(list.size() - 1);
        }

        public int getMin() {
            return pqueue.peek();
        }
    }
}
