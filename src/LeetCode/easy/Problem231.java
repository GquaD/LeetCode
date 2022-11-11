package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem231 {
    //https://leetcode.com/problems/power-of-two/

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-2));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(4096));
    }


    //Runtime
    //3 ms
    //Beats
    //14.6%
    //Memory
    //41.6 MB
    //Beats
    //22.16%
    static Set<Integer> set = new HashSet<>();
    static boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        if (set.size() == 0) {
            fillSet();
        }
        if (set.contains(n)) return true;
        return false;
    }

    private static void fillSet() {
        int mult = 1;
        while (mult > 0) {
            set.add(mult);
            mult *= 2;
        }
    }

    //5 mins
    //Runtime
    //2 ms
    //Beats
    //82.54%
    //Memory
    //41.1 MB
    //Beats
    //61.66%
    static int[] values = new int[32];

    static boolean isPowerOfTwo2(int n) {
        if (n < 1) return false;
        if (values[0] == 0) {
            fillValues();
        }
        for (int v : values) {
            if (n == v) return true;
        }
        return false;
    }

    private static void fillValues() {
        int mult = 1;
        for (int i = 0; i < values.length; i++) {
            values[i] = mult;
            mult *= 2;
        }
    }
}
