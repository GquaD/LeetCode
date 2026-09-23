package LeetCode.easy;

public class Problem2511 {
    //10-15min

    //https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //43.29
    //MB
    //Beats
    //39.48%
    public int captureForts(int[] forts) {
        int idx = -1, max = 0, enemies = 0;

        for (int i = 0; i < forts.length; i++) {
            int cur = forts[i];
            if (cur == 1) {
                idx = i;
                enemies = 0;
                continue;
            } else if (cur == -1 && idx > -1) {
                max = Math.max(max, enemies);
                idx = -1;
                enemies = 0;
            } else if (cur == 0) {
                enemies++;
            }
        }
        idx = -1;
        enemies = 0;

        for (int i = forts.length - 1; i >= 0; i--) {
            int cur = forts[i];
            if (cur == 1) {
                idx = i;
                enemies = 0;
                continue;
            } else if (cur == -1 && idx > -1) {
                max = Math.max(max, enemies);
                idx = -1;
                enemies = 0;
            } else if (cur == 0) {
                enemies++;
            }
        }

        return max;
    }
}
