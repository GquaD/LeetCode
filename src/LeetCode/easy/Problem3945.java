package LeetCode.easy;

public class Problem3945 {
    //2min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //42.62
    //MB
    //Beats
    //100.00%
    public int digitFrequencyScore(int n) {
        int[] freq = new int[11];
        while(n > 0) {
            freq[n % 10]++;
            n /= 10;
        }

        for (int d = 1; d < 10; d++) {
            freq[10] += freq[d] * d;
        }
        return freq[10];
    }
}
