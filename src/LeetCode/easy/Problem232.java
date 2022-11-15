package LeetCode.easy;

import java.util.Collections;
import java.util.Stack;

public class Problem232 {
    //https://leetcode.com/problems/implement-queue-using-stacks/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/implement-queue-using-stacks/solutions/2816254/java-1-ms-explained/
    //40 min
    //Runtime
    //1 ms
    //Beats
    //77.93%
    //Memory
    //42 MB
    //Beats
    //27.6%
    static class MyQueue {
        Stack<Integer> stackMain;
        Stack<Integer> stackReverse;

        public MyQueue() {
            stackMain = new Stack<>();
            stackReverse = new Stack<>();
        }

        public void push(int x) {
            stackMain.push(x);
        }

        public int pop() {
            copyStackFirstToTwo(stackMain, stackReverse);
            int result = stackReverse.pop();
            copyStackFirstToTwo(stackReverse, stackMain);
            return result;
        }

        private void copyStackFirstToTwo(Stack<Integer> one, Stack<Integer> destination) {
            while (!one.empty()) {
                destination.push(one.pop());
            }
        }

        public int peek() {
            copyStackFirstToTwo(stackMain, stackReverse);
            int result = stackReverse.peek();
            copyStackFirstToTwo(stackReverse, stackMain);
            return result;
        }

        public boolean empty() {
            return stackMain.empty();
        }
    }
}
