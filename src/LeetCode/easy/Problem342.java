package LeetCode.easy;

import java.util.Arrays;

public class Problem342 {
    //https://leetcode.com/problems/power-of-four/



    //Runtime
    //2 ms
    //Beats
    //79.78%
    //Memory
    //41.2 MB
    //Beats
    //53.12%
    static int[] p = new int[]{1,4,16,64,256,1024,4096,16384,65536,262144,1048576,4194304,16777216,67108864,268435456,1073741824};
    public boolean isPowerOfFour2(int n) {
        if (n < 1) return false;
        return Arrays.binarySearch(p, n) >= 0;
    }

    //https://leetcode.com/problems/power-of-four/solutions/2826535/java-1-line-solution-no-loop-no-recursion/
    //Runtime
    //2 ms
    //Beats
    //79.78%
    //Memory
    //40.9 MB
    //Beats
    //75.25%
    public boolean isPowerOfFour1(int n) {
        return n == 1 || n == 4 || n == 16 || n == 64 || n == 256 || n == 1024 || n == 4096 || n == 16384 || n == 65536 || n == 262144 || n == 1048576 || n == 4194304 || n == 16777216 || n == 67108864 || n == 268435456 || n == 1073741824;
    }


}
