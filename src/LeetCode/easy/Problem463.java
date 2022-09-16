package LeetCode.easy;

public class Problem463 {
    //
    public static void main(String[] args) {

    }

    //counts sides for each cell
    //Runtime: 11 ms, faster than 58.01% of Java online submissions for Island Perimeter.
    //Memory Usage: 62 MB, less than 68.65% of Java online submissions for Island Perimeter.
    static int islandPerimeter(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) continue;
                if(i==0 || grid[i-1][j]==0) count++;
                if(i==m-1 || grid[i+1][j]==0) count++;
                if(j==0 || grid[i][j-1]==0) count++;
                if(j==n-1 || grid[i][j+1]==0) count++;
            }
        }
        return count;
    }

    //failed solution
    static int islandPerimeter1(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        return count * 4 - (grid.length * grid[0].length);
    }
}
