package LeetCode.medium;

import java.util.*;

public class Problem2592 {
    //https://leetcode.com/problems/maximize-greatness-of-an-array/
    public static void main(String[] args) {
        System.out.println(maximizeGreatness(new int[]{1,3,5,2,1,3,1}));
    }

    //https://leetcode.com/problems/maximize-greatness-of-an-array/solutions/3327324/java-solution-using-queue/
    //Runtime
    //23 ms
    //Beats
    //31.51%
    //Memory
    //58.3 MB
    //Beats
    //78.52%
    static int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0 ; i--) {
            if (queue.peek() > nums[i]) queue.poll();
            queue.offer(nums[i]);
        }
        return nums.length - queue.size();
    }

    //Runtime
    //24 ms
    //Beats
    //31.23%
    //Memory
    //58.3 MB
    //Beats
    //78.52%
    static int maximizeGreatness2(int[] nums) {
        Arrays.sort(nums);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(nums[nums.length - 1]);
        int count = 0;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            int curr = nums[i];
            if (queue.peek() > curr) {
                count++;
                queue.poll();
            }
            queue.offer(curr);
        }
        return count;
    }

    //20 min
    //Runtime
    //181 ms
    //Beats
    //19.95%
    //Memory
    //58.4 MB
    //Beats
    //78.52%
    static int maximizeGreatness1(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : nums) pq.offer(n);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(pq.poll());
        int count = 0;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if (queue.peek() > curr) {
                count++;
                queue.poll();
            }
            queue.offer(curr);
        }
        return count;
    }
}
