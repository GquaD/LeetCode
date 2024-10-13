package LeetCode.easy;

import java.util.Arrays;

public class Problem3074 {
    //https://leetcode.com/problems/apple-redistribution-into-boxes
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/apple-redistribution-into-boxes/solutions/5907314/java-sorting-solution/
    //2min
    //Runtime
    //2
    //ms
    //Beats
    //31.05%
    //Analyze Complexity
    //Memory
    //42.17
    //MB
    //Beats
    //55.82%
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = 0, count = 0;
        for (int a : apple) sum += a;
        for (int i = capacity.length - 1; i >= 0; i--) {
            count++;
            sum -= capacity[i];
            if (sum <= 0) break;
        }
        return count;
    }
}
