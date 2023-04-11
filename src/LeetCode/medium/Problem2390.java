package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2390 {
    //https://leetcode.com/problems/removing-stars-from-a-string/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/removing-stars-from-a-string/solutions/3402528/java-using-arraylist/
    //Runtime
    //58 ms
    //Beats
    //75.91%
    //Memory
    //43.9 MB
    //Beats
    //70.74%
    static String removeStars2(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) list.add(c);
            else list.remove(list.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) sb.append(c);
        return sb.toString();
    }

    //5 min
    //Runtime
    //197 ms
    //Beats
    //54.88%
    //Memory
    //44.3 MB
    //Beats
    //62.63%
    static String removeStars1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) stack.push(c);
            else stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
