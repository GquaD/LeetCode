package LeetCode.medium;

public class Problem221 {
    //https://leetcode.com/problems/maximal-square/
    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{{'0', '1', '1', '0', '1'}, {'1', '1', '0', '1', '0'}, {'0', '1', '1', '1', '0'}, {'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1'}, {'0', '0', '0', '0', '0'}}));
        System.out.println(maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println(maximalSquare(new char[][]{{'1', '1'}, {'1', '1'}}));
        System.out.println(maximalSquare(new char[][]{{'0', '1'}, {'0', '1'}}));
    }

    //https://leetcode.com/problems/maximal-square/solutions/3200301/java-2-slowpoke-solutions/
    //Runtime
    //85 ms
    //Beats
    //6.16%
    //Memory
    //54.5 MB
    //Beats
    //57.59%
    static int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, min = Math.min(m, n);
        int[][] arrH = new int[m][n];
        for (int r = 0; r < m; r++) {
            int count = 0;
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == '1') arrH[r][c] = ++count;
                else count = 0;
            }
        }

        int[][] arrV = new int[m][n];
        for (int c = 0; c < n; c++) {
            int count = 0;
            for (int r = 0; r < m; r++) {
                if (matrix[r][c] == '1') arrV[r][c] = ++count;
                else count = 0;
            }
        }

        int max = 0;
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < m; r++) {
                int minC = Math.min(arrH[r][c], arrV[r][c]);
                if (max < minC) {
                    while (minC > max) {
                        if (noZeros(r,c,matrix,minC)) {
                            max = minC;
                            break;
                        }
                        minC--;
                    }
                }
            }
        }
        return max * max;
    }

    private static boolean noZeros(int row, int col, char[][] matrix, int minC) {
        for (int r = row - minC + 1; r < row; r++) {
            for (int c = col - minC + 1; c < col; c++) {
                if (matrix[r][c] == '0') return false;
            }
        }
        return true;
    }

    /*if (size == 1) {
        found = true;
        size++;
        break;
    } else*/


    //brute force solution, slowpoke
    //20-30 min
    //Runtime
    //51 ms
    //Beats
    //8.8%
    //Memory
    //55.6 MB
    //Beats
    //29.2%
    static int maximalSquare1(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, min = Math.min(m, n);
        int minSize = 1;
        while (minSize <= min) {
            boolean squareFound = false;
            outerloop:
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (r + minSize > m || c + minSize > n) break;
                    int curR = Math.min(r + minSize, m), curC = Math.min(c + minSize, n);
                    boolean squareExistsTemp = true;
                    insideloop:
                    for (int i = r; i < curR; i++) {
                        for (int j = c; j < curC; j++) {
                            if (matrix[i][j] == '0') {
                                squareExistsTemp = false;
                                break insideloop;
                            }
                        }
                    }
                    if (squareExistsTemp) {
                        squareFound = true;
                        minSize++;
                        break outerloop;
                    }
                }
            }
            if (!squareFound) break;
        }
        minSize--;
        return minSize * minSize;
    }
}
