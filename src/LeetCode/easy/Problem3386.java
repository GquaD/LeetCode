package LeetCode.easy;

public class Problem3386 {
    //https://leetcode.com/problems/button-with-longest-push-time/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/button-with-longest-push-time/solutions/6592924/java-100-faster-solution-explained-by-tb-6kks/
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.08
    //MB
    //Beats
    //15.94%
    public int buttonWithLongestTime(int[][] events) {
        int prev = 0, diff = events[0][1], idx = events[0][0];
        for (int[] arr : events) {
            int d = arr[1] - prev;
            if (diff < d) {
                idx = arr[0];
                diff = d;
            } else if (diff == d && idx > arr[0]) {
                idx = arr[0];
            }
            prev = arr[1];
        }
        return idx;
    }
}
