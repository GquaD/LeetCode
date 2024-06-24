package LeetCode.easy;

public class Problem3190 {
    //https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/solutions/5361750/java-o-n-3-line-100-faster-solution/
    //1min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.61
    //MB
    //Beats
    //100.00%
    private int minimumOperations(int[] nums) {
        int res = 0;
        for (int n : nums) {
            if (n % 3 != 0) res++;
        }
        return res;
    }
}
