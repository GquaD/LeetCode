package LeetCode.easy;

public class Problem3173 {
    //https://leetcode.com/problems/bitwise-or-of-adjacent-elements/
    public static void main(String[] args) {

    }

    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //45.56
    //MB
    //Beats
    //100.00%
    //of users with Java
    public int[] orArray(int[] nums) {
        int[] arr = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            arr[i - 1] = nums[i] | nums[i - 1];
        }
        return arr;
    }
}
