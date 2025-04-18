package LeetCode.easy;

public class Problem3512 {
    //https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/solutions/6663415/java-simplest-solution-explained-by-tbek-9jbl/
    //1min
    //Runtime
    //1
    //ms
    //Beats
    //92.33%
    //Analyze Complexity
    //Memory
    //45.07
    //MB
    //Beats
    //74.02%
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int n: nums) sum += n;
        return sum % k;
    }
}
