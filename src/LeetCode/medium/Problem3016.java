package LeetCode.medium;
import java.util.*;

public class Problem3016 {
    //https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/solutions/4609014/java-100-faster-hashmap-priorityqueue/
    //10-15 min
    //Runtime
    //66
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //45.78
    //MB
    //Beats
    //100.00%
    //of users with Java
    static int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (char k : map.keySet()) {
            pq.offer(map.get(k));
        }

        int count = 8, sum = 0;
        while (!pq.isEmpty()) {
            int f = pq.poll();
            int point = count++ / 8;
            sum += f * point;
        }

        return sum;
    }
}
