package LeetCode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem2895 {
    //https://leetcode.com/problems/minimum-processing-time/
    public static void main(String[] args) {
        System.out.println(minProcessingTime(Arrays.asList(10, 8), Arrays.asList(2,2,3,1,8,7,4,5)));
        System.out.println(minProcessingTime(Arrays.asList(20, 10), Arrays.asList(2,3,1,2,5,8,4,3)));
    }

    //https://leetcode.com/problems/minimum-processing-time/solutions/4145955/java-o-nlogn-solution/
    //5-10 min
    //Runtime
    //66 ms
    //Beats
    //50%
    //Memory
    //60.1 MB
    //Beats
    //50%
    static int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, (a, b) -> b - a);
        int max = 0;
        for (int i = 0; i < processorTime.size(); i++)
            for (int j = 0; j < 4; j++)
                max = Math.max(max, processorTime.get(i) + tasks.get(i * 4 + j));
        return max;
    }
}
