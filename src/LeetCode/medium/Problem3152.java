package LeetCode.medium;

public class Problem3152 {
    //https://leetcode.com/problems/special-array-ii
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/special-array-ii/solutions/6128896/java-o-n-k-parity-prefix-sum-solution/
    //10min
    //Runtime
    //3
    //ms
    //Beats
    //86.83%
    //Analyze Complexity
    //Memory
    //98.06
    //MB
    //Beats
    //88.02%
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] same = new int[n];
        for (int i = 1; i < n; i++) {
            same[i] = nums[i - 1] % 2 == nums[i] % 2 ? same[i - 1] + 1 : same[i - 1];
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < res.length; i++) {
            int a = queries[i][0], b = queries[i][1];
            if (same[b] - same[a] == 0)
                res[i] = true;
        }
        return res;
    }


//    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
//        int n = nums.length, parity = 0;
//        int[] same = new int[n];
//        for (int i = 1; i < n; i++) {
//            if (nums[i - 1] % 2 == nums[i] % 2) {
//                parity++;
//            }
//            same[i] = parity;
//        }
//        boolean[] res = new boolean[queries.length];
//        for (int i = 0; i < res.length; i++) {
//            int a = queries[i][0], b = queries[i][1];
//            if (same[b] - same[a] == 0)
//                res[i] = true;
//        }
//        return res;
//    }
}
