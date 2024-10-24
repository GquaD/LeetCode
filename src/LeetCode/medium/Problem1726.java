package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1726 {
    //https://leetcode.com/problems/tuple-with-same-product/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/tuple-with-same-product/solutions/5961718/java-hashmap-solution/
    //5min
    //Runtime
    //214
    //ms
    //Beats
    //58.82%
    //Analyze Complexity
    //Memory
    //74.86
    //MB
    //Beats
    //42.35%
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int mult = nums[i] * nums[j];
                map.put(mult, map.getOrDefault(mult, 0) + 1);
            }
        }

        int res = 0;
        for (int key: map.keySet()) {
            int freq = map.get(key);
            res += (freq * (freq - 1) / 2) * 8;
        }
        return res;
    }
}
