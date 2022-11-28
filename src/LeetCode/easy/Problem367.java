package LeetCode.easy;

import java.util.Arrays;

public class Problem367 {
    //https://leetcode.com/problems/valid-perfect-square/
    public static void main(String[] args) {

    }
    //https://leetcode.com/problems/valid-perfect-square/solutions/2855745/java-5ms-solution/
    //Runtime
    //5 ms
    //Beats
    //10.27%
    //Memory
    //40.7 MB
    //Beats
    //54.93%
    static int[] squares = fillSquares();

    private static int[] fillSquares() {
        int[] res = new int[46340 + 1];
        for (int i = 1; i <= res.length; i++) {
            res[i] = i * i;
        }
        return res;
    }

    static boolean isPerfectSquare(int num) {
        return Arrays.binarySearch(squares, num) > 0;
    }
}
