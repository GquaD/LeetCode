package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem3185 {
    //https://leetcode.com/problems/count-pairs-that-form-a-complete-day-ii
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-pairs-that-form-a-complete-day-ii/solutions/5327007/java-o-n-solution-from-31ms-to-4ms-optimized/
    //Runtime
    //4
    //ms
    //Beats
    //33.33%
    //Analyze Complexity
    //Memory
    //97.40
    //MB
    //Beats
    //66.67%
    long countCompleteDayPairs(int[] hours) {
        long[] arr = new long[24];
        for (int i = 0; i < hours.length; i++) {
            hours[i] = hours[i] % 24;
            arr[hours[i]]++;
        }
        long res = 0;
        for (int i = 0; i < 24; i++) {
            long f = arr[i];
            if (i == 0 || i == 12) {
                res += (f * (f - 1L)) / 2L;
            } else {
                if (arr[24 - i] > 0) {
                    long f2 = arr[24 - i];
                    res += f * f2;
                    arr[i] = 0;
                }
            }
        }
        return res;
    }


    //10-15min
    //Runtime
    //31
    //ms
    //Beats
    //33.33%
    //Memory
    //94.70
    //MB
    //Beats
    //100.00%
    long countCompleteDayPairs1(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            hours[i] = hours[i] % 24;
            map.put(hours[i], map.getOrDefault(hours[i], 0) + 1);
        }
        long res = 0;
        for (int k : map.keySet()) {
            if (k == 0 || k == 12) {
                long f = (long) map.get(k);
                res += (f * (f - 1L)) / 2L;
            } else {
                if (map.containsKey(24 - k)) {
                    long f1 = (long) map.get(k), f2 = (long) map.get(24 - k);
                    res += f1 * f2;
                    map.put(k, 0);
                }
            }
        }
        return res;
    }
}
