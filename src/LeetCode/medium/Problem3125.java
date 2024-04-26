package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem3125 {
    //https://leetcode.com/problems/maximum-number-that-makes-result-of-bitwise-and-zero/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-number-that-makes-result-of-bitwise-and-zero/solutions/5075193/java-100-faster-solution/
    //5min
    //Runtime
    //5
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //43.63
    //MB
    //Beats
    //100.00%
    //of users with Java
    static List<Long> list;

    public static long maxNumber(long n) {
        if (list == null) {
            list = new ArrayList<>();
            long pow = 1, max = (long) Math.pow(10, 15);
            while (pow <= max) {
                list.add(pow);
                pow *= 2;
            }
        }

        int idx = Collections.binarySearch(list, n);
        if (idx < 0) idx = -idx - 2;
        if (idx < 0) idx = 0;
        return list.get(idx) - 1;
    }
}
