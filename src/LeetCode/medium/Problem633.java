package LeetCode.medium;

import java.util.Arrays;

public class Problem633 {
    //https://leetcode.com/problems/sum-of-square-numbers/
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(1));
        System.out.println(judgeSquareSum(18));
        System.out.println(judgeSquareSum(19));
    }

    //https://leetcode.com/problems/sum-of-square-numbers/solutions/3572881/java-2-line-solution/
    //40 min
    //Runtime
    //27 ms
    //Beats
    //13.59%
    //Memory
    //39.8 MB
    //Beats
    //31.99%
    static boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c); i++) if (Math.sqrt(c - (i * i)) % 1 == 0) return true;
        return false;
    }

    //Runtime
    //26 ms
    //Beats
    //13.59%
    //Memory
    //40.2 MB
    //Beats
    //5.16%
    static boolean judgeSquareSum2(int c) {
        int sqrt = (int) Math.sqrt(c);
        for (int i = 0; i <= sqrt; i++) {
            int a2 = i * i, b2 = c - a2;
            if (Math.sqrt(b2) % 1 == 0) return true;
        }
        return false;
    }

    //Runtime
    //33 ms
    //Beats
    //12.98%
    //Memory
    //39.7 MB
    //Beats
    //31.99%
    static int[] arr;

    private static int[] generateSquares() {
        int[] r = new int[46342];
        for (int i = 0; i < r.length; i++) r[i] = i * i;
        return r;
    }

    static boolean judgeSquareSum1(int c) {
        if (arr == null)
            arr = generateSquares();
        int sqrt = (int) Math.sqrt(c);
        for (int i = 0; i <= sqrt; i++) {
            int a2 = arr[i], b2 = c - a2;
            if (Arrays.binarySearch(arr, b2) > -1) return true;
        }
        return false;
    }
}
