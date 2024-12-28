package LeetCode.medium;

public class Problem3400 {
    //https://leetcode.com/problems/maximum-number-of-matching-indices-after-right-shifts/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-number-of-matching-indices-after-right-shifts/solutions/6198020/java-brute-force-solution-by-tbekpro-zhs8/
    //5-10min
    //I was thinking about non-brute force solution
    //and that's why it took longer
    //brute force solution took 2 mins
    //Runtime
    //86
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.54
    //MB
    //Beats
    //100.00%
    public int maximumMatchingIndices(int[] nums1, int[] nums2) {
        int max = 0, idx1 = 0, n = nums1.length, count = 0, cycles = 0;
        while (cycles < n) {
            for (int i = 0; i < n; i++) {
                if (nums1[idx1++ % n] == nums2[i]) {
                    count++;
                }
            }
            idx1++;
            max = Math.max(max, count);
            count = 0;
            cycles++;
        }
        return max;
    }
}
