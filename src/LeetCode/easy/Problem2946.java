package LeetCode.easy;

public class Problem2946 {
    //20min

    //Runtime
    //4
    //ms
    //Beats
    //3.73%
    //Memory
    //47.04
    //MB
    //Beats
    //41.60%
    public boolean areSimilar(int[][] mat, int k) {
        String d = "_";
        int m = mat.length, n = mat[0].length, offset = k % n;
        if (offset == 0) return true;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i+=2) {
            for (int j = 0; j < n; j++) {
                sb.append(mat[i][j]).append(d);
            }
            String original = sb.toString();
            sb.setLength(0);
            for (int j = offset; j < n; j++) {
                sb.append(mat[i][j]).append(d);
            }

            for (int j = 0; j < offset; j++) {
                sb.append(mat[i][j]).append(d);
            }
            if (!original.equals(sb.toString())) return false;
            sb.setLength(0);
        }

        for (int i = 1; i < m; i+=2) {
            for (int j = 0; j < n; j++) {
                sb.append(mat[i][j]).append(d);
            }
            String original = sb.toString();
            sb.setLength(0);
            for (int j = n - offset; j < n; j++) {
                sb.append(mat[i][j]).append(d);
            }

            for (int j = 0; j < n - offset; j++) {
                sb.append(mat[i][j]).append(d);
            }
            if (!original.equals(sb.toString())) return false;
            sb.setLength(0);
        }
        return true;
    }
}
