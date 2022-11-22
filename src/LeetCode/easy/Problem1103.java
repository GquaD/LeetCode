package LeetCode.easy;

import java.util.Arrays;

public class Problem1103 {
    //https://leetcode.com/problems/distribute-candies-to-people/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(7, 4)));
        System.out.println(Arrays.toString(distributeCandies(10, 3)));
        System.out.println(Arrays.toString(distributeCandies(36, 4)));
        System.out.println(Arrays.toString(distributeCandies(37, 4)));
    }

    //https://leetcode.com/problems/distribute-candies-to-people/solutions/2838299/java-brute-force-solution-explained/
    //Runtime
    //2 ms
    //Beats
    //76.35%
    //Memory
    //39.8 MB
    //Beats
    //93.16%
    static int[] distributeCandies(int c, int n) {
        int[] arr = new int[n];
        int idx = 0;
        while (c > 0) {
            arr[idx++ % n] += Math.min(idx, c);
            c = Math.max(c - idx, 0);
        }
        return arr;
    }
}
