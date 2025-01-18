package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem3424 {
    //https://leetcode.com/problems/minimum-cost-to-make-arrays-identical
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-cost-to-make-arrays-identical/solutions/6299526/java-onlogn-solution-by-tbekpro-eisz/
    //10min
    //Runtime
    //300
    //ms
    //Beats
    //-%
    //Analyze Complexity
    //Memory
    //57.92
    //MB
    //Beats
    //-%
    public long minCost(int[] arr, int[] brr, long k) {
        PriorityQueue<Integer> pqa = new PriorityQueue<>(), pqb = new PriorityQueue<>();
        long res = 0, temp = 0;
        for (int i = 0; i < arr.length; i++) {
            pqa.offer(arr[i]);
            pqb.offer(brr[i]);
            temp += Math.abs(brr[i] - arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            res += Math.abs(pqb.poll() - pqa.poll());
        }
        res = res == temp ? res : res + k;
        return temp < res ? temp : res;
    }
}
