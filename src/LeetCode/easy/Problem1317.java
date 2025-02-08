package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem1317 {
    //https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/solutions/6393687/java-1ms-solution-by-tbekpro-lhwh/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //46.83%
    //Analyze Complexity
    //Memory
    //41.55
    //MB
    //Beats
    //32.23%
    private Set<Integer> set;
    public int[] getNoZeroIntegers(int n) {
        if (set == null) {
            set = new HashSet<>();
        }
        for (int i = 1; i <= n / 2; i++) {
            int j = n - i;
            if (set.contains(i) && set.contains(j)) {
                return new int[]{i, j};
            }
            boolean a = isNonZero(i), b = isNonZero(j);
            if (a) set.add(i);
            if (b) set.add(j);
            if (a && b) return new int[]{i, j};
        }
        return new int[]{};
    }

    private boolean isNonZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) return false;
            n /= 10;
        }
        return true;
    }
}
