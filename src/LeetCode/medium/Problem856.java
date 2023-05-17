package LeetCode.medium;

import java.util.Stack;

public class Problem856 {
    //https://leetcode.com/problems/score-of-parentheses/
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("((())())"));
        System.out.println(scoreOfParentheses("((()()))((()()()))((()()))"));
        System.out.println(scoreOfParentheses("((()()))"));
    }

    //nnnn
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.6 MB
    //Beats
    //34.67%
    static int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(score);
                score = 0;
            } else {
                score = st.pop() + Math.max(2 * score, 1);
            }
        }
        return score;
    }

    static int scoreOfParentheses1(String s) {
        if (s.length() == 2) return 1;
        Stack<Character> stack = new Stack<>();
        int arr[] = new int[s.length() / 2], count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                arr[count++] = stack.size();
            } else {
                stack.pop();
            }
        }
        int c = 1, sum = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i + 1] == 1) {
                sum += c;
                c = 1;
                continue;
            }
            if (arr[i + 1] == arr[i]) c++;
            else c *= 2;
        }
        return c > 0 ? sum + c : sum;
    }
}
