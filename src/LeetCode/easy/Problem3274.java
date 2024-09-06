package LeetCode.easy;

public class Problem3274 {
    //https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color/solutions/5745622/java-100-faster-if-else-solution/
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.04
    //MB
    //Beats
    //40.98%
    static boolean checkTwoChessboards(String a, String b) {
        int x1 = a.charAt(0) - 'a', y1 = a.charAt(1);
        int x2 = b.charAt(0) - 'a', y2 = b.charAt(1);

        int color1 = -1, color2 = -1;
        if (x1 % 2 == 0) {
            if (y1 % 2 == 0) {
                color1 = 0;
            } else {
                color1 = 1;
            }
        } else {
            if (y1 % 2 == 0) {
                color1 = 1;
            } else {
                color1 = 0;
            }
        }
        if (x2 % 2 == 0) {
            if (y2 % 2 == 0) {
                color2 = 0;
            } else {
                color2 = 1;
            }
        } else {
            if (y2 % 2 == 0) {
                color2 = 1;
            } else {
                color2 = 0;
            }
        }
        return color1 == color2;
    }
}
