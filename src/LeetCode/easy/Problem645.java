package LeetCode.easy;

import java.util.*;

public class Problem645 {
    //https://leetcode.com/problems/set-mismatch/description/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{3,2,3,4,6,5})));
    }

    //10min
    //Runtime
    //19
    //ms
    //Beats
    //6.86%
    //of users with Java
    //Memory
    //45.85
    //MB
    //Beats
    //11.88%
    //of users with Java
    static int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            map.put(i, 0);
        }
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int[] res = new int[2];
        for (int k : map.keySet()) {
            int f = map.get(k);
            if (f == 2) res[0] = k;
            else if (f == 0) res[1] = k;
        }
        return res;
    }
    static int[] findErrorNums2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return new int[]{nums[i], nums[i - 1]};
            }
        }
        return null;
    }

    //Runtime
    //51 ms
    //Beats
    //6.56%
    //Memory
    //57.8 MB
    //Beats
    //8.4%
    static int[] findErrorNums1(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (set.contains(curr)) {
                res[0] = curr;
            } else {
                set.add(curr);
            }
            if (!set.contains(i + 1)) {
                res[1] = i + 1;
            }
        }
        return res;
    }
}
