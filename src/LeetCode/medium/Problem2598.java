package LeetCode.medium;

import java.util.*;

public class Problem2598 {
    //https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/
    public static void main(String[] args) {
        System.out.println(findSmallestInteger(new int[]{0, 0, 0}, 1));
        System.out.println(findSmallestInteger(new int[]{3, 2, 3, 1, 0, 1, 4, 2, 3, 1, 4, 1, 3}, 5));
    }

    //https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/solutions/3338078/java-using-only-given-array/
    //10 min
    //optimized previous solutions
    //Runtime
    //59 ms
    //Beats
    //49.62%
    //Memory
    //59.1 MB
    //Beats
    //66.8%
    static int findSmallestInteger(int[] nums, int value) {
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int mod = n % value;
            if (mod < 0) mod += value;
            nums[i] = mod;
        }

        Arrays.sort(nums);
        int mem = -1, count = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr != mem) {
                count = 0;
                mem = curr;
            } else {
                count++;
            }
            nums[i] = curr + count * value;
        }

        Arrays.sort(nums);

        count = 0;
        for (int n : nums) if (n != count++) return count - 1;
        return count;
    }

    //
    //30 min
    //Runtime
    //96 ms
    //Beats
    //17.38%
    //Memory
    //65.3 MB
    //Beats
    //12.17%
    static int findSmallestInteger3(int[] nums, int value) {
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int mod = n % value;
            if (mod < 0) mod += value;
            nums[i] = mod;
        }
        Map<Integer, Integer> mapCount = new HashMap<>();
        for (int n : nums) {
            if (!mapCount.containsKey(n)) mapCount.put(n, 1);
            else mapCount.put(n, mapCount.get(n) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int key : mapCount.keySet()) {
            int freq = mapCount.get(key);
            for (int i = 0; i < freq; i++) {
                set.add(key + i * value);
            }
        }

        int count = 0;
        for (int i = 0; i < set.size(); i++) if (!set.contains(count++)) return count - 1;
        return count;
    }

    static int findSmallestInteger2(int[] nums, int value) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (n == 0 && !set.contains(0)) {
                set.add(0);
            } else {
                int mod = n == 0 ? value : n % value;
                if (mod < 0) mod += value;
                while (!set.add(mod)) mod += value;
            }
        }
        int count = 0;
        for (int i = 0; i < set.size(); i++) if (!set.contains(count++)) return count - 1;
        return count;
    }

    static int findSmallestInteger1(int[] nums, int value) {
        boolean[] ints = new boolean[value];
        for (int n : nums) {
            int mod = Math.abs(n % value);
            ints[mod] = true;
        }
        for (int i = 0; i < ints.length; i++) if (!ints[i]) return i;
        return value * 2;
    }

}
