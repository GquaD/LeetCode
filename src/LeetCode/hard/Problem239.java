package LeetCode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Problem239 {
    //https://leetcode.com/problems/sliding-window-maximum/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }

    //
    //18 min
    //Runtime
    //390 ms
    //Beats
    //7.28%
    //Memory
    //55.9 MB
    //Beats
    //99.84%
    static int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        int res[] = new int[nums.length - k + 1], c = 0;
        res[c] = map.lastKey();
        for (int i = k; i < nums.length; i++) {
            int freq = map.get(nums[c]);
            if (freq > 1) map.put(nums[c], map.get(nums[c]) - 1);
            else map.remove(nums[c]);

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            res[++c] = map.lastKey();
        }
        return res;
    }

    //Time Limit Exceeded
    //37 / 51
    static int[] maxSlidingWindow1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) pq.offer(nums[i]);
        int res[] = new int[nums.length - k + 1], c = 0;
        res[c] = pq.peek();
        for (int i = k; i < nums.length; i++) {
            pq.remove(Integer.valueOf(nums[c++]));
            pq.offer(nums[i]);
            res[c] = pq.peek();
        }
        return res;
    }
}
