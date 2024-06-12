package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem325 {
    //https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/solutions/5301287/java-prefixsum-hashmap-o-n-solution/
    //15min-20min
    //Runtime
    //87
    //ms
    //Beats
    //17.40%
    //of users with Java
    //Memory
    //71.84
    //MB
    //Beats
    //33.54%
    //of users with Java
    static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
            if (map.containsKey(sum - k)) {
                int idx = map.get(sum - k);
                max = Math.max(max, i - idx);
            }
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return max;
    }
}
