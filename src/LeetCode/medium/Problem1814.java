package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1814 {
    //https://leetcode.com/problems/count-nice-pairs-in-an-array/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-nice-pairs-in-an-array/solutions/5931358/java-hashmap-o-nloga-solution/
    //20min
    //Runtime
    //86
    //ms
    //Beats
    //5.15%
    //Analyze Complexity
    //Memory
    //56.62
    //MB
    //Beats
    //85.17%
    StringBuilder sb;
    public int countNicePairs(int[] nums) {
        sb = new StringBuilder();
        //diff of n and rev(n) -> freq
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int diff = n - rev(n);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        long res = 0;
        for (int k : map.keySet()) {
            int freq = map.get(k);
            res += (freq * 1L * (freq - 1L)) / 2L;
        }
        return (int)(res % 1_000_000_007L);
    }

    private int rev(int n) {
        sb.setLength(0);
        while (n > 0) {
            sb.append(n % 10);
            n /= 10;
        }
        if (sb.length() == 0) return 0;
        return Integer.parseInt(sb.toString());
    }
}
