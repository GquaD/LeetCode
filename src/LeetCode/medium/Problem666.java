package LeetCode.medium;

public class Problem666 {
    //https://leetcode.com/problems/path-sum-iv/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/path-sum-iv/solutions/5982294/java-2d-array-solution/
    //10-15min
    //Runtime
    //1
    //ms
    //Beats
    //85.00%
    //Analyze Complexity
    //Memory
    //41.06
    //MB
    //Beats
    //65.06%
    public int pathSum(int[] nums) {
        int[][] arr = new int[5][16];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 16; j++) {
                arr[i][j] = -1;
            }
        }
        for (int n : nums) {
            int row = n / 100, col = (n / 10) % 10, val = n % 10;
            arr[row - 1][col - 1] = val;
        }
        int[] res = new int[1];
        goDFS(arr, 0, 0, 0, res);
        return res[0];
    }

    private void goDFS(int[][] arr, int row, int col, int pathSum, int[] res) {
        if (arr[row][col] == -1) return;
        pathSum += arr[row][col];
        if (arr[row + 1][col * 2] == -1 && arr[row + 1][col * 2 + 1] == -1) {
            res[0] += pathSum;
        }
        goDFS(arr, row + 1, col * 2, pathSum, res);
        goDFS(arr, row + 1, col * 2 + 1, pathSum, res);
    }
}
