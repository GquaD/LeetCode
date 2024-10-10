package LeetCode.easy;

public class Problem3010 {
    //https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/solutions/5895181/java-2-min-solution/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //94.90%
    //Analyze Complexity
    //Memory
    //44.34
    //MB
    //Beats
    //15.30%
    public int minimumCost(int[] nums) {
        int min = 60, prev = 60;
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                if (prev > min) {
                    prev = min;
                }
                min = nums[i];
            } else if (prev > nums[i]) {
                prev = nums[i];
            }
        }
        return nums[0] + prev + min;
    }
}
