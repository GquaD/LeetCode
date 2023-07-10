package LeetCode.easy;

public class Problem2717 {
    //https://leetcode.com/problems/semi-ordered-permutation/
    public static void main(String[] args) {
        System.out.println(semiOrderedPermutation(new int[]{2,4,1,3}));
    }

    //https://leetcode.com/problems/semi-ordered-permutation/solutions/3746225/java-o-n-100-faster/
    //10 min
    //Runtime
    //2 ms
    //Beats
    //100%
    //Memory
    //43.2 MB
    //Beats
    //78.17%
    static int semiOrderedPermutation(int[] nums) {
        int a = 1, b = nums.length, idxA = 0, idxB = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) idxA = i;
            if (nums[i] == b) idxB = i;
        }
        b = b - idxB - 1;
        return idxB < idxA ? idxA + b - 1 : idxA + b;
    }
}
