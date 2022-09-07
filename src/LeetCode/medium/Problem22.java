package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem22 {
    //https://leetcode.com/problems/generate-parentheses/
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        LeetCodeUtils.printList(result);
        LeetCodeUtils.printList(generateParenthesis(2));
        LeetCodeUtils.printList(generateParenthesis(1));
        LeetCodeUtils.printList(generateParenthesis(4));
    }

    //1-2 hours
    //Runtime: 77 ms, faster than 5.18% of Java online submissions for Generate Parentheses.
    //Memory Usage: 73.3 MB, less than 5.31% of Java online submissions for Generate Parentheses.
    static Set<String> combinations;

    static List<String> generateParenthesis(int n) {

        combinations = new HashSet<>();
        Stack<String> open = new Stack<>();
        Stack<String> close = new Stack<>();
        for (int i = 0; i < n; i++) {
            open.push("(");
            close.push(")");
        }

        traversePossible(open, close, "", n + n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('(');
        }
        for (int i = 0; i < n; i++) {
            sb.append(')');
        }
        combinations.add(sb.toString());
        return new ArrayList<>(combinations);
    }

    private static void traversePossible(Stack<String> open, Stack<String> close, String current, int limit) {
        if (current.length() > limit) return;
        if (current.length() == limit) {
            if (isValidParentheses(current) && !combinations.contains(current)) {
                combinations.add(current);
            }
            return;
        }
        if (open.size() > 0) {
            current += open.pop();
            traversePossible(open, close, current, limit);
        }
        current = current.substring(0, current.length() - 1);

        open.push("(");

        if (close.size() > 0) {
            current += close.pop();
            traversePossible(open, close, current, limit);
        }

        close.push(")");
    }

    static boolean isValidParentheses(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));
            if (current.equals("(")) {
                stack.push(current);
            } else {
                if (current.equals(")") && stack.size() == 0) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }
}
