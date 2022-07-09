package LeetCode;

import java.util.HashMap;

public class Problem70 {
    //https://leetcode.com/problems/climbing-stairs/submissions/
    public static void main(String[] args) {

    }
    //Runtime: 1 ms, faster than 11.20% of Java online submissions for Climbing Stairs.
    //Memory Usage: 40.7 MB, less than 65.44% of Java online submissions for Climbing Stairs.
    public int climbStairs(int n) {
        return climbStairsLogic(n, 1);
    }

    HashMap<Integer, Integer> cache = new HashMap<>();
    public int climbStairsLogic(int n, int stepSize) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n == 1) {
            cache.put(1, 1);
            return 1;
        }
        if (n == 2) {
            cache.put(2, 2);
            return 2;
        }
        if (n == 3) {
            cache.put(3, 3);
            return 3;
        }
        int result = 0;

        if (stepSize == 1) {
            result += climbStairsLogic(n - 1, 2) + climbStairsLogic(n - 2, 2);
        } else if (stepSize == 2) {
            result += climbStairsLogic(n - 1, 1) + climbStairsLogic(n - 2, 1);
        }
        cache.put(n, result);
        return cache.get(n);
    }
}
