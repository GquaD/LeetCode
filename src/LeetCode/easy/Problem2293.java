package LeetCode.easy;

public class Problem2293 {
    //https://leetcode.com/problems/min-max-game/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/min-max-game/solutions/2838187/java-straightforward-solution/
    //Runtime
    //1 ms
    //Beats
    //93.47%
    //Memory
    //41.7 MB
    //Beats
    //95.70%
    static int minMaxGame(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] newNums = new int[nums.length/2];
        while (newNums.length > 1) {
            for (int i = 0; i < newNums.length; i+=2) {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            }
            for (int i = 1; i < newNums.length; i+=2) {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
            nums = newNums;
            newNums = new int[newNums.length/2];
        }

        return Math.min(nums[0], nums[1]);
    }
}
