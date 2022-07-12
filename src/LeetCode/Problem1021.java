package LeetCode;

import java.util.Stack;

public class Problem1021 {
    //https://leetcode.com/problems/remove-outermost-parentheses/submissions/
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses1("(()())(())"));
        System.out.println(removeOuterParentheses1("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses1("()()"));
    }
    //Runtime: 4 ms, faster than 80.23% of Java online submissions for Remove Outermost Parentheses.
    //Memory Usage: 43 MB, less than 52.74% of Java online submissions for Remove Outermost Parentheses.
    static String removeOuterParentheses1(String s) {
        short[] levels = new short[s.length()];
        short level = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                levels[i] = level;
                level++;
            }
            if (s.charAt(i) == ')') {
                level--;
                levels[i] = level;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < levels.length; i++) {
            if (levels[i] > 0) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    static String removeOuterParentheses(String s) {
        boolean toDelete = true;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' && toDelete) {
                count++;
                toDelete = !toDelete;
            } else if (s.charAt(i) == ')' && !toDelete) {
                if (count == 0) {
                    toDelete = !toDelete;
                } else {
                    count--;
                    sb.append(s.charAt(i));
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    static boolean isValidParentheses(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));
            if (current.equals("(") || current.equals("[") || current.equals("{")) {
                stack.push(current);
            } else {
                if (current.equals(")") && !stack.peek().equals("(")
                        || current.equals("]") && !stack.peek().equals("[")
                        || current.equals("}") && !stack.peek().equals("{")) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return true;
    }
}
