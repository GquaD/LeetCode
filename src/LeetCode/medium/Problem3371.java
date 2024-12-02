package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem3371 {
    //https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/solutions/6104147/java-100-faster-o-n-hashmap-solution/
    //15min
    //Runtime
    //87
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //59.13
    //MB
    //Beats
    //100.00%
    public int getLargestOutlier(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            sum += n;
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int max = -1000;
        for (int n: nums) {
            int t = sum - n;
            if (t % 2 == 0) {
                Integer freq = map.get(t / 2);
                if (freq != null) {
                    if (t / 2 == n && freq > 1 || t / 2 != n)
                        max = Math.max(max, n);
                }
            }
        }
        return max;
    }
}
