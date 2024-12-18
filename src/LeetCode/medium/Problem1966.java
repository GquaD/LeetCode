package LeetCode.medium;

public class Problem1966 {
    //https://leetcode.com/problems/binary-searchable-numbers-in-an-unsorted-array
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/binary-searchable-numbers-in-an-unsorted-array/solutions/6159794/java-on-simple-solution-explained-by-tbe-5tdm/
    //10min
    //Runtime
    //3
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //57.42
    //MB
    //Beats
    //27.27%
    public int binarySearchableNumbers(int[] nums) {
        int[] minarr = new int[nums.length];
        int min = 100_000;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minarr[i] = min;
        }

        int max = -100_000, res = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] >= max && nums[i] <= minarr[i]) {
                res++;
            }
        }
        return res;
    }
}
