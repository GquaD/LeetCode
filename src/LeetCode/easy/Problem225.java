package LeetCode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class Problem225 {
    //https://leetcode.com/problems/implement-stack-using-queues/description/
    public static void main(String[] args) {

    }
    //15-20 mins
    //https://leetcode.com/problems/implement-stack-using-queues/solutions/2823015/java-using-2-queues/
    //Runtime
    //1 ms
    //Beats
    //42.35%
    //Memory
    //42 MB
    //Beats
    //24.59%
    static class MyStack {
        Queue<Integer> one;
        Queue<Integer> two;

        public MyStack() {
            one = new LinkedList<>();
            two = new LinkedList<>();
        }

        public void push(int x) {
            one.add(x);
        }

        public int pop() {
            if (one.size() > 0) {
                while (one.size() > 1) {
                    two.add(one.poll());
                }
                return one.poll();
            } else {
                while (two.size() > 1) {
                    one.add(two.poll());
                }
                return two.poll();
            }
        }

        public int top() {
            if (one.size() > 0) {
                while (one.size() > 1) {
                    two.add(one.poll());
                }
                two.add(one.peek());
                return one.poll();
            } else {
                while (two.size() > 1) {
                    one.add(two.poll());
                }
                one.add(two.peek());
                return two.poll();
            }
        }

        public boolean empty() {
            return one.isEmpty() && two.isEmpty();
        }
    }
}
