package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem3866 {
    //2min

    //Runtime
    //2
    //ms
    //Beats
    //64.48%
    //Memory
    //46.30
    //MB
    //Beats
    //62.14%
    public int firstUniqueEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) if (n % 2 == 0) map.put(n, map.getOrDefault(n, 0) + 1);
        for (int n: nums) {
            Integer f = map.get(n);
            if (f != null && f == 1) return n;
        }
        return -1;
    }
}
