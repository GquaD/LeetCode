package LeetCode.easy;

public class Problem2784 {
    //https://leetcode.com/problems/check-if-array-is-good/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/check-if-array-is-good/solutions/3815598/java-o-n-100-faster/
    //5min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //41.6 MB
    //Beats
    //72.49%
    static boolean isGood(int[] nums) {
        int max = 0;
        for (int n : nums) max = Math.max(n, max);
        int[] arr = new int[max + 1];
        for (int n : nums) arr[n]++;
        for (int i = 1; i < arr.length - 1; i++) if (arr[i] != 1) return false;
        return arr[arr.length - 1] == 2;
    }
}
