package LeetCode.easy;

import java.util.Stack;

public class Problem1417 {
    //https://leetcode.com/problems/reformat-the-string/
    public static void main(String[] args) {
        System.out.println(reformat("a0b1c2"));
        System.out.println(reformat("leetcode"));
        System.out.println(reformat("1229857369"));
    }

    //https://leetcode.com/problems/reformat-the-string/solutions/3834664/java-2-stacks-1-stringbuilder/
    //10 min
    //Runtime
    //8 ms
    //Beats
    //40.20%
    //Memory
    //43.8 MB
    //Beats
    //49.2%
    static String reformat(String s) {
        Stack<Character> stack1 = new Stack<>(), stackA = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) stack1.push(s.charAt(i));
            else stackA.push(s.charAt(i));
        }
        if (Math.abs(stackA.size() - stack1.size()) > 1) return "";
        StringBuilder sb = new StringBuilder();
        if (stack1.size() >= stackA.size()) {
            while (!stack1.isEmpty()) {
                sb.append(stack1.pop());
                if (!stackA.isEmpty()) sb.append(stackA.pop());
            }
        } else {
            while (!stackA.isEmpty()) {
                sb.append(stackA.pop());
                if (!stack1.isEmpty()) sb.append(stack1.pop());
            }
        }
        return sb.toString();
    }
}
