package LeetCode.medium;

public class Problem1151 {
    //https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/solutions/5635117/java-sliding-window-o-n-solution/
    //5-10min
    //Runtime
    //8
    //ms
    //Beats
    //46.04%
    //Analyze Complexity
    //Memory
    //57.38
    //MB
    //Beats
    //92.24%
    public int minSwaps(int[] data) {
        int ones = 0, count = 0;
        for (int n : data) if (n == 1) ones++;
        for (int i = 0; i < ones; i++) if (data[i] == 1) count++;
        int min = ones - count;
        for (int i = ones; i < data.length; i++) {
            if (data[i] == 1) count++;
            if (data[i - ones] == 1) count--;
            min = Math.min(min, ones - count);
        }
        return min;
    }
}
