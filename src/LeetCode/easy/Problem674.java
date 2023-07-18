package LeetCode.easy;

public class Problem674 {
    //https://leetcode.com/problems/longest-continuous-increasing-subsequence/
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1,3,5,4,7}));
        System.out.println(findLengthOfLCIS(new int[]{1,2,3,1,7}));
        System.out.println(findLengthOfLCIS(new int[]{1,1,1,1,1,1}));
    }

    //https://leetcode.com/problems/longest-continuous-increasing-subsequence/solutions/3784034/java-using-math-max-o-n-solution/
    //5 min
    //Runtime
    //Details
    //1ms
    //Beats 98.73%of users with Java
    //Memory
    //Details
    //43.66mb
    //Beats 83.44%of users with Java
    static int findLengthOfLCIS(int[] nums) {
        int count = 1, res = 0;
        for (int i = 1; i < nums.length; i++) {
            count = nums[i] > nums[i - 1] ? count + 1 : 1;
            res = Math.max(res, count);
        }
        return res;
    }

    //5 min
    //Runtime
    //Details
    //2ms
    //Beats 14.10%of users with Java
    //Memory
    //Details
    //42.99mb
    //Beats 97.36%of users with Java
    static int findLengthOfLCIS1(int[] nums) {
        int a = 0, b = 0, count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) a = i;
            b = i;
            count = Math.max(count, b - a + 1);
        }
        return count;
    }
}
