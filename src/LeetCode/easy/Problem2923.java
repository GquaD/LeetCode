package LeetCode.easy;

public class Problem2923 {
    //https://leetcode.com/problems/find-champion-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-champion-i/solutions/5839531/java-count-0-s-solution/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //74.95%
    //Analyze Complexity
    //Memory
    //45.20
    //MB
    //Beats
    //74.12%
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int count0 = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count0++;
                if (count0 > 1) break;
            }
            if (count0 == 1) return i;
        }
        return n;
    }
}
