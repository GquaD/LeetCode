package LeetCode.medium;
import java.util.*;

public class Problem1754 {
    //https://leetcode.com/problems/largest-merge-of-two-strings/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/largest-merge-of-two-strings/solutions/4552757/java-o-n-priorityqueue/
    //5-10min
    //Runtime
    //45
    //ms
    //Beats
    //59.38%
    //of users with Java
    //Memory
    //45.20
    //MB
    //Beats
    //38.54%
    //of users with Java
    static String largestMerge(String a, String b) {
        PriorityQueue<String> pq = new PriorityQueue<>((x, y) -> y.compareTo(x));
        pq.offer(a);
        pq.offer(b);
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            String s = pq.poll();
            if (s.length() == 0) continue;
            sb.append(s.charAt(0));
            pq.offer(s.substring(1));
        }
        return sb.toString();
    }
}
