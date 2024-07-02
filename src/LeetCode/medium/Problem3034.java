package LeetCode.medium;

public class Problem3034 {
    //https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i/solutions/5402776/java-100-faster-solution/
    //10min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.45
    //MB
    //Beats
    //27.27%
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int[] arr = new int[nums.length - 1];
        for (int i = 0; i < arr.length; i++) {
            int a = nums[i], b = nums[i + 1];
            if (b > a) {
                arr[i] = 1;
            } else if (b == a) {
                arr[i] = 0;
            } else {
                arr[i] = -1;
            }
        }
        int count = 0;
        for (int i = 0; i <= arr.length - pattern.length; i++) {
            boolean matches = true;
            for (int j = 0; j < pattern.length; j++) {
                int a = arr[i + j], b = pattern[j];
                if (a != b) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                count++;
            }
        }
        return count;
    }
}
