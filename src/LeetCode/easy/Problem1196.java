package LeetCode.easy;

import java.util.Arrays;

public class Problem1196 {

    //https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/
    //1min
    //Runtime
    //5
    //ms
    //Beats
    //56.23%
    //Analyze Complexity
    //Memory
    //43.98
    //MB
    //Beats
    //89.67%
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int sum = 0, count = 0;
        for (int n: weight) {
            if (sum + n <= 5000) {
                sum += n;
                count++;
            }
        }
        return count;
    }
}
