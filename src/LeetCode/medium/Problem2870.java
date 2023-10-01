package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem2870 {
    //https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/solutions/4114554/java-o-n-100-faster/
    //10-15min
    //Runtime
    //18 ms
    //Beats
    //100%
    //Memory
    //56.6 MB
    //Beats
    //50%
    static int minOperations(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq < 2) {
                return -1;
            } else {
                if (freq % 3 == 0) {
                    count += freq / 3;
                } else if (freq % 3 == 1) {
                    count += freq / 3 + 1; // -1 + 2 = 1;
                } else {
                    count += freq / 3 + 1;
                }
            }
        }
        return count;
    }
}
