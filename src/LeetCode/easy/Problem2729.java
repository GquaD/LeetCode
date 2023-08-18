package LeetCode.easy;

public class Problem2729 {
    //https://leetcode.com/problems/check-if-the-number-is-fascinating/
    public static void main(String[] args) {

    }

    //5 min
    //Runtime
    //9 ms
    //Beats
    //54.90%
    //Memory
    //40.2 MB
    //Beats
    //58.39%
    static boolean isFascinating(int n) {
        String s = n + "" + (2 * n) + (3 * n);
        if (s.length() != 9) return false;
        boolean arr[] = new boolean[9];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - '0' - 1;
            if (idx >= 0 && idx <= 8) {
                if (arr[idx]) return false;
                else arr[idx] = true;
            } else return false;
        }
        return true;
    }
}
