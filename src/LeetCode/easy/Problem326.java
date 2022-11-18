package LeetCode.easy;

import java.util.Arrays;

public class Problem326 {
    //https://leetcode.com/problems/power-of-three/
    public static void main(String[] args) {

    }

    //Runtime
    //30 ms
    //Beats
    //15.2%
    //Memory
    //46 MB
    //Beats
    //83.47%
    static int[] vals = new int[]{1,3,9,27,81,243,729,2187,6561,19683,59049,177147,531441,1594323,4782969,14348907,43046721,129140163,387420489,1162261467};
    static boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        return Arrays.binarySearch(vals,n) >= 0;
    }

    //https://leetcode.com/problems/power-of-three/solutions/2826496/java-1-line-solution/
    //Runtime
    //25 ms
    //Beats
    //73.76%
    //Memory
    //46.9 MB
    //Beats
    //75.33%
    //no loops or recursion
    static boolean isPowerOfThree1(int n) {
        return n == 1 || n == 3 || n == 9 || n == 27 || n == 81 || n == 243 || n == 729 || n == 2187 || n == 6561 || n == 19683 || n == 59049 || n == 177147 || n == 531441 || n == 1594323 || n == 4782969 || n == 14348907 || n == 43046721 || n == 129140163 || n == 387420489 || n == 1162261467;
    }
}
