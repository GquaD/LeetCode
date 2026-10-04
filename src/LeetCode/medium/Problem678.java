package LeetCode.medium;

import java.util.Stack;

public class Problem678 {
    //1hour
    //Runtime
    //1
    //ms
    //Beats
    //26.70%
    //Memory
    //42.85
    //MB
    //Beats
    //34.06%
    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    boolean openFound = popOpen(stack);
                    if (!openFound) stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        int aster = 0, open = 0;

        while (!stack.isEmpty()) {
            if (stack.pop() == '*') {
                aster++;
            } else {
                open++;
            }
            if (open > aster) return false;
        }
        return true;
    }

    private boolean popOpen(Stack<Character> stack) {
        Stack<Character> temp = new Stack<>();
        boolean openFound = false;
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            if (c == '(') {
                openFound = true;
                break;
            } else {
                temp.push(c);
            }
        }

        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return openFound;
    }
}
