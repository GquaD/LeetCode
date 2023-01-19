package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem974 {
    //https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
        System.out.println(subarraysDivByK(new int[]{5}, 9));
    }

    //nnnn
    //Runtime
    //4 ms
    //Beats
    //92.83%
    //Memory
    //46.3 MB
    //Beats
    //86.69%
    static int subarraysDivByK(int[] A, int K) {
        int[] count = new int[K];
        count[0] = 1;
        int prefix = 0, res = 0;
        for (int a : A) {
            prefix = Math.floorMod(prefix + a, K);
            res += count[prefix]++;
        }
        return res;
    }

    static Map<String, Integer> map;
    static int count;

    static int subarraysDivByK1(int[] nums, int k) {
        map = new HashMap<>();
        count = 0;
        map.put(0 + "." + 0, nums[0]);
        goDP(0, 0, nums, k);
        return count;
    }

    private static void goDP(int start, int end, int[] nums, int k) {
        if (start > end || end >= nums.length) return;

        String key = start + "." + end;
        Integer sum = map.get(key);
        if (sum == null) {
            String keyPrev = start + "." + (end - 1);
            sum = map.get(keyPrev) + nums[end];
            map.put(key, sum);
        }
        if (sum % k == 0) count++;
        goDP(start, end + 1, nums, k);
        goDP(start + 1, end, nums, k);
    }
}
