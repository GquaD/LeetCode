package LeetCode.easy;

public class Problem1184 {
    //10min

    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //44.38
    //MB
    //Beats
    //23.19%
    //https://leetcode.com/problems/distance-between-bus-stops/solutions/8417775/java-100-fast-solution-by-tbekpro-nm2w/
    public int distanceBetweenBusStops(int[] distance, int s, int d) {
        if (s == d) return 0;

        int sum = distance[s], t = (s + 1) % distance.length;

        while (t != d) {
            sum += distance[t];
            t = (t + 1) % distance.length;
        }

        int sum1 = distance[d], tt = (distance.length + s - 1)  % distance.length;

        while (tt != d) {
            sum1 += distance[tt];
            tt = (distance.length + tt - 1)  % distance.length;
        }

        return Math.min(sum, sum1);
    }
}
