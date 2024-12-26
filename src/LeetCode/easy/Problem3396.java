package LeetCode.easy;

public class Problem3396 {
    //https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/solutions/6189984/java-99-faster-solution-by-tbekpro-d5td/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //99.64%
    //Analyze Complexity
    //Memory
    //44.46
    //MB
    //Beats
    //73.37%
    public int minimumOperations(int[] nums) {
        int[] arr = new int[101];
        for (int n : nums) arr[n]++;
        int count = 0;
        for (int i = 0; i < nums.length; i += 3) {
            if (allUnique(arr)) {
                break;
            }
            arr[nums[i]]--;
            if (i + 1 < nums.length) arr[nums[i + 1]]--;
            if (i + 2 < nums.length) arr[nums[i + 2]]--;

            count++;
        }
        return count;
    }

    private boolean allUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) return false;
        }

        return true;
    }
}
