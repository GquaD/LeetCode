package LeetCode.medium;

import java.util.Stack;

public class Problem921 {
    //https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid("((("));
        System.out.println(minAddToMakeValid("((()()("));
    }

    //https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/solutions/3097799/java-stack-o-n-solution/
    //Runtime: 5 ms, faster than 5.80% of Java online submissions for Minimum Add to Make Parentheses Valid.
    //Memory Usage: 41.8 MB, less than 74.08% of Java online submissions for Minimum Add to Make Parentheses Valid.
    static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.size() != 0 && stack.peek() == '(' && c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }
}
