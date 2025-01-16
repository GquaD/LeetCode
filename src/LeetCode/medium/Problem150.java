package LeetCode.medium;

import java.util.Stack;

public class Problem150 {
    //https://leetcode.com/problems/evaluate-reverse-polish-notation/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/evaluate-reverse-polish-notation/solutions/6289227/java-stack-lifo-solution-by-tbekpro-stha/
    //5min
    //Runtime
    //6
    //ms
    //Beats
    //74.71%
    //Analyze Complexity
    //Memory
    //44.36
    //MB
    //Beats
    //93.32%
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s: tokens) {
            if (s.equals("+")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b + a);
            } else if (s.equals("-")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b - a);
            } else if (s.equals("*")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b * a);
            } else if (s.equals("/")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
