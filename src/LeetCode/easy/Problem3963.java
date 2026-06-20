package LeetCode.easy;

public class Problem3963 {
    //5min
    //Runtime
    //4
    //ms
    //Beats
    //-%
    //Memory
    //46.68
    //MB
    //Beats
    //50.00%
    public String[] createGrid(int rows, int cols) {
        String temp[][] = new String[rows][cols], res[] = new String[rows];
        for (int i = 0; i < cols; i++) temp[0][i] = ".";
        for (int i = 0; i < rows; i++) temp[i][cols - 1] = ".";

        StringBuilder sb;
        for (int i = 0; i < rows; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < cols; j++) {
                if (temp[i][j] == ".") sb.append(".");
                else sb.append("#");
            }
            res[i] = sb.toString();
        }

        return res;
    }
}
