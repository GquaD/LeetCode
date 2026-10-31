package LeetCode.medium;

public class Problem4089 {
    //5-10min
    //Runtime
    //10
    //ms
    //Beats
    //21.29%
    //Memory
    //195.87
    //MB
    //Beats
    //87.43%
    public long countSubarrays(int[] nums, int min, int max) {
        long result = 0, count = 0;
        for (int n: nums) {
            if (n >= min && n <= max) {
                count++;
            } else {
                result += (count * (count + 1)) / 2;
                count = 0;
            }
        }

        if (count > 0) result += (count * (count + 1)) / 2;

        return result;
    }
}
