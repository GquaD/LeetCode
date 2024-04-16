package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1852 {
    //https://leetcode.com/problems/distinct-numbers-in-each-subarray/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/distinct-numbers-in-each-subarray/solutions/5031422/java-o-n-solution-using-hashmap/
    //5min
    //Runtime
    //68
    //ms
    //Beats
    //58.62%
    //of users with Java
    //Memory
    //61.61
    //MB
    //Beats
    //15.52%
    //of users with Java
    static int[] distinctNumbers(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        ans[0] = map.size();
        int idx = 1;

        for (int i = k; i < nums.length; i++) {
            int n = nums[i - k], freq = map.get(n);

            if (freq == 1) map.remove(n);
            else map.put(n, freq - 1);

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            ans[idx++] = map.size();
        }
        return ans;
    }
}
