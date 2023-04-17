package LeetCode.medium;

import javafx.util.Pair;

import java.util.*;

public class Problem316 {
    //https://leetcode.com/problems/remove-duplicate-letters/description/
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
    }


    //nnnn
    //Runtime
    //2 ms
    //Beats
    //98.92%
    //Memory
    //41.4 MB
    //Beats
    //81.16%
    static String removeDuplicateLetters(String s) {
        int[] lastIdx = new int[26];
        for (int i = 0; i < s.length(); i++) lastIdx[s.charAt(i) - 'a'] = i;
        boolean[] visited = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (!visited[idx]) {
                while (!stack.isEmpty() && stack.peek() > idx && i < lastIdx[stack.peek()]) visited[stack.pop()] = false;
                stack.push(idx);
                visited[idx] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append((char) (stack.pop() + 'a'));
        return sb.reverse().toString();
    }


    static String removeDuplicateLetters2(String s) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        int min = 26;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (min > c - 'a') {
                set.clear();
                min = c - 'a';
            }
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : set) sb.append(c);
        return sb.toString();
    }

    static String removeDuplicateLetters1(String s) {
        List<Integer>[] alph = new List[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (alph[c] == null) {
                alph[c] = new ArrayList<>();
                alph[c].add(i);
            }
        }
        int count = 0;
        for (int i = 0; i < alph.length; i++) {
            if (alph[i] != null) count++;
        }
        StringBuilder sb = new StringBuilder();

        while (sb.length() < count) {

            for (int i = 0; i < alph.length; i++) {

            }
        }
        return "";
    }
}
