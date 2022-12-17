package LeetCode.hard;

import java.util.Arrays;

public class Problem1402 {
    //https://leetcode.com/problems/reducing-dishes/description/
    public static void main(String[] args) {
        System.out.println(maxSatisfaction(new int[]{-1,-8,0,5,-7}));
    }

    //https://leetcode.com/problems/reducing-dishes/solutions/2920585/java-o-n-log-n-n-n-3ms-solution/
    //Runtime
    //3 ms
    //Beats
    //85.66%
    //Memory
    //40.8 MB
    //Beats
    //82.99%
    static int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int max = 0, sum = 0, count = 1;
        for (int i = 0; i < s.length; i++) {
            for (int j = i; j < s.length; j++) {
                sum += s[j] * count++;
            }
            max = Math.max(max, sum);
            sum = 0;
            count = 1;
        }
        return max;
    }
}
