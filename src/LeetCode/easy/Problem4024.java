package LeetCode.easy;

public class Problem4024 {
    //2min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //46.57
    //MB
    //Beats
    //50.00%
    public int nearestDrone(int[][] drones, int[] target) {
        int min = 200, idx = -1;

        for (int i = 0; i < drones.length; i++) {
            int[] d = drones[i];
            int man = manhattan(d, target);
            if (man <= d[2] && man < min) {
                min = man;
                idx = i;
            }
        }

        return idx;
    }

    private int manhattan(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
