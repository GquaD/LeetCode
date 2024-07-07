package LeetCode.easy;

public class Problem1518 {
    //https://leetcode.com/problems/water-bottles
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/water-bottles/solutions/5435493/java-100-faster/
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.32
    //MB
    //Beats
    //28.61%
    static int numWaterBottles(int n, int e) {
        int res = n;
        while (n >= e) {
            res += n / e;
            n = n / e + n % e;
        }
        return res;
    }
}
