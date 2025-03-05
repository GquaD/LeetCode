package LeetCode.easy;

public class Problem2432 {
    //https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/solutions/6500375/java-100-faster-solution-by-tbekpro-kjqu/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.14
    //MB
    //Beats
    //43.09%
    public int hardestWorker(int n, int[][] logs) {
        int max = logs[0][1], idx = logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            int diff = logs[i][1] - logs[i - 1][1];
            if (diff > max) {
                max = diff;
                idx = logs[i][0];
            } else if (diff == max) {
                idx = Math.min(idx, logs[i][0]);
            }
        }
        return idx;
    }
}
