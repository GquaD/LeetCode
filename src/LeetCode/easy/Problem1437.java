package LeetCode.easy;

public class Problem1437 {
    //https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{0,1,0,1}, 1));
        System.out.println(kLengthApart(new int[]{1,0,0,0,1,0,0,1}, 2));
    }

    //https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/solutions/3217769/java-o-n-100-faster-solution/
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //72.9 MB
    //Beats
    //5.28%
    static boolean kLengthApart(int[] nums, int k) {
        int count = nums[0] == 0 ? k : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (count < k) return false;
                count = 0;
            } else count++;
        }
        return true;
    }
}
