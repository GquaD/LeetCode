package LeetCode.easy;

public class Problem2485 {
    //https://leetcode.com/problems/find-the-pivot-integer/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-pivot-integer/solutions/2858868/java-100-faster-2-lines-o-1-solution-explained/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.2 MB
    //Beats
    //95.34%
    static int pivotInteger(int n) {
        double root = Math.sqrt(((1 + n) * n) / 2.0);
        return root % 1 == 0 ? (int) root : -1;
    }
}
