package LeetCode.easy;

public class Problem3707 {
    //2min
    //https://leetcode.com/problems/equal-score-substrings/
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.27
    //MB
    //Beats
    //95.79%
    public static void main(String[] args) {

    }

    public boolean scoreBalance(String s) {
        int score = 0, temp = 0;
        for (int i = 0; i < s.length(); i++) {
            score += (s.charAt(i) - 'a') + 1;
        }

        for (int i = 0; i < s.length(); i++) {
            temp += (s.charAt(i) - 'a') + 1;
            if (score - temp == temp) return true;
        }
        return false;
    }

//    public double maxAverageRatio(int[][] classes, int e) {
//        Arrays.sort(classes, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
//        double sum = 0.0;
//        for (int[] class: classes) {
//            int all = class[1], pass = class[0];
//            int diff = all - pass;
//            if (e >= diff) {
//                pass = all;
//                e -= diff;
//            } else {
//                pass += e;
//                e = 0;
//            }
//            sum += pass * 1.0 / all;
//        }
//        return sum / classes.length;
//    }
}
