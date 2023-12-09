package LeetCode.medium;

import java.util.Arrays;
import java.util.List;

public class Problem2033 {
    //https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/
    public static void main(String[] args) {
        System.out.println(minOperations(new int[][]{{1,2}, {1,2}}, 2));
        System.out.println(minOperations(new int[][]{{1,2}, {3,4}}, 2));
        System.out.println(minOperations(new int[][]{{2,4}, {6,8}}, 2));
        System.out.println(minOperations(new int[][]{{1,5}, {2,3}}, 1));
    }

    //https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/solutions/4383010/java-o-nlogn-solution/
    //40min
    //Runtime
    //39 ms
    //Beats
    //50.92%
    //Memory
    //72 MB
    //Beats
    //49.69%
    static int minOperations(int[][] grid, int x) {
        int sum = 0, m = grid.length, n = grid[0].length, c = 0;
        int[] arr = new int[m * n];
        boolean containsEven = false, containsOdd = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
                arr[c++] = grid[i][j];
                if (!containsEven || !containsOdd) {
                    if (grid[i][j] % 2 == 1) containsOdd = true;
                    else containsEven = true;
                }
            }
        }
        if (containsEven && containsOdd && x % 2 == 0) return -1;
        Arrays.sort(arr);
        int preSum = 0, postSum = sum - arr[0];
        int diff = Math.abs(postSum - (arr[0] * (arr.length - 1)));
        int ops = diff % x == 0 ? diff / x : Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            preSum += arr[i - 1];
            int diffLeft = Math.abs(i * curr - preSum),
                    opsLeft = diffLeft % x == 0 ? diffLeft / x : -1;

            postSum -= curr;
            int diffRight = Math.abs((arr.length - i - 1) * curr - postSum),
                    opsRight = diffRight % x == 0 ? diffRight / x : -1;

            if (opsLeft != -1 && opsRight != -1) {
                ops = Math.min(ops, opsLeft + opsRight);
            } else {
                return -1;
            }
        }
        return ops;
    }

    static int minOperations1(int[][] grid, int x) {
        int sum = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) sum += grid[i][j];
        int count = m * n - 1, diff = Integer.MAX_VALUE, prev = 0, presum = 0, countPre = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = grid[i][j];
                sum -= curr;
                sum += prev;
                int sumAllCurr = count * curr;
                int diffTemp = Math.abs(sum - sumAllCurr);
                if (diffTemp % x == 0) diff = Math.min(diff, diffTemp / count);
                prev = curr;
            }
        }
        return diff == Integer.MAX_VALUE ? -1 : diff;
    }
}
