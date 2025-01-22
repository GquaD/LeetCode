package LeetCode.medium;

import java.util.Arrays;

public class Problem2323 {
    //https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs-ii/solutions/6315118/java-onlogn-solution-by-tbekpro-85lq/
    //5min
    //Runtime
    //35
    //ms
    //Beats
    //88.95%
    //Analyze Complexity
    //Memory
    //57.49
    //MB
    //Beats
    //44.19%
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int max = 0;
        for (int i = 0; i < jobs.length; i++) {
            int w = workers[i], j = jobs[i], t = 0;
            if (w >= j) t = 1;
            else t = j % w > 0 ? j / w + 1 : j / w;
            max = Math.max(max, t);
        }
        return max;
    }
}
