package LeetCode.medium;

public class Problem4025 {
    //15min

    //Runtime
    //3
    //ms
    //Beats
    //99.95%
    //Memory
    //121.90
    //MB
    //Beats
    //16.96%
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int max = lights[0], pen = 0;

        for (int i = 1; i < lights.length; i++) max = Math.max(max, lights[i]);

        for (int a: arrivalTime) {
            int r = a % period;
            if (r >= max) pen = Math.max(pen, period - r);
        }

        return pen;
    }
}
