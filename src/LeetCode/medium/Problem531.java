package LeetCode.medium;

public class Problem531 {
    //https://leetcode.com/problems/lonely-pixel-i/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/lonely-pixel-i/solutions/4982877/java-o-n-solution/
    //15-20min
    //Runtime
    //2
    //ms
    //Beats
    //98.21%
    //of users with Java
    //Memory
    //46.99
    //MB
    //Beats
    //64.29%
    //of users with Java
    private char b = 'B';
    private int m, n;

    public int findLonelyPixel(char[][] p) {
        int count = 0;
        m = p.length;
        n = p[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = p[i][j];
                if (c == b && isLonely(p, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isLonely(char[][] p, int r, int c) {
        int countR = 0, countC = 0;
        for (int i = 0; i < n; i++) {
            if (p[r][i] == b) countR++;
            if (countR > 1) return false;
        }

        for (int i = 0; i < m; i++) {
            if (p[i][c] == b) countC++;
            if (countC > 1) return false;
        }

        return countR == countC && countR == 1;
    }
}
