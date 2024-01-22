package LeetCode.medium;
import java.util.*;

public class Problem3016 {
    //https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/solutions/4609045/java-o-n-100-faster/
    //Runtime
    //8
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //45.27
    //MB
    //Beats
    //100.00%
    //of users with Java

    static int minimumPushesq(String w) {
        int[] alph = new int[26];
        for (int i = 0; i < w.length(); i++) alph[w.charAt(i) - 'a']++;
        Arrays.sort(alph);
        int sum = 0, count = 8;
        for (int i = 25; i >= 0; i--) sum += alph[i] * (count++ / 8);
        return sum;
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
    static int minimumPushesq1(String word) {
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
