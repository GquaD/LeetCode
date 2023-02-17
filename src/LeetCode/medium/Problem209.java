package LeetCode.medium;

public class Problem209 {
    //https://leetcode.com/problems/minimum-size-subarray-sum/
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    //30 min
    //https://leetcode.com/problems/minimum-size-subarray-sum/solutions/3196179/java-o-n-solution/
    //Runtime
    //2 ms
    //Beats
    //31.6%
    //Memory
    //49.7 MB
    //Beats
    //69.64%
    static int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, sum = nums[0], minLen = 100_001;
        while (end < nums.length && start <= end) {
            if (sum >= target) {
                int len = end - start + 1;
                if (minLen > len)
                    minLen = len;
                sum -= nums[start];
                start++;
            } else {
                end++;
                sum += end >= nums.length ? 0 : nums[end];
            }
        }
        return minLen == 100_001 ? 0 : minLen;
    }


    static int minSubArrayLen1(int target, int[] nums) {
        int sum = 0, count = 0, minLen = 100_001;
        for (int n : nums) {
            sum += n;
            count++;
            if (sum >= target && minLen > count) {
                minLen = count;
            }
        }
        return 42;
    }
}
