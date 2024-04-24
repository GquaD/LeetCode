package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2863 {
    //https://leetcode.com/problems/maximum-length-of-semi-decreasing-subarrays/
    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{57,55,50,60,61,58,63,59,64,60,63}));
        System.out.println(maxSubarrayLength(new int[]{7,6,5,4,3,2,1,6,10,11}));
    }

    //https://leetcode.com/problems/maximum-length-of-semi-decreasing-subarrays/solutions/5067374/java-o-nlogn-solution/
    //25min
    //Runtime
    //89
    //ms
    //Beats
    //12.29%
    //of users with Java
    //Memory
    //63.47
    //MB
    //Beats
    //5.01%
    //of users with Java
    static int maxSubarrayLength(int[] nums) {
        if (nums.length == 1) return 0;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(new int[]{nums[i], i});
        }
        Collections.sort(list, (a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]);

        int max = 0, idxMem = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            int[] arr = list.get(i);
            int idx = arr[1];
            if (idx - idxMem > 0) {
                max = Math.max(max, idx - idxMem + 1);
            } else {
                idxMem = idx;
            }
        }
        return max;
    }
}
