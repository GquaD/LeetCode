package LeetCode.hard;

public class Problem829 {
    //https://leetcode.com/problems/consecutive-numbers-sum/description/
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/consecutive-numbers-sum/solutions/4014228/java-o-sqrt-n-solution/
    //30-35min
    //Runtime
    //4 ms
    //Beats
    //61.75%
    //Memory
    //39.1 MB
    //Beats
    //74.4%
    static int consecutiveNumbersSum(int n) {
        int count = 0, i = 0, sum = 0;
        while (sum < n) {
            if ((n - sum) % (i + 1) == 0) count++;
            i++;
            sum = i * (i + 1) / 2;
        }
        return count;
    }

    //Wrong Answer
    //167 / 170
    static int consecutiveNumbersSum1(int n) {
        int sqrt = (int) Math.sqrt(n);
        int count = 1;
        for (int i = 1; i <= sqrt + 1; i++) {
            int sum = i * (i + 1) / 2;
            if ((n - sum) % (i + 1) == 0) count++;
        }
        return count;
    }
}
