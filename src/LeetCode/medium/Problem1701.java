package LeetCode.medium;

public class Problem1701 {
    //https://leetcode.com/problems/average-waiting-time/
    public static void main(String[] args) {
        System.out.println(averageWaitingTime(new int[][]{{5,2},{5,4},{10,3},{20,1}}));
    }

    //https://leetcode.com/problems/average-waiting-time/solutions/3947954/java-o-n/
    //less than 5 min
    //Runtime
    //4 ms
    //Beats
    //33.22%
    //Memory
    //87.6 MB
    //Beats
    //26.99%
    static double averageWaitingTime(int[][] c) {
        long timeOrderFinishes = c[0][0], timeWaited = 0;
        for (int i = 0; i < c.length; i++) {
            int ar = c[i][0], t = c[i][1];
            if (ar > timeOrderFinishes) timeOrderFinishes = ar;
            timeOrderFinishes += t;
            timeWaited += Math.max(timeOrderFinishes - ar, 0);
        }
        return 1.0 * timeWaited / c.length;
    }
}
