package LeetCode.medium;

public class Problem3151 {
    //https://leetcode.com/problems/special-array-i/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/special-array-i/solutions/5197204/java-o-n-solution/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //44.13%
    //of users with Java
    //Memory
    //42.98
    //MB
    //Beats
    //82.44%
    //of users with Java
    static boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;

        for (int i = 1; i < nums.length; i++) {
            boolean prevIsEven = nums[i - 1] % 2 == 0, curIsEven = nums[i] % 2 == 0;
            if (prevIsEven && curIsEven || !prevIsEven && !curIsEven)
                return false;
        }
        return true;
    }
}
