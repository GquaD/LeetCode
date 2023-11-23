package LeetCode.medium;

import java.util.*;

public class Problem1798 {
    //https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/
    public static void main(String[] args) {
        System.out.println(getMaximumConsecutive(new int[]{1,4,10,3,1}));
        System.out.println(getMaximumConsecutive(new int[]{1,1,1,4}));
        System.out.println(getMaximumConsecutive(new int[]{2,3,4}));
        System.out.println(getMaximumConsecutive(new int[]{1,3}));
        System.out.println(getMaximumConsecutive(new int[]{4}));
    }

    //1hour
    //Runtime
    //17 ms
    //Beats
    //93.75%
    //Memory
    //52.4 MB
    //Beats
    //16.67%
    static int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        if (coins[0] != 1) return 1;
        int sum = 1;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= sum) sum += coins[i];
            else break;
        }
        return sum;
    }

    static int getMaximumConsecutive3(int[] coins) {
        Arrays.sort(coins);
        int sum = 0, count = 1;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == count) {
                sum += count;
            } else if (sum + coins[i] == count || sum >= count) {
                sum += coins[i];
            } else break;
            count++;
        }
        return Math.max(sum + 1, count);
    }

    //Wrong Answer
    //68 / 72 testcases passed
    static int getMaximumConsecutive2(int[] coins) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0, max = 0;
        for (int n : coins) {
            sum += n;
            map.put(n, map.getOrDefault(n, 0) + 1);
            max = Math.max(max, n);
        }
        if (map.containsKey(1)) {
            if (map.containsKey(2) || map.get(1) > 1) {
                if (sum - max < max) return sum - max;
                return sum + 1;
            }
            return 2;
        } else {
            return 1;
        }
    }

    //Time Limit Exceeded
    //36 / 72
    static int getMaximumConsecutive1(int[] coins) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int n : coins) {
            sum += n;
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        if (map.containsKey(1)) {
            count++;
            if (map.containsKey(2) || map.get(1) > 1) {
                if (!map.containsKey(2)) map.put(2, 1);
                count++;
                return sum + 1;
            }
        } else {
            return count + 1;
        }

        for (int i = 3; i <= sum; i++) {
            if (map.containsKey(i - 1) && sum >= i) {
                if (!map.containsKey(i))
                    map.put(i, 1);
                count++;
            }
            else break;
        }
        return count + 1;
    }
}
