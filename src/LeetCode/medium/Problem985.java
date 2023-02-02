package LeetCode.medium;

import java.util.Arrays;

public class Problem985 {
    //https://leetcode.com/problems/sum-of-even-numbers-after-queries/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumEvenAfterQueries(new int[]{3,2}, new int[][]{
                {4,0},
                {3,0}
        })));
        System.out.println(Arrays.toString(sumEvenAfterQueries(new int[]{1,2,3,4}, new int[][]{
                {1,0},
                {-3,1},
                {-4,0},
                {2,3}
        })));
    }

    //https://leetcode.com/problems/sum-of-even-numbers-after-queries/solutions/3130598/java-o-n-solution/
    //Runtime
    //4 ms
    //Beats
    //98.71%
    //Memory
    //50.4 MB
    //Beats
    //61.17%
    static int[] sumEvenAfterQueries(int[] nums, int[][] q) {
        int sum = 0;
        for (int n : nums) if (n % 2 == 0) sum += n;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int val = q[i][0], idx = q[i][1], initial = nums[idx];
            if (initial % 2 == 0) res[i] = (val + initial) % 2 == 0 ? (sum += val) : (sum -= initial);
            else res[i] = (val + initial) % 2 == 0 ? (sum += (val + initial)) : sum;
            nums[idx] += val;
        }
        return res;
    }

    //
    //20 min
    //Runtime
    //4 ms
    //Beats
    //98.71%
    //Memory
    //50.6 MB
    //Beats
    //40.13%
    static int[] sumEvenAfterQueries1(int[] nums, int[][] q) {
        int sum = 0;
        for (int n : nums) if (n % 2 == 0) sum += n;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int val = q[i][0], idx = q[i][1], initial = nums[idx];
            if (initial % 2 == 0) {
                if ((val + initial) % 2 == 0) res[i] = sum += val;
                else res[i] = sum -= initial;
            } else {
                if ((val + initial) % 2 == 0) res[i] = sum += (val + initial);
                else res[i] = sum;
            }
            nums[idx] += val;
        }

        return res;
    }
}
