package LeetCode.medium;

import javafx.util.Pair;

import java.util.*;

public class Problem1249 {
    //https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("a)b(c)d("));
    }

    //https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/solutions/3718068/java-using-stack-and-priorityqueue/
    //20 min
    //Runtime
    //41 ms
    //Beats
    //35.89%
    //Memory
    //44.7 MB
    //Beats
    //21.71%
    static String minRemoveToMakeValid1(String s) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        List<Integer> listIdx = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                if (stack.size() > 0) {
                    if (c == ')') stack.pop();
                    else stack.push(new Pair<>('(', i));
                } else {
                    if (c == ')') listIdx.add(i);
                    else stack.push(new Pair<>('(', i));
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(listIdx);
        while (!stack.isEmpty()) pq.offer(stack.pop().getValue());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!pq.isEmpty() && pq.peek() == i) pq.poll();
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    //Runtime
    //46 ms
    //Beats
    //29.90%
    //Memory
    //44.8 MB
    //Beats
    //21.71%
    static String minRemoveToMakeValid(String s) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        List<Integer> listIdx = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                if (stack.size() > 0) {
                    if (c == ')') stack.pop();
                    else stack.push(new Pair<>('(', i));
                } else {
                    if (c == ')') listIdx.add(i);
                    else stack.push(new Pair<>('(', i));
                }
            }
        }
        Set<Integer> set = new HashSet<>(listIdx);
        while (!stack.isEmpty()) set.add(stack.pop().getValue());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) if (!set.contains(i)) sb.append(s.charAt(i));
        return sb.toString();
    }


}
