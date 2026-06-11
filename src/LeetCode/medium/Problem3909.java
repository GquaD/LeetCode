package LeetCode.medium;

public class Problem3909 {
    //5-10min

    //Runtime
    //2
    //ms
    //Beats
    //77.31%
    //Memory
    //104.22
    //MB
    //Beats
    //34.79%
    public int compareBitonicSums(int[] nums) {
        long sum = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            int a = nums[i - 1], b = nums[i], c = nums[i + 1];
            if (a < b && b > c) continue;
            if (a < b) sum += b;
            if (a > b) sum -= b;
        }

        sum -= nums[nums.length - 1];

        return sum == 0 ? -1 : sum > 0 ? 0 : 1;
    }
}
