package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem917 {
    //https://leetcode.com/problems/reverse-only-letters/
    public static void main(String[] args) {

    }
    //https://leetcode.com/problems/reverse-only-letters/solutions/2903446/java-o-n-n-2-ms-solution/
    //Runtime
    //2 ms
    //Beats
    //39.1%
    //Memory
    //40.2 MB
    //Beats
    //94.41%

    static String reverseOnlyLetters1(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) stack.push(c);
        }
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c))
                sb.append(stack.pop());
            else
                sb.append(c);
        }
        return sb.toString();
    }

    static String reverseOnlyLetters(String s) {
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) list.add(c);
        }
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c))
                sb.append(list.get(list.size() - count++ - 1));
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
