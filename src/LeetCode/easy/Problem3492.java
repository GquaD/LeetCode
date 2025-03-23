package LeetCode.easy;

public class Problem3492 {
    //https://leetcode.com/problems/maximum-containers-on-a-ship
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-containers-on-a-ship/solutions/6571654/java-one-line-solution-by-tbekpro-vhx7/
    //1min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.94
    //MB
    //Beats
    //100.00%
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(n * n, maxWeight / w);
    }
}
