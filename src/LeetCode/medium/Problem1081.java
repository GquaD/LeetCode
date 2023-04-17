package LeetCode.medium;

import java.util.Stack;

public class Problem1081 {
    //https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/
    public static void main(String[] args) {

    }

    //nnnn
    //Runtime
    //2 ms
    //Beats
    //96.66%
    //Memory
    //40.7 MB
    //Beats
    //52.3%
    static String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) lastIndex[s.charAt(i) - 'a'] = i;
        boolean[] visited = new boolean[26];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            int idxAlph = s.charAt(i) - 'a';
            if (!visited[idxAlph]) {
                while (!stack.isEmpty() && idxAlph < stack.peek() && i < lastIndex[stack.peek()]) visited[stack.pop()] = false;
                stack.push(idxAlph);
                visited[idxAlph] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append((char) (stack.pop() + 'a'));
        return sb.reverse().toString();
    }
}
