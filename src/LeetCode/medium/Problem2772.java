package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem2772 {
    //https://leetcode.com/problems/apply-operations-to-make-all-array-elements-equal-to-zero/
    public static void main(String[] args) {
        System.out.println(checkArray(new int[]{2,2,3,1,1,0}, 3));
        System.out.println(checkArray(new int[]{2,2,3,1,1,0}, 6));
        System.out.println(checkArray(new int[]{60,72,87,89,63,52,64,62,31,37,57,83,98,94,92,77,94,91,87,100,91,91,50,26}, 4));
        System.out.println(checkArray(new int[]{1,3,1,1}, 2));
    }

    //nnnn
    //sliding window: cur saves the sum last k - 1 elements after applying operation
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //58.7 MB
    //Beats
    //14.53%
    static boolean checkArray(int[] nums, int k) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur > nums[i]) return false;
            nums[i] -= cur;
            cur += nums[i];
            if (i >= k - 1) cur -= nums[i - k + 1];
        }
        return cur == 0;
    }

    static boolean checkArray2(int[] nums, int k) {
        if (k == 1) return true;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) pq.offer(nums[i]);
        for (int i = k; i < nums.length; i++) {
            int a = pq.poll(), b = pq.poll();
            pq.offer(b - a);
            pq.offer(nums[i]);
            nums[i - k] = 0;
        }
        int left = pq.poll();
        while (!pq.isEmpty()) {
            if (left != pq.poll()) return false;
        }
        return true;
    }

    //Time Limit Exceeded
    //1021 / 1024
    static boolean checkArray1(int[] nums, int k) {
        for (int i = 0; i <= nums.length - k; i++) {
            int min = 1_000_001, count = 0;
            for (int j = i; j < i + k; j++) {
                if (nums[j] == 0) break;
                min = Math.min(nums[j], min);
                count++;
            }
            if (count == k) {
                for (int j = i; j < i + k; j++) {
                    nums[j] -= min;
                }
            }
        }
        for (int n : nums) if (n != 0) return false;
        return true;
    }
}
