package LeetCode.medium;

public class Problem1523 {
    //https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/solutions/3179117/java-o-1-1-line-solution/
    //less than 5 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.3 MB
    //Beats
    //43.83%
    static int countOdds(int low, int high) {
        return (low % 2 == 1 || high % 2 == 1) ? (high - low) / 2 + 1 : (high - low) / 2;
    }
}
