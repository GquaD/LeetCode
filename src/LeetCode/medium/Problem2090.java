package LeetCode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2090 {
    //https://leetcode.com/problems/k-radius-subarray-averages/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/k-radius-subarray-averages/solutions/3662369/java-o-n-using-running-sum/
    //15-20 min
    //Runtime
    //12 ms
    //Beats
    //48.87%
    //Memory
    //62.5 MB
    //Beats
    //36.76%
    static int[] getAverages(int[] nums, int k) {
        int dist = k * 2;
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);
        if (dist > nums.length) return arr;
        long runSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runSum += i > dist ? nums[i] - nums[i - dist - 1] : nums[i];
            if (i >= dist) arr[i - k] = (int) (runSum / (dist + 1));
        }
        return arr;
    }


    //Runtime
    //25 ms
    //Beats
    //5.75%
    //Memory
    //62.6 MB
    //Beats
    //34.50%
    static int[] getAverages1(int[] nums, int k) {
        int dist = k * 2;
        //int[] arr = new int[nums.length];
        //Arrays.fill(arr, -1);
        //if (dist + 1 > nums.length) return arr;
        Queue<Integer> queue = new LinkedList<>();
        long runSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            nums[i] = -1;
            queue.offer(curr);
            runSum += i > dist ? curr - queue.poll() : curr;
            if (i >= dist) nums[i - k] = (int) (runSum / (dist + 1));
        }
        return nums;
    }
}
