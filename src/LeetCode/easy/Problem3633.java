package LeetCode.easy;

public class Problem3633 {
    //10min

    //https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i
    //Runtime
    //5
    //ms
    //Beats
    //13.42%
    //Analyze Complexity
    //Memory
    //46.98
    //MB
    //Beats
    //64.05%
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = 10_000;
        for (int i = 0; i < landStartTime.length; i++) {
            int dur = landDuration[i], time = landStartTime[i] + dur;
            for (int j = 0; j < waterStartTime.length; j++) {
                if (time >= waterStartTime[j])
                    min = Math.min(min, time + waterDuration[j]);
                else
                    min = Math.min(min, waterDuration[j] + waterStartTime[j]);
            }
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            int dur = waterDuration[i], time = waterStartTime[i] + dur;
            for (int j = 0; j < landStartTime.length; j++) {
                if (time >= landStartTime[j])
                    min = Math.min(min, time + landDuration[j]);
                else
                    min = Math.min(min, landDuration[j] + landStartTime[j]);
            }
        }
        return min;
    }
}
