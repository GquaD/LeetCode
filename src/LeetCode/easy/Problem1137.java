package LeetCode.easy;

import java.util.Map;

public class Problem1137 {
    //https://leetcode.com/problems/n-th-tribonacci-number/description/
    public static void main(String[] args) {
        System.out.println(tribonacci(3));
    }
    //https://leetcode.com/problems/n-th-tribonacci-number/solutions/2893196/java-100-faster-array-as-a-cache/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.2 MB
    //Beats
    //15.48%
    static int[] cache = new int[38];
    static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (cache[n] > 0) return cache[n];
        else cache[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        return cache[n];
    }
}
