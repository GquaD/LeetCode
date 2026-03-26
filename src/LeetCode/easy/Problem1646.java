package LeetCode.easy;

public class Problem1646 {
    //10min

    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //42.07
    //MB
    //Beats
    //79.57%
    //https://leetcode.com/problems/get-maximum-in-generated-array/solutions/7697465/java-100-faster-solution-by-tbekpro-7nwq/
    private static int[] arr = generateArray();

    public int getMaximumGenerated(int n) {
        int max = 0, i = 0;
        while (i <= n) max = Math.max(max, arr[i++]);
        return max;
    }

    private static int[] generateArray() {
        int[] a = new int[101];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < a.length; i++) {
            if (i % 2 == 0) a[i] = a[i / 2];
            else a[i] = a[i / 2] + a[(i / 2) + 1];
        }
        return a;
    }
}
