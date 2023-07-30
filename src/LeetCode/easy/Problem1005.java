package LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem1005 {
    //https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{4,2,3}, 1));
        System.out.println(largestSumAfterKNegations(new int[]{3,-1,0,2}, 3));
        System.out.println(largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2));
    }


    //20-30min
    //Runtime
    //6 ms
    //Beats
    //39.30%
    //Memory
    //41.6 MB
    //Beats
    //28.43%
    static int largestSumAfterKNegations(int[] nums, int k) {
        List<Integer> listPos = new ArrayList<>(), listNeg = new ArrayList<>();
        int sum = 0;
        for (int n : nums) {
            if (n >= 0) {
                sum += n;
                listPos.add(n);
            } else  {
                listNeg.add(n);
            }
        }
        Collections.sort(listNeg);
        int idx = 0;
        while (k > 0 && idx < listNeg.size()) {
            k--;
            int v = Math.abs(listNeg.get(idx));
            listPos.add(v);
            sum += v;
            idx++;
        }

        if (k % 2 != 0) {
            int min = sum;
            for (int n : listPos) min = Math.min(n, min);
            sum -= 2 * min;
        }
        if (listNeg.size() > 0) for (int i = idx; i < listNeg.size(); i++) sum += listNeg.get(i);

        return sum;
    }
    static int largestSumAfterKNegations2(int[] nums, int k) {
        int countNeg = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) if (nums[i] < 0) countNeg++;
        if (countNeg == 0) {

        }
        if (countNeg <= k) {

            Arrays.sort(nums);
            for (int n : nums) sum += n < 0 ? -n : n;
        } else {
            int min = 101;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) nums[i] = - nums[i];
                sum += nums[i];
                min = Math.min(min, nums[i]);
            }
            k = countNeg - k;
            if (k % 2 == 1) sum -= 2 * min;
        }
        return sum;
    }

    static int largestSumAfterKNegations1(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        k = k % nums.length;
        if (k / nums.length % 2 == 1) for (int i = 0; i < nums.length; i++) nums[i] = - nums[i];
        for (int i = 0; i < nums.length; i++) sum += i < k ? - nums[i] : nums[i];
        return sum;
    }
}
