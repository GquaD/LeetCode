package LeetCode.Recursion;

import java.util.HashMap;

public class StairsClimbing {
    public static void main(String[] args) {
        System.out.println("Combinations for steps of 1: " + climbStairs(1));
        System.out.println("Combinations for steps of 2: " + climbStairs(2));
        System.out.println("Combinations for steps of 3: " + climbStairs(3));
        System.out.println("Combinations for steps of 4: " + climbStairs(4));
        System.out.println("Combinations for steps of 5: " + climbStairs(5));
        System.out.println("Combinations for steps of 6: " + climbStairs(6));
        System.out.println("Combinations for steps of 7: " + climbStairs(7));
        System.out.println("Combinations for steps of 8: " + climbStairs(8));
        System.out.println("Combinations for steps of 9: " + climbStairs(9));
        System.out.println("Combinations for steps of 10: " + climbStairs(10));
        System.out.println("Combinations for steps of 44: " + climbStairs(44));
    }

    static HashMap<Integer, Integer> cache = new HashMap<>();

    public static int climbStairs(int n) {
        return climbStairsLogic(n, 1);
    }

    public static int climbStairsLogic(int n, int stepSize) {
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

