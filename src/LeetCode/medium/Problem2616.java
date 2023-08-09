package LeetCode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Problem2616 {
    //https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/
    public static void main(String[] args) {
        System.out.println(minimizeMax(new int[]{3,0,5,0,0,1,6}, 3));
        System.out.println(minimizeMax(new int[]{3, 3, 5, 1, 0, 5, 6, 6}, 4));
        System.out.println(minimizeMax(new int[]{8, 9, 1, 5, 4, 3, 6, 4, 3, 7}, 4));
        System.out.println(minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2));
        System.out.println(minimizeMax(new int[]{3, 4, 2, 3, 2, 1, 2}, 3));
    }

    //nnnn
    //Runtime
    //16 ms
    //Beats
    //99.38%
    //Memory
    //58.8 MB
    //Beats
    //96.25%
    static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int len = nums.length, l = 0, r = nums[len - 1] - nums[0];
        while (l < r) {
            int mid = (l + r) / 2, k = 0;
            for (int i = 1; i < len && k < p; i++) {
                if (nums[i] - nums[i - 1] <= mid) {
                    k++;
                    i++;
                }
            }
            if (k >= p) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    static int minimizeMax5(int[] nums, int p) {
        Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            pq.offer(nums[i + 1] - nums[i]);
            if (nums[i] == nums[i + 1]) i++;
        }
        while (p > 0 && !pq.isEmpty()) {
            max = Math.max(max, pq.poll());
            p--;
        }
        return max;
    }

    static int minimizeMax4(int[] nums, int p) {
        Arrays.sort(nums);
        int temp = p;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                temp--;
                nums[i] = -1;
                nums[i - 1] = -1;
            }
            if (temp == 0) return 0;
        }
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>();
        for (int n : nums) {
            if (n != -1) {
                pq1.offer(n);
                pq2.offer(n);
            }
        }

        PriorityQueue<Integer> pqDiff1 = new PriorityQueue<>(), pqDiff2 = new PriorityQueue<>();
        while (pq1.size() > 1) {
            int prev = pq1.poll(), curr = pq1.poll();
            pqDiff1.offer(Math.abs(prev - curr));
        }
        pq2.poll();
        while (pq2.size() > 1) {
            int prev = pq2.poll(), curr = pq2.poll();
            pqDiff2.offer(Math.abs(prev - curr));
        }
        int max1 = -1, max2 = -1, count1 = 0, count2 = 0, temp2 = temp;
        while (count1++ < temp) {
            max1 = Math.max(pqDiff1.isEmpty() ? -1 : pqDiff1.poll(), max1);
        }

        while (count2++ < temp2) {
            max2 = Math.max(pqDiff2.isEmpty() ? -1 : pqDiff2.poll(), max2);
        }
        if (max1 == -1 && max2 == -1) return 0;
        if (max1 == -1) return max2;
        if (max2 == -1) return max1;
        return Math.min(max1, max2);
    }

    //Wrong Answer
    //968 / 1582 testcases passed
    static int minimizeMax3(int[] nums, int p) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                p--;
                nums[i] = -1;
                nums[i - 1] = -1;
            }
            if (p == 0) return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(), pqDiff = new PriorityQueue<>();
        for (int n : nums) if (n != -1) pq.offer(n);
        while (pq.size() > 1) {
            int prev = pq.poll(), curr = pq.poll();
            max = Math.max(Math.abs(prev - curr), max);
            p--;
            if (p == 0) return max;
        }
        return max;
    }

    static int minimizeMax2(int[] nums, int p) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        PriorityQueue<Integer> pqDiff = new PriorityQueue<>();
        for (int i = 1; i < nums.length; i += 2) pqDiff.offer(nums[i] - nums[i - 1]);

        PriorityQueue<Integer> pqDiff1 = new PriorityQueue<>();
        for (int i = 2; i < nums.length; i += 2) pqDiff1.offer(nums[i] - nums[i - 1]);
        int count = 0, res = 0;
        while (count < p) {
            count++;
            if (!pqDiff.isEmpty() && !pqDiff1.isEmpty()) {
                if (pqDiff.peek() <= pqDiff1.peek()) res = pqDiff.poll();
                else res = pqDiff1.poll();
            } else {
                if (!pqDiff.isEmpty()) res = pqDiff.poll();
                else if (!pqDiff1.isEmpty()) res = pqDiff1.poll();
                else break;
            }
        }
        return res;
    }

    //Wrong Answer
    //
    //1119 / 1582
    static int minimizeMax1(int[] nums, int p) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        PriorityQueue<Integer> pqDiff = new PriorityQueue<>();
        for (int i = 1; i < nums.length; i += 2) pqDiff.offer(nums[i] - nums[i - 1]);
        int max = 0, max1 = 0;
        for (int i = 0; i < p; i++) {
            int mem = pqDiff.poll();
            if (max < mem) max = mem;
        }
        pqDiff = new PriorityQueue<>();
        for (int i = 2; i < nums.length; i += 2) pqDiff.offer(nums[i] - nums[i - 1]);
        int size = pqDiff.size() - 1;
        for (int i = 0; i < Math.min(size, p); i++) {
            int mem = pqDiff.poll();
            if (max1 < mem) max1 = mem;
        }
        return Math.max(max, max1);
    }
}
