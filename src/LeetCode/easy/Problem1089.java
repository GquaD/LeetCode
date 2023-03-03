package LeetCode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1089 {
    //https://leetcode.com/problems/duplicate-zeros/
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,7,6,0,2,0,7};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    //10 min
    //Runtime
    //3 ms
    //Beats
    //57.15%
    //Memory
    //43.9 MB
    //Beats
    //15.88%
    static void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int n : arr) queue.offer(n);
        for (int i = 0; i < arr.length; i++) {
            int curr = queue.poll();
            if (curr == 0) {
                arr[i] = 0;
                if (++i < arr.length) arr[i] = 0;
            } else arr[i] = curr;
        }
    }
}
