package LeetCode.easy;

public class Problem2903 {
    //https://leetcode.com/problems/find-indices-with-index-and-value-difference-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/solutions/6615987/java-simple-solution-by-tbekpro-q099/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //99.36%
    //Analyze Complexity
    //Memory
    //43.46
    //MB
    //Beats
    //71.47%
    public int[] findIndices(int[] nums, int idx, int val) {
        for (int i = 0; i < nums.length - idx; i++) {
            for (int j = i + idx; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) >= val) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
