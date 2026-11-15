package LeetCode.easy;

public class Problem4111 {
    //10min
    //Runtime
    //22
    //ms
    //Beats
    //4.53%
    //Memory
    //46.40
    //MB
    //Beats
    //10.55%
    public int countConsistent(int[] nums) {
        int result = nums.length;

        for (int i = 2; i <= nums.length; i++) {
            for (int j = 0; j <= nums.length - i; j++) {
                int min = nums[j], and = nums[j];
                for (int k = j + 1; k < j + i; k++) {
                    and &= nums[k];
                    min = Math.min(min, nums[k]);
                }
                if (min == and) result++;
            }
        }

        return result;
    }
}
