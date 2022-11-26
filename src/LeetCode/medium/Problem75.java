package LeetCode.medium;

public class Problem75 {
    //https://leetcode.com/problems/sort-colors/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/sort-colors/solutions/2849165/java-100-faster-o-n-n-solution/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.9 MB
    //Beats
    //18.25%
    static void sortColors(int[] nums) {
        int n0 = 0, n1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) n0++;
            else if (nums[i] == 1) n1++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (n0-- > 0) nums[i] = 0;
            else if (n1-- > 0) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
