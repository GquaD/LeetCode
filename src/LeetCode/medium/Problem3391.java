package LeetCode.medium;

public class Problem3391 {

    //https://leetcode.com/problems/design-a-3d-binary-matrix-with-efficient-layer-tracking/solutions/6170871/java-100-faster-solution-by-tbekpro-i2a5/
    //10min
    //Runtime
    //245
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //111.66
    //MB
    //Beats
    //100.00%
    class Matrix3D {

        int[][][] m;
        int[][] yy;
        int nn;

        public Matrix3D(int n) {
            m = new int[n][n][n];
            yy = new int[n][n];
            nn = n;
        }

        public void setCell(int x, int y, int z) {
            m[x][y][z] = 1;
            calculateyy(x, y);
        }

        public void unsetCell(int x, int y, int z) {
            m[x][y][z] = 0;
            calculateyy(x, y);
        }

        public int largestMatrix() {
            int max = 0, idx = 0;
            for (int x = 0; x < nn; x++) {
                int sum = 0;
                for (int y = 0; y < nn; y++) {
                    sum += yy[x][y];
                }
                if (max <= sum) {
                    idx = x;
                    max = sum;
                }
            }
            return idx;
        }

        private void calculateyy(int x, int y) {
            int sum = 0;
            for (int i = 0; i < nn; i++) {
                sum += m[x][y][i];
            }
            yy[x][y] = sum;
        }
    }
}
