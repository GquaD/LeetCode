package LeetCode.medium;

import java.util.Arrays;

public class Problem400 {
    //https://leetcode.com/problems/nth-digit/
    public static void main(String[] args) {
        System.out.println(findNthDigit(3));
        System.out.println(findNthDigit(11));
        System.out.println(findNthDigit(100));
        System.out.println(findNthDigit(1000));
    }

    //https://leetcode.com/problems/nth-digit/solutions/6186102/java-o1-100-faster-solution-by-tbekpro-t20j/
    //15-20min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.34
    //MB
    //Beats
    //59.91%

    private static final int[] nine = new int[] {0, 9, 90, 900, 9_000, 90_000, 900_000, 9_000_000, 90_000_000, 900_000_000};

    public static int findNthDigit(int n) {
        int i = 1, k = n, start = 1;
        long q = i * nine[i];
        while (i < nine.length && q < k) {
            k -= i * nine[i];
            start += nine[i];
            i++;
            q = i * 1L * nine[i];
        }
        int pos = k / i;
        if (k % i == 0) {
            String s = (start + pos - 1) + "";
            return s.charAt(s.length() - 1) - '0';
        } else {
            String s = (start + pos) + "";
            return s.charAt(k % i - 1) - '0';
        }
    }
//    static int findNthDigit(int n) {
//        long[] limits = new long[10];
//        long sum = 0, prev = 1;
//        int idx = 0, digits = 1;
//        for (long i = 10; i <= 10_000_000_000L; i*=10) {
//            sum += (i - prev) * digits++;
//            limits[idx++] = sum;
//            prev = i;
//        }
//        int index = Arrays.binarySearch(limits, n);
//        if (index < 0) index = -index - 1;
//        int t = n;
//        for (int i = 0; i < index; i++) {
//            n -= limits[i];
//        }
//        int ith = n;
//        n /= index;
//        int start = 1;
//        for (int i = 1; i < idx; i++) {
//            start *= 10;
//        }
//        n = start + (n - 1);
//        return 1;
//    }
//
//    static StringBuilder sb;
//
//    static int findNthDigit1(int n) {
//        if (sb == null) {
//            sb = new StringBuilder();
//            int c = 1;
//            while (sb.length() < 10_000) sb.append(c++);
//        }
//        return sb.charAt(n - 1) - '0';
//    }
}
