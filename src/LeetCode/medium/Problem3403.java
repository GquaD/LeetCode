package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem3403 {
    //https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/solutions/6310925/java-heap-solution-by-tbekpro-bvc3/
    //5-10min
    //Runtime
    //21
    //ms
    //Beats
    //22.75%
    //Analyze Complexity
    //Memory
    //72.76
    //MB
    //Beats
    //5.00%
    public String answerString(String word, int n) {
        if (n == 1) return word;
        int len = word.length(), maxLen = len - n + 1;
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int i = maxLen; i <= len; i++) {
            pq.offer(word.substring(i - maxLen, i));
        }
        for (int i = len - maxLen; i <= len; i++) {
            pq.offer(word.substring(i, len));
        }
        return pq.poll();
    }
}
