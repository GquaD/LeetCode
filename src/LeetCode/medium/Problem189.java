package LeetCode.medium;

public class Problem189 {
    //https://leetcode.com/problems/rotate-array/
    public static void main(String[] args) {

    }

    static void rotate(int[] nums, int k) {

    }

    //15 min
    //Runtime
    //1 ms
    //Beats
    //64.3%
    //Memory
    //57.9 MB
    //Beats
    //86.84%
    static void rotate1(int[] nums, int k) {
        if (!(nums.length == 1 || k == 0 || k == nums.length)) {
            int[] arr = new int[k %= nums.length];
            for (int i = nums.length - k, c = 0; i < nums.length; i++) arr[c++] = nums[i];
            for (int i = nums.length - k - 1, c = nums.length - 1; i >= 0; i--) nums[c--] = nums[i];
            for (int i = 0; i < arr.length; i++) nums[i] = arr[i];
        }
    }
}
