package LeetCode.hard;

import java.util.PriorityQueue;

public class Problem899 {
    //https://leetcode.com/problems/orderly-queue/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/orderly-queue/solutions/3318494/java-using-priorityqueue/
    //15 min
    //Runtime
    //6 ms
    //Beats
    //31.73%
    //Memory
    //43.2 MB
    //Beats
    //21.15%
    static String orderlyQueue(String s, int k) {
        if (k > 1) {
            PriorityQueue<Character> pq = new PriorityQueue<>();
            for (int i = 0; i < s.length(); i++) {
                pq.offer(s.charAt(i));
            }
            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                sb.append(pq.poll());
            }
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            PriorityQueue<String> pq = new PriorityQueue<>();
            pq.offer(s);
            String temp = s;
            for (int i = 0; i < s.length(); i++) {
                sb.append(temp, 1, temp.length()).append(temp, 0, 1);
                temp = sb.toString();
                pq.offer(temp);
                sb.setLength(0);
            }
            return pq.poll();
        }
    }

    //todo
    //todo
    static String orderlyQueue1(String s, int k) {
        if (k == 1) {
            char c = 'z'; //smallest char
            for (int i = 0; i < s.length(); i++) {
                if (c > s.charAt(i)) c = s.charAt(i);
            }
            int max = 0;
            if (s.charAt(s.length() - 1) == c && s.charAt(0) == c) {
                int count = 0;
                while (s.charAt(count) == c) count++;
                int idx = s.length() - 1;
                while (s.charAt(idx--) == c) count++;
                if (count > max) max = count;
                for (int i = 1; i < s.length(); i++) {
//                    if (s.charAt(i) == )
                }
            }
        }
        return "";
    }
}
