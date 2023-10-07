package LeetCode.medium;

import java.util.Arrays;

public class Problem1262 {
    //https://leetcode.com/problems/greatest-sum-divisible-by-three/
    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[]{4}));
        System.out.println(maxSumDivThree(new int[]{4,2}));
        System.out.println(maxSumDivThree(new int[]{4,1}));
        System.out.println(maxSumDivThree(new int[]{3,6,5,1,8}));
        System.out.println(maxSumDivThree(new int[]{1,2,3,4,4}));
    }

    //https://leetcode.com/problems/greatest-sum-divisible-by-three/solutions/4141853/java-straightforward-solution/
    //10-15min
    //Runtime
    //9 ms
    //Beats
    //71.26%
    //Memory
    //44.5 MB
    //Beats
    //82.68%
    static int maxSumDivThree(int[] nums) {
        if (nums.length == 1) return nums[0] % 3 == 0 ? nums[0] : 0;
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 3 == 0) return sum;
        Arrays.sort(nums);
        if (sum % 3 == 1) {
            int one = -1, a = one, b = one;
            for (int n : nums) {
                if (n % 3 == 1) {
                    if (one == -1) one = n;
                } else if (n % 3 == 2) {
                    if (a == -1) a = n;
                    else if (b == -1) b = n;
                }
            }
            if (one == -1) {
                if (a == -1 || b == -1) return 0;
                else return sum - a - b;
            } else {
                if (a == -1 || b == -1) return sum - one;
                else return one <= a + b ? sum - one : sum - a - b;
            }

        } else {
            int one = -1, a = one, b = one;
            for (int n : nums) {
                if (n % 3 == 2) {
                    if (one == -1) one = n;
                } else if (n % 3 == 1) {
                    if (a == -1) a = n;
                    else if (b == -1) b = n;
                }
            }
            if (one == -1) {
                if (a == -1 || b == -1) return 0;
                else return sum - a - b;
            } else {
                if (a == -1 || b == -1) return sum - one;
                else return one <= a + b ? sum - one : sum - a - b;
            }
        }
    }
}
