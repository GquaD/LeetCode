package LeetCode.easy;

public class Problem3340 {
    //https://leetcode.com/problems/check-balanced-string/
    public static void main(String[] args) {

    }

    //1min
    //Runtime
    //1
    //ms
    //Beats
    //99.38%
    //Analyze Complexity
    //Memory
    //42.04
    //MB
    //Beats
    //71.84%
    public boolean isBalanced(String num) {
        int a = 0, b = 0;
        for (int i = 0; i < num.length(); i++) {
            int k = num.charAt(i) - '0';
            if (i % 2 == 0) {
                a += k;
            } else {
                b += k;
            }
        }
        return a == b;
    }
}
