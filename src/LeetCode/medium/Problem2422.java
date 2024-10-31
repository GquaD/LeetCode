package LeetCode.medium;

public class Problem2422 {
    //https://leetcode.com/problems/merge-operations-to-turn-array-into-a-palindrome
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/merge-operations-to-turn-array-into-a-palindrome/solutions/5989427/java-one-pass-solution/
    //5min
    //Runtime
    //4
    //ms
    //Beats
    //50.78%
    //Analyze Complexity
    //Memory
    //61.05
    //MB
    //Beats
    //48.90%
    public int minimumOperations(int[] nums) {
        int l = 0, r = nums.length - 1;
        int count = 0;
        while (l < r) {
            int a = nums[l], b = nums[r];
            if (a == b) {
                l++;
                r--;
            } else if (a > b) {
                nums[r - 1] += b;
                nums[r] = 0;
                r--;
                count++;
            } else {
                nums[l + 1] += a;
                nums[l] = 0;
                l++;
                count++;
            }
        }
        return count;
    }
}
