package LeetCode.medium;

import java.util.*;

public class Problem456 {
    //https://leetcode.com/problems/132-pattern/
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{3,1,4,2}));
        System.out.println(find132pattern(new int[]{3, 5, 0, 3, 4}));
    }

    //nnnn
    //Runtime
    //38 ms
    //Beats
    //41.75%
    //Memory
    //61.3 MB
    //Beats
    //68.58%
    static boolean find132pattern(int[] nums) {
        int three = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = nums[i];
            if (curr < three) return true;
            else while (!stack.isEmpty() && curr > stack.peek()) three = stack.pop();
            stack.push(curr);
        }
        return false;
    }

    //TLE on 101 / 102
    static boolean find132pattern2(int[] nums) {
        int[] arr = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        Set<int[]> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (arr[0] > curr) {
                arr[0] = curr;
                arr[1] = Integer.MIN_VALUE;
            } else if (arr[1] < curr) {
                arr[1] = curr;
            }
            if (arr[0] != Integer.MAX_VALUE && arr[1] != Integer.MIN_VALUE)
                list.add(Arrays.copyOf(arr, 2));
            if (list.size() > 0) {
                for (int[] pair : list) {
                    if (curr > pair[0] && curr < pair[1]) return true;
                }
            }
        }
        return false;
    }

    //wrong on 58 / 102
    static boolean find132pattern1(int[] nums) {
        boolean increasing = false, decreasing = false;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i], prev = nums[i - 1];
            if (curr > prev) increasing = true;
            else if (prev > curr) decreasing = true;
            if (increasing && decreasing) return true;
        }
        return increasing && decreasing;
    }
}
