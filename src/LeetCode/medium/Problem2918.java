package LeetCode.medium;

public class Problem2918 {
    //https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/
    public static void main(String[] args) {
        System.out.println(minSum(new int[]{3,2,0,1,0}, new int[]{6,5,0}));
        System.out.println(minSum(new int[]{2,0,2,0}, new int[]{1,4}));
    }

    //https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/solutions/4230626/java-o-n-99-faster/
    //5-10min
    //Runtime
    //3 ms
    //Beats
    //99.3%
    //Memory
    //59.3 MB
    //Beats
    //61.13%
    static long minSum(int[] nums1, int[] nums2) {
        int count01 = 0, count02 = 0;
        long sum1 = 0, sum2 = 0;
        for (int n : nums1) {
            if (n == 0) {
                count01++;
                sum1 += 1;
            } else {
                sum1 += n;
            }
        }
        for (int n : nums2) {
            if (n == 0) {
                count02++;
                sum2 += 1;
            } else {
                sum2 += n;
            }
        }

        if (count01 == 0 && sum1 < sum2 || count02 == 0 && sum1 > sum2) {
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}
