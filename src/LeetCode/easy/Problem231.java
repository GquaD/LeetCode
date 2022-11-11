package LeetCode.easy;

import java.util.Arrays;
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

    //https://leetcode.com/problems/power-of-two/solutions/2802701/java-7-solutions-oh-my-gosh/
    //https://leetcode.com/problems/power-of-two/solutions/2802677/java-3-lines-solution/
    //Runtime
    //3 ms
    //Beats
    //14.6%
    //Memory
    //41.8 MB
    //Beats
    //16.24%
    static boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        if (Integer.toBinaryString(n).substring(1).contains("1")) return false;
        return true;
    }

    //Runtime
    //3 ms
    //Beats
    //14.6%
    //Memory
    //41.8 MB
    //Beats
    //16.24%
    static boolean isPowerOfTwo4(int n) {
        if (n < 1) return false;
        char[] arr = Integer.toBinaryString(n).toCharArray();
        if (arr[0] != '1') return false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '1') return false;
        }
        return true;
    }


    //Runtime
    //2 ms
    //Beats
    //82.54%
    //Memory
    //41.5 MB
    //Beats
    //37.12%
    static int[] vals = new int[31];
    static boolean isPowerOfTwo3(int n) {
        if (n < 1) return false;
        if (vals[0] == 0) {
            fillVals();
        }
        for (int v : vals) {
            if (n == v) return true;
        }
        return false;
    }

    private static void fillVals() {
        for (int i = 0; i < vals.length; i++) {
            vals[i] = (int) Math.pow(2, i);
        }
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
    static boolean isPowerOfTwo2(int n) {
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

    static boolean isPowerOfTwo1(int n) {
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
