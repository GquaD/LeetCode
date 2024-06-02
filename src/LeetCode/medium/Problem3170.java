package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem3170 {
    //https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/
    public static void main(String[] args) {
        System.out.println(clearStars("aaba*"));
        System.out.println(clearStars("abc"));
    }

    //https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/solutions/5246681/java-o-nlogn-priorityqueue-heap-solution/
    //10-15min
    //Runtime
    //137
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //45.95
    //MB
    //Beats
    //100.00%
    //of users with Java
    static String clearStars(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (!pq.isEmpty()) {
                    char t = pq.poll();
                    int idx = sb.lastIndexOf(String.valueOf(t));
                    sb.replace(idx, idx + 1, "");
                }
            } else {
                sb.append(c);
                pq.offer(c);
            }
        }
        return sb.toString();
    }
}
