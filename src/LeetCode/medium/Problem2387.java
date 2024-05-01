package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem2387 {
    //https://leetcode.com/problems/median-of-a-row-wise-sorted-matrix/
    public static void main(String[] args) {

    }

    //15-20min
    //was thinking of O(m * n) better solution
    //Runtime
    //111
    //ms
    //Beats
    //9.52%
    //of users with Java
    //Memory
    //88.45
    //MB
    //Beats
    //5.95%
    //of users with Java
    static int matrixMedian(int[][] grid) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int m = grid.length, n = grid[0].length, size = (m * n / 2) + 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pq.size() == size) {
                    int p = pq.poll();
                    if (p <= grid[i][j])
                        pq.offer(p);
                    else
                        pq.offer(grid[i][j]);
                } else {
                    pq.offer(grid[i][j]);
                }
            }
        }
        return pq.poll();
    }
}
