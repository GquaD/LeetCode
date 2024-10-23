package LeetCode.medium;

public class Problem1861 {
    //https://leetcode.com/problems/rotating-the-box
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/rotating-the-box/solutions/5957230/java-o-n-solution/
    //15min
    //Runtime
    //9
    //ms
    //Beats
    //42.36%
    //Analyze Complexity
    //Memory
    //79.46
    //MB
    //Beats
    //60.76%
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        for (int i = 0; i < m; i++) {
            int s = 0, prev = 0;
            for (int j = 0; j < n; j++) {
                if (box[i][j] == '#')
                    s++;
                else if (box[i][j] == '*') {
                    for (int k = prev; k < j; k++) {
                        box[i][k] = '.';
                    }
                    for (int k = j - s; k < j; k++) {
                        box[i][k] = '#';
                    }
                    prev = j + 1;
                    s = 0;
                }
            }
            if (s > 0) {
                for (int k = prev; k < n; k++) {
                    box[i][k] = '.';
                }
                for (int k = n - s; k < n; k++) {
                    box[i][k] = '#';
                }
            }
        }
        //rotate
        char[][] res = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = box[m - j - 1][i];
            }
        }
        return res;
    }
}
