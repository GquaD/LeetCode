package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem20 {
    //https://leetcode.com/problems/valid-parentheses/description/
    public static void main(String[] args) {
        System.out.println(isValidParentheses("()"));
        System.out.println(isValidParentheses("()[]{}"));
        System.out.println(isValidParentheses("(]"));
        System.out.println(isValidParentheses("("));
        System.out.println(isValidParentheses("(("));
        System.out.println(isValidParentheses("){"));
        System.out.println(isValidParentheses("(){}}{"));
    }

    //Runtime
    //3
    //ms
    //Beats
    //85.89%
    //Memory
    //43.61
    //MB
    //Beats
    //9.80%
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean isOpening = c == '(' || c == '[' || c == '{';
            if (isOpening) {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char last = stack.peek();
                if (last == '(') {
                    if (c == ')') stack.pop();
                    else return false;
                } else if (last == '[') {
                    if (c == ']') stack.pop();
                    else return false;
                } else {
                    if (c == '}') stack.pop();
                    else return false;
                }
            }
        }

        return stack.size() == 0;
    }


    //took 20-30mins
    //https://leetcode.com/problems/valid-parentheses/solutions/2641027/java-2-solutions-stack-arraylist-in-just-1-ms-99-71-faster/
    //Runtime 1 ms Beats 99.71%
    //Memory 40 MB Beats 98.97% - with arraylist

    //4 ms//Beats//41.61%//Memory//42.2 MB//Beats//39.86% - with Stack
    static boolean isValidParentheses(String s) {
        if (s.length() == 1) return false;
//        Stack<Character> stack = new Stack<>();
        List<Character> stack = new ArrayList<>();
        int currIdx = 0;
        while (currIdx < s.length()) {
            char c = s.charAt(currIdx);
            int last = stack.size() - 1;
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else if ((currIdx == 0 || stack.isEmpty()) && (c == ')' || c == ']' || c == '}')) {
                return false;
            } else if (stack.get(last) != '(' && c == ')'
                    || stack.get(last) != '[' && c == ']'
                    || stack.get(last) != '{' && c == '}')   {
                return false;
            } else {
                stack.remove(stack.size() - 1);
            }
            currIdx++;
        }
        return stack.size() == 0;
    }

    static boolean isValidParentheses1(String s) {
        if (s.length() == 1) return false;
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
        if (stack.size() > 0) return false;
        return true;
    }
}
