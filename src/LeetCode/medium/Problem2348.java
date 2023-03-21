package LeetCode.medium;

public class Problem2348 {
    //https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{0,0,0,2,0,0}));
    }

    //https://leetcode.com/problems/number-of-zero-filled-subarrays/solutions/3322710/java-using-arithmetic-progression-sum/
    //Runtime
    //6 ms
    //Beats
    //34.17%
    //Memory
    //59.6 MB
    //Beats
    //72.41%
    static long zeroFilledSubarray(int[] nums) {
        long sum = 0, countTemp = 0;
        for (int n : nums) {
            if (n == 0) {
                countTemp++;
            } else {
                sum += ((1 + countTemp) * countTemp) / 2;
                countTemp = 0;
            }
        }
        if (countTemp > 0) sum += ((1 + countTemp) * countTemp) / 2;
        return sum;
    }
}
