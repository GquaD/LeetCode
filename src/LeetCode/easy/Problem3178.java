package LeetCode.easy;

public class Problem3178 {
    //https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds
    public static void main(String[] args) {

    }
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.84
    //MB
    //Beats
    //40.59%
    public int numberOfChild(int n, int k) {
        int t = 0, count = 0;
        boolean right = true;
        while (count < k) {
            count++;
            if (right) {
                if (t < n - 1) {
                    t++;
                } else {
                    right = false;
                    t--;
                }
            } else {
                if (t > 0) {
                    t--;
                } else {
                    right = true;
                    t++;
                }
            }
        }
        return t;
    }
}
