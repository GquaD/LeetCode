package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem3012 {
    //https://leetcode.com/problems/minimize-length-of-array-using-operations/
    public static void main(String[] args) {
        System.out.println(1 == minimumArrayLength(new int[]{5, 2, 2, 2, 9, 10}));
        System.out.println(1 == minimumArrayLength(new int[]{1, 5, 5, 5, 5}));
        System.out.println(1 == minimumArrayLength(new int[]{1, 4, 3, 1}));
        System.out.println(2 == minimumArrayLength(new int[]{5, 5, 5, 10, 5}));
        System.out.println(1 == minimumArrayLength(new int[]{2, 3, 4}));
    }

    //nnnnn
    //2 hours
    //Runtime
    //2
    //ms
    //Beats
    //97.35%
    //of users with Java
    //Memory
    //58.33
    //MB
    //Beats
    //79.97%
    //of users with Java
    static int minimumArrayLength(int[] nums) {
        int min = nums[0], count = 0;
        for (int n : nums) min = Math.min(min, n);
        for (int n : nums) if (n % min > 0) return 1;
        for (int n : nums) if (n == min) count++;
        return (count + 1) / 2;
    }

    static int minimumArrayLength2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(), pq1 = new PriorityQueue<>();
        for (int n : nums) pq.offer(n);
        int score = 0;
        while (pq.size() > 1) {
            int a = pq.poll(), b = 1, mod = 0;
            while (pq.size() > 0) {
                b = pq.poll();
                mod = a % b;
                if (mod != 0) break;
                pq1.offer(b);
            }
            //int b = pq.poll(), mod = a % b;
            if (mod == 0) {
                score++;
            } else {
                pq1.offer(mod);
            }
            while (pq.size() > 0) pq1.offer(pq.poll());

            PriorityQueue<Integer> temp = pq;
            pq = pq1;
            temp.clear();
            pq1 = temp;
        }
        if (pq.size() == 1) score++;
        return score;
    }


    static int minimumArrayLength1(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>(), l = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            int a = nums[i], b = nums[nums.length - i - 1], mod = a % b;
            if (mod == 0) {
                count++;
            } else {
                list.add(mod);
            }
        }
        if (nums.length % 2 == 1) list.add(nums[nums.length / 2]);

        while (!list.isEmpty()) {
            for (int i = 0; i < list.size() / 2; i++) {
                int a = list.get(i), b = list.get(list.size() - i - 1), mod = a % b;
                if (mod == 0) {
                    count++;
                } else {
                    l.add(mod);
                }
            }
            if (list.size() % 2 == 1) l.add(list.get(list.size() / 2));
            if (l.size() > 1) {
                list = l;
                l = new ArrayList<>();
            } else {
                if (l.size() == 1) {
                    count++;
                }
                list.clear();
            }
        }
        return count;
    }
}
