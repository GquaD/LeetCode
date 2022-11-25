package LeetCode.easy;

public class Problem2469 {
    //https://leetcode.com/problems/convert-the-temperature/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/convert-the-temperature/solutions/2846734/java-0ms-o-1-1-line-solution/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.4 MB
    //Beats
    //63.28%
    static double[] convertTemperature(double c) {
        return new double[]{c + 273.15, c * 1.8 + 32.0};
    }
}
