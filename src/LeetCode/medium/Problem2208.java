package LeetCode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2208 {
    //https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
    public static void main(String[] args) {
        System.out.println(halveArray(new int[]{10000000}));
        System.out.println(halveArray(new int[]{1}));
        System.out.println(halveArray(new int[]{3,8,20}));
        System.out.println(halveArray(new int[]{5,19,8,1}));
    }


    //https://leetcode.com/problems/minimum-operations-to-halve-array-sum/solutions/4214497/java-o-n-solution/
    //10-15min
    //Runtime
    //189 ms
    //Beats
    //40.30%
    //Memory
    //58 MB
    //Beats
    //20.52%

    static int halveArray(int[] nums) {
        //if (nums.length == 1) return 1;
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0L;
        double substracted = 0;
        for (int n : nums) {
            sum += n;
            pq.add((double) n);
        }
        int count = 0;
        sum /= 2;
        while (substracted < sum) {
            double d = pq.poll();
            d /= 2;
            substracted += d;
            pq.add(d);
            count++;
        }
        return count;
    }
}
