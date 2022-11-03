package LeetCode.easy;

public class Problem1822 {
    //https://leetcode.com/problems/sign-of-the-product-of-an-array/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/sign-of-the-product-of-an-array/solutions/2772511/java-o-n-in-just-1-ms/
    //O(N) in less than 5 mins
    //https://leetcode.com/problems/sign-of-the-product-of-an-array/description/
    //Runtime
    //1 ms
    //Beats
    //83.4%
    //Memory
    //43.7 MB
    //Beats
    //66.47%
    static int arraySign(int[] nums) {
        boolean isPositive = true;
        for (int n : nums) {
            if (n == 0) return 0;
            if (n < 0) isPositive = !isPositive;
        }
        return isPositive ? 1 : -1;
    }
}
