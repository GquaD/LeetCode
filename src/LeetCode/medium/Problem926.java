package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem926 {
    //https://leetcode.com/problems/flip-string-to-monotone-increasing/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/flip-string-to-monotone-increasing/solutions/3061813/java-o-n-solution/
    //Runtime
    //9 ms
    //Beats
    //92.20%
    //Memory
    //43.1 MB
    //Beats
    //55.59%
    static int minFlipsMonoIncr1(String s) {
        if (s == null || s.length() == 0) return 0;
        int count0s = 0, count1s = 0;
        boolean first1met = false;
        for (char c : s.toCharArray()) {
            if (c == '1' && !first1met) {
                first1met = true;
                count1s++;
            } else if (first1met && c == '1') count1s++;
            else count0s++;
            if (count0s > count1s) count0s = count1s;
        }
        return count0s;
    }

    static int minFlipsMonoIncr2(String s) {
        int count0s = 0, count1s = 0;
        boolean first0met = false;
        for (int i = s.length() - 1; i >= 0; i++) {
            char c = s.charAt(i);
            if (c == '1' && !first0met)
                continue;
            else if (c == '0' && !first0met) {
                first0met = true;
                count0s++;
            } else if (c == '1' && first0met) {
                count1s++;
            } else {
                count0s++;
            }

        }
        return Math.min(count0s, count1s);
    }

    static int minFlipsMonoIncr(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        char[] arr = s.toCharArray();
        for (char c : arr) pq.offer(c);
        int count = 0;
        for (char c : arr)
            if (c != pq.poll()) count++;
        return count;
    }
}
