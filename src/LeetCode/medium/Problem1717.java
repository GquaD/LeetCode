package LeetCode.medium;

import java.util.Stack;

public class Problem1717 {
    //https://leetcode.com/problems/maximum-score-from-removing-substrings/description/

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-score-from-removing-substrings/solutions/5465431/java-greedy-stack-solution/
    //15min
    //Runtime
    //185
    //ms
    //Beats
    //51.52%
    //Analyze Complexity
    //Memory
    //47.60
    //MB
    //Beats
    //18.18%
    public int maximumGain(String s, int x, int y) {
        int max = 0;
        Stack<Character> stack = new Stack<>();
        if (x >= y) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == 'a' && c == 'b') {
                        max += x;
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            String t = sb.reverse().toString();
            stack.clear();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == 'b' && c == 'a') {
                        max += y;
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            return max;
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == 'b' && c == 'a') {
                        max += y;
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            String t = sb.reverse().toString();
            stack.clear();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == 'a' && c == 'b') {
                        max += x;
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            return max;
        }
    }
}
