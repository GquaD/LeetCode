package LeetCode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2486 {
    //https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/
    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
    }

    //https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/solutions/3472300/java-3-line-o-n-solution/
    //5 min
    //Runtime
    //8 ms
    //Beats
    //26.76%
    //Memory
    //43.4 MB
    //Beats
    //40.61%
    static int appendCharacters(String s, String t) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) if (c < t.length() && s.charAt(i) == t.charAt(c)) c++;
        return t.length() - c;
    }

    //
    //5 min
    //Runtime
    //16 ms
    //Beats
    //8.22%
    //Memory
    //50.8 MB
    //Beats
    //6.10%
    static int appendCharacters1(String s, String t) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < t.length(); i++) queue.offer(t.charAt(i));
        for (int i = 0; i < s.length(); i++) if (queue.size()> 0 && s.charAt(i) == queue.peek().charValue()) queue.poll();
        return queue.size();
    }
}
