package LeetCode.easy;

import java.util.Stack;

public class Problem3174 {
    //https://leetcode.com/problems/clear-digits/description/

    public static void main(String[] args) {

    }

    //2min
    //Runtime
    //2
    //ms
    //Beats
    //86.06%
    //of users with Java
    //Memory
    //42.59
    //MB
    //Beats
    //42.57%
    //of users with Java
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
