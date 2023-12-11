package LeetCode.medium;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Problem560 {
    //https://leetcode.com/problems/subarray-sum-equals-k/description/
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{3, 4, 7, -2, 2, 1, 4, 2}, 7));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{2, 2, 4, 4, 6, 8, 5, 8}, 4));
        System.out.println(subarraySum(new int[]{1, 2, 1, 2, 1}, 3));
        System.out.println(subarraySum(new int[]{2, 3, 6, 5, 4, 1, 10}, 5));
    }


    //nnn
    //Runtime
    //22 ms
    //Beats
    //88.83%
    //Memory
    //47.5 MB
    //Beats
    //5.56%
    static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    static int subarraySum1(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] == k) {
                count++;
                queue.add(nums[i]);
                sum += nums[i];
            } else if (sum + nums[i] > k) {
                sum += nums[i];
                queue.add(nums[i]);
                while (sum > k) {
                    int t = queue.poll();
                    sum -= t;
                }
                if (sum == k) count++;
            } else {
                sum += nums[i];
                queue.add(nums[i]);
            }
        }
        return count;
    }
}
