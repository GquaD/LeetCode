package LeetCode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem2410 {
    //https://leetcode.com/problems/maximum-matching-of-players-with-trainers/
    public static void main(String[] args) {
        System.out.println(matchPlayersAndTrainers(new int[]{4,7,9}, new int[]{8,2,5,8}));
        System.out.println(matchPlayersAndTrainers(new int[]{1,1,1}, new int[]{8}));
    }

    //https://leetcode.com/problems/maximum-matching-of-players-with-trainers/solutions/3689820/java-using-2-priorityqueues/
    //5-10 min
    //Runtime
    //145 ms
    //Beats
    //5.33%
    //Memory
    //56 MB
    //Beats
    //99.59%
    static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        PriorityQueue<Integer> pqP = new PriorityQueue<>(), pqT = new PriorityQueue<>();
        for (int p : players) pqP.offer(p);
        for (int t : trainers) pqT.offer(t);
        int count = 0;
        while (!pqP.isEmpty() && !pqT.isEmpty()) {
            if (pqP.peek() <= pqT.peek()) {
                pqP.poll();
                pqT.poll();
                count++;
            } else {
                pqT.poll();
            }
        }
        return count;
    }

    //Runtime
    //387 ms
    //Beats
    //5.33%
    //Memory
    //59.6 MB
    //Beats
    //90.98%
    static int matchPlayersAndTrainers1(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p = 0, t = 0, count = 0;
        while (p < players.length && t < trainers.length) {
            if (players[p] <= trainers[t]) {
                p++;
                t++;
                count++;
            } else {
                t++;
            }
        }
        return count;
    }
}
