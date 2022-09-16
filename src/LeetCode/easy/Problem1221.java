package LeetCode.easy;

import java.util.Stack;

public class Problem1221 {
    //https://leetcode.com/problems/split-a-string-in-balanced-strings/
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("LRLLRRR"));
    }

    //Runtime: 4 ms, faster than 7.60% of Java online submissions for Split a String in Balanced Strings.
    //Memory Usage: 42.8 MB, less than 6.76% of Java online submissions for Split a String in Balanced Strings.
    public static int balancedStringSplit(String s) {
        Stack<String> stack = new Stack<>();
        int count = 0;
        stack.push(s.charAt(0) + "");
        for (int i = 1; i < s.length(); i++) {
            String temp = s.charAt(i) + "";
            if (stack.size() == 0 || stack.peek().equals(temp)) {
                stack.push(s.charAt(i) + "");
            } else {
                stack.pop();
                if (stack.size() == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}
