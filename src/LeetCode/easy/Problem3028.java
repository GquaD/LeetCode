package LeetCode.easy;

public class Problem3028 {
    //https://leetcode.com/problems/ant-on-the-boundary/
    public static void main(String[] args) {

    }

    //2min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //42.10
    //MB
    //Beats
    //49.71%
    //of users with Java
    static int returnToBoundaryCount(int[] nums) {
        int sum = nums[0], count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (sum == 0)
                count++;
            sum += nums[i];
        }
        return sum == 0 ? count + 1 : count;
    }
}
