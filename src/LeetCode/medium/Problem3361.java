package LeetCode.medium;

public class Problem3361 {
    //https://leetcode.com/problems/shift-distance-between-two-strings

    //https://leetcode.com/problems/shift-distance-between-two-strings/solutions/6091923/java-o-n-solution/
    //5min
    //Runtime
    //69
    //ms
    //Beats
    //22.97%
    //Analyze Complexity
    //Memory
    //46.15
    //MB
    //Beats
    //8.44%
    public long shiftDistance(String s, String t, int[] next, int[] prev) {
        long minSum = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a', b = t.charAt(i) - 'a';
            long costNext = calcCostNext(a, b, next), costPrev = calcCostPrev(a, b, prev);
            minSum += Math.min(costNext, costPrev);
        }
        return minSum;
    }

    private long calcCostNext(int from, int to, int[] next) {
        long cost = 0;
        while (from % 26 != to) {
            cost += next[from % 26];
            from++;
        }
        return cost;
    }

    private long calcCostPrev(int from, int to, int[] prev) {
        long cost = 0;
        from += 26;
        while (from % 26 != to) {
            cost += prev[from % 26];
            from--;
        }
        return cost;
    }
}
