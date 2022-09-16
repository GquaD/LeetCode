package LeetCode.easy;

import java.util.Stack;

public class Problem1047 {
    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
    }

    //Runtime: 69 ms, faster than 61.71% of Java online submissions for Remove All Adjacent Duplicates In String.
    //Memory Usage: 55.6 MB, less than 42.78% of Java online submissions for Remove All Adjacent Duplicates In String.
    static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        stack.push(s.charAt(index++));
        while (index < s.length()) {
            char c = s.charAt(index);
            if (stack.size() == 0 || !stack.peek().equals(c)) {
                stack.push(c);
            } else {
                stack.pop();
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
