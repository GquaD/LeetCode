package LeetCode.easy;

public class Problem1422 {
    //https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/
    public static void main(String[] args) {

    }

    //
    //3min
    //Runtime
    //1 ms
    //Beats
    //97.78%
    //Memory
    //41 MB
    //Beats
    //36%
    static int maxScore(String s) {
        int count1 = 0, count0 = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count1++;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') count1--;
            else count0++;
            max = Math.max(max, count0 + count1);
        }
        return max;
    }
}
