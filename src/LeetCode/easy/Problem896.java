package LeetCode.easy;

public class Problem896 {
    //https://leetcode.com/problems/monotonic-array/
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1,2,2,4}));
    }

    //https://leetcode.com/problems/monotonic-array/solutions/3250088/java-o-n-solution/
    //Runtime
    //2 ms
    //Beats
    //70.82%
    //Memory
    //53.2 MB
    //Beats
    //23.12%
    static boolean isMonotonic(int[] nums) {
        if (nums.length == 1) return true;
        boolean isInc = true, isDec = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                isInc = false;
            }
            if (nums[nums.length - i] > nums[nums.length - i - 1]) {
                isDec = false;
            }
            if (!(isInc || isDec)) {
                return false;
            }
        }
        return true;
    }
}
