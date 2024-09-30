package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1497 {
    //https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
    public static void main(String[] args) {

    }

    //
    //30min
    //Runtime
    //320
    //ms
    //Beats
    //5.21%
    //Analyze Complexity
    //Memory
    //55.36
    //MB
    //Beats
    //97.50%
    public boolean canArrange(int[] arr, int k) {
        // remainder -> count
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            int rem = ((n % k) + k) % k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        for (int n : arr) {
            int rem = ((n % k) + k) % k;

            if (rem == 0) {
                if (map.get(rem) % 2 != 0)
                    return false;
            } else {
                Integer c1 = map.get(rem), c2 = map.get(k - rem);
                if ((c1 == null || c2 == null) || c1.intValue() != c2.intValue())
                    return false;
            }
        }
        return true;
    }

    static boolean canArrange1(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) map.put(n, map.getOrDefault(n, 0) + 1);
        for (int key : map.keySet()) {
            if (map.get(key) != map.get(k - key)) ;
        }
        return true;
    }
}
