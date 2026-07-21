package LeetCode.easy;

public class Problem3996 {
    //15min

    //Runtime
    //1
    //ms
    //Beats
    //76.52%
    //Memory
    //44.00
    //MB
    //Beats
    //57.97%
    public boolean canReach(int[] start, int[] target) {
        int y = Math.abs(start[0] - target[0]), x = Math.abs(start[1] - target[1]);
        return (y + x) % 2 == 0;
    }
}
