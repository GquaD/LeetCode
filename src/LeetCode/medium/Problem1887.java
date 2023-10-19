package LeetCode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Problem1887 {
    //https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
    public static void main(String[] args) {
        System.out.println(reductionOperations(new int[]{1,2,2,2,3,3,4,4,4,4,4,5,5,5,6,5,5,5,5,5,5,5,8,8}));
        System.out.println(reductionOperations(new int[]{1,1,2,2,3}));

    }

    //https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/solutions/4185919/java-2-solutions-10x-optimized/
    //10 min
    //Runtime
    //35 ms
    //Beats
    //42.42%
    //Memory
    //56.2 MB
    //Beats
    //9.9%
    static int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0, sum = 0, prev = nums[nums.length - 1], min = nums[0];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != min) {
                if (prev != nums[i]) {
                    sum += count;
                    prev = nums[i];
                }
                count++;
            }
        }
        sum += count;

        return sum;
    }

    //
    //10-15min
    //Runtime
    //359 ms
    //Beats
    //5.5%
    //Memory
    //55.2 MB
    //Beats
    //17.17%
    static int reductionOperations1(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        if (map.size() == 1) return 0;
        int count = 0, sum = 0;
        map.remove(map.lastKey());
        for (int key : map.keySet()) {
            count += map.get(key);
            sum += count;
        }
        return sum;
    }
}
