package LeetCode.easy;

public class Problem303 {
    //https://leetcode.com/problems/range-sum-query-immutable/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/range-sum-query-immutable/solutions/2826445/java-simple-solution/
    //5 min
    //Runtime
    //54 ms
    //Beats
    //32.40%
    //Memory
    //44.8 MB
    //Beats
    //97.69%

    static class NumArray {
        int[] arr;
        public NumArray(int[] nums) {
            arr = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) sum += arr[i];
            return sum;
        }
    }
}
