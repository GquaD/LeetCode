package LeetCode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem1471 {
    //https://leetcode.com/problems/the-k-strongest-values-in-an-array/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getStrongest(new int[]{1,2,3,4,5}, 2)));
        System.out.println(Arrays.toString(getStrongest(new int[]{1,1,3,5,5}, 2)));
        System.out.println(Arrays.toString(getStrongest(new int[]{6,7,11,7,6,8}, 5)));
        System.out.println(Arrays.toString(getStrongest(new int[]{1}, 1)));
        System.out.println(Arrays.toString(getStrongest(new int[]{100}, 1)));
    }

    //https://leetcode.com/problems/the-k-strongest-values-in-an-array/solutions/4441445/java-sort-priorityqueue/
    //10min
    //Runtime
    //110 ms
    //Beats
    //8.27%
    //Memory
    //58.5 MB
    //Beats
    //5.79%
    static int[] getStrongest(int[] arr, int k) {
        if (k == arr.length) return arr;
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((b, a) ->
                Math.abs(a - m) == Math.abs(b - m) ? a - b : Math.abs(a - m) - Math.abs(b - m));
        for (int n : arr) {
            pq.offer(n);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
