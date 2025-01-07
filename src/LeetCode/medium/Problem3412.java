package LeetCode.medium;

import java.util.Stack;

public class Problem3412 {
    //https://leetcode.com/problems/find-mirror-score-of-a-string
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-mirror-score-of-a-string/solutions/6244529/java-on-alphabet-array-of-stacks-by-tbek-69a4/
    //5-10min
    //Runtime
    //26
    //ms
    //Beats
    //82.70%
    //Analyze Complexity
    //Memory
    //46.38
    //MB
    //Beats
    //41.88%
    public long calculateScore(String s) {
        Stack<Integer>[] arr = new Stack[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = new Stack<>();
        }
        long score = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a', mirror = findMirror(idx);
            if (arr[mirror].size() > 0) {
                score += i - arr[mirror].pop();
            } else {
                arr[idx].push(i);
            }
        }
        return score;
    }

    private int findMirror(int i) {
        if (i <= 12) {
            return 25 - i;
        } else {
            return 13 - (i - 12);
        }
    }
}
