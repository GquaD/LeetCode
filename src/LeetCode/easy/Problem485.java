package LeetCode.easy;

public class Problem485 {
    //https://leetcode.com/problems/max-consecutive-ones/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/max-consecutive-ones/solutions/2835405/java-o-n-3ms-solution/
    //3min
    //Runtime
    //3 ms
    //Beats
    //77.14%
    //Memory
    //56.4 MB
    //Beats
    //65.62%
    static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (max < count) {
                    max = count;
                }
                count = 0;
            }
            else count++;
        }
        if (max < count) {
            max = count;
        }
        return max;
    }
}
