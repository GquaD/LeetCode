package LeetCode.medium;

import java.util.Stack;

public class Problem1541 {
    //2h
    //Runtime
    //44
    //ms
    //Beats
    //5.42%
    //Memory
    //47.83
    //MB
    //Beats
    //11.85%
    public int minInsertions(String s) {
        //if stack empty and ) is appearing = use counter for that case
        int result = 0, close = 0, open = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (stack.size() % 2 == 1) {
                    stack.pop();
                    result++;
                }
                if (close > 0) {
                    result += close / 2;
                    if (close % 2 == 1) result += 2;
                    close = 0;
                }
                stack.push('(');
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    close++;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.size() > 0) {
            result += stack.size();
        }
        if (close > 0) {
            result += close / 2;
            if (close % 2 == 1) result += 2;
        }

        return result;
    }
}
