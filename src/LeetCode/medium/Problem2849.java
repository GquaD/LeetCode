package LeetCode.medium;

public class Problem2849 {
    //https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/solutions/4031160/java-100-faster-o-1-solution/
    //5min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //39.6 MB
    //Beats
    //100%
    static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) return t != 1;
        return Math.abs(sx - fx) <= t && Math.abs(sy - fy) <= t;
    }
}
