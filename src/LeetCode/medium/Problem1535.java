package LeetCode.medium;


import java.util.LinkedList;
import java.util.Queue;

public class Problem1535 {
    //https://leetcode.com/problems/find-the-winner-of-an-array-game
    public static void main(String[] args) {
        System.out.println(getWinner(new int[]{2,1,3,5,4,6,7}, 2));
        System.out.println(getWinner(new int[]{3,2,1}, 10));
    }

    //https://leetcode.com/problems/find-the-winner-of-an-array-game/solutions/4252872/java-using-queue/
    //10 min
    //Runtime
    //12 ms
    //Beats
    //19.57%
    //Memory
    //56.3 MB
    //Beats
    //81.16%
    static int getWinner(int[] arr, int k) {
        if (k >= arr.length) {
            int max = 0;
            for (int n : arr) max = Math.max(max, n);
            return max;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int n : arr) queue.add(n);
        int count = 0, left = queue.poll();
        while (count < k) {
            int next = queue.poll();
            if (left > next) {
                count++;
                queue.add(next);
            } else {
                count = 1;
                queue.add(left);
                left = next;
            }
        }
        return left;
    }
}
