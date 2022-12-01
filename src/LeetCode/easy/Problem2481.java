package LeetCode.easy;

public class Problem2481 {
    //https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/solutions/2865409/java-o-1-1-line-100-faster-explained/
    //1 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.1 MB
    //Beats
    //34.70%
    public int numberOfCuts(int n) {
        return n == 1 ? 0 : n % 2 == 0 ? n / 2 : n;
    }
}
