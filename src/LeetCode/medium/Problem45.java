package LeetCode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Problem45 {
    //https://leetcode.com/problems/jump-game-ii/description/
    public static void main(String[] args) {
        System.out.println(jump(new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(jump(new int[]{9, 8, 2, 2, 0, 2, 2, 0, 4, 1, 5, 7, 9, 6, 6, 0, 6, 5, 0, 5}));
        System.out.println(jump(new int[]{1, 2}));
        System.out.println(jump(new int[]{2, 1}));
        System.out.println(jump(new int[]{2}));
        System.out.println(jump(new int[]{0}));
    }

    //https://leetcode.com/problems/jump-game-ii/solutions/3085571/java-3-ms-solution/
    //1 hour
    //Runtime
    //3 ms
    //Beats
    //57.18%
    //Memory
    //48.8 MB
    //Beats
    //35.55%
    static int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int curr = nums[0];
        if (curr >= nums.length - 1) return 1;
        int count = 0, idx = 0;
        while (idx < nums.length - 1) {
            int maxReach = nums[idx] + idx, maxIdx = idx, tempSum = maxReach;
            for (int i = idx + 1; i <= Math.min(nums.length - 1, idx + nums[idx]); i++) {
                tempSum--;
                if (nums[i] == 0) continue;
                int tempReach = nums[i] + i;
                if (maxReach < tempReach) {
                    maxReach = tempReach;
                    maxIdx = i;
                }
            }
            count++;
            if (maxReach >= nums.length - 1) {
                count++;
                break;
            }
            idx = maxIdx;
        }
        return count;
    }

    static int jump5(int[] nums) {
        if (nums.length == 1) return 0;
        int curr = nums[0];
        if (curr >= nums.length - 1) return 1;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            curr--;
            if (curr < nums[i]) {
                curr = nums[i];
                count++;
            }
            if (curr >= nums.length - 1) break;
        }
        return count;
    }


    static int jump6(int[] nums) {
        int steps = nums.length;
        if (nums.length == 1) return 0;
        //for (int i = 0; i < nums.length - 1; i++) {
        int currentNum = nums[0], position = 0, countSteps = 1;
        if (currentNum >= nums.length - 1) return countSteps;
        while (position < nums.length) {
            int tempMax = -1, tempMaxIdx = position;
            for (int j = position + 1; j <= position + currentNum && j < nums.length; j++) {
                if (nums[j] + j >= nums.length - 1) {
                    return ++countSteps;
                }
                if (tempMax <= nums[j]) {
                    tempMax = nums[j];
                    tempMaxIdx = j;
                }
            }
            if (tempMaxIdx != position) {
                countSteps++;
            }
            currentNum = tempMax;
            position = tempMaxIdx;

            if (position + currentNum >= nums.length - 1) {
                break;
            }
        }
        if (steps > countSteps) {
            steps = countSteps;
        }
        // }
        return steps;
    }

    //good but not correct
    static int jump2(int[] nums) {
        int position = nums.length - 1, minSteps = 0;
        while (position > 0) {
            int tempMaxJumpReachingThePosition = -1;
            int tempPos = position;
            for (int i = position - 1; i >= 0; i--) {
                if (tempMaxJumpReachingThePosition <= nums[i] && position - i <= nums[i]) {
                    tempMaxJumpReachingThePosition = nums[i];
                    tempPos = i;
                }
            }
            position = tempPos;
            minSteps++;
        }
        return minSteps;
    }

    //time limit exceeded on 73/109
    static Map<Integer, Integer> map;
    static int minSteps;

    static int jump1(int[] nums) {
        map = new HashMap<>();
        minSteps = nums.length;
        findMinJumpsRecursively(nums, 0, 0);
        return minSteps;
    }

    private static void findMinJumpsRecursively(int[] nums, int position, int steps) {
        if (position >= nums.length - 1) {
            if (minSteps > steps) {
                minSteps = steps;
            }
            return;
        }
        Integer stepsNumberInCache = map.get(position);
        if (stepsNumberInCache != null) {
            if (stepsNumberInCache < steps) return;
            if (stepsNumberInCache > steps) {
                map.put(position, steps);
            }
        }
        int distance = 0;

        if (position < nums.length) {
            distance = nums[position];
        }

        for (int i = 1; i <= distance; i++) {
            findMinJumpsRecursively(nums, position + i, steps + 1);
        }
    }
}
