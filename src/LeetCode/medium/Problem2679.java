package LeetCode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2679 {
    //https://leetcode.com/problems/sum-in-a-matrix/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/sum-in-a-matrix/solutions/3552781/java-from-108ms-to-17ms/
    //Runtime
    //17 ms
    //Beats
    //37.62%
    //Memory
    //57.1 MB
    //Beats
    //98.68%
    static int matrixSum(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
            makeReverse(nums[i]);
        }
        int max = 0, sum = 0;
        for (int i = 0; i < nums[0].length; i++) {
            for (int j = 0; j < nums.length; j++) if (max < nums[j][i]) max = nums[j][i];
            sum += max;
            max = 0;
        }
        return sum;
    }

    private static void makeReverse(int[] num) {
        for (int i = 0; i < num.length / 2; i++) {
            int temp = num[i];
            num[i] = num[num.length - 1 - i];
            num[num.length - 1 - i] = temp;
        }
    }

    //5 min
    //Runtime
    //108 ms
    //Beats
    //19.37%
    //Memory
    //57.1 MB
    //Beats
    //98.33%
    static int matrixSum1(int[][] nums) {
        PriorityQueue<Integer> arr[] = new PriorityQueue[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new PriorityQueue<>(Comparator.reverseOrder());
            for (int j = 0; j < nums[i].length; j++) arr[i].offer(nums[i][j]);
        }
        int localMax = 0, sum = 0;
        while (!arr[0].isEmpty()) {
            for (int i = 0; i < arr.length; i++) {
                int curr = arr[i].poll();
                if (localMax < curr) localMax = curr;
            }
            sum += localMax;
            localMax = 0;
        }
        return sum;
    }
}
