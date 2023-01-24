package LeetCode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem909 {
    //https://leetcode.com/problems/snakes-and-ladders/
    public static void main(String[] args) {
        //System.out.println(snakesAndLadders(new int[][]{{16,15,14,13},{9,10,11,12},{8,7,6,5},{1,2,3,4}}));
        System.out.println(snakesAndLadders(new int[][]{{-1,-1,19,10,-1}, {2,-1,-1,6,-1}, {-1,17,-1,19,-1}, {25,-1,20,-1,-1}, {-1,-1,-1,-1,15}}));
        System.out.println(snakesAndLadders(new int[][]{{-1,-1,-1,-1,-1,-1}, {-1,-1,-1,-1,-1,-1}, {-1,-1,-1,-1,-1,-1}, {-1,35,-1,-1,13,-1}, {-1,-1,-1,-1,-1,-1}, {-1,15,-1,-1,-1,-1}}));
        System.out.println(snakesAndLadders(new int[][]{{-1,-1}, {-1,3}}));
        System.out.println(snakesAndLadders(new int[][]{{-1,4}, {-1,3}}));
    }

    //BFS part nnnn
    //1 hour
    //Runtime
    //9 ms
    //Beats
    //59.90%
    //Memory
    //42.5 MB
    //Beats
    //53.62%
    static int snakesAndLadders(int[][] board) {
        int m = board.length, n = board[0].length;
        int[] arr = new int[m * n];
        int c = 0, count = 0;
        for (int i = m - 1; i >= 0; i--) {
            if (count % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    arr[c++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    arr[c++] = board[i][j];
                }
            }
            count++;
        }
        System.out.println(Arrays.toString(arr));
        int stepCounter = 0;

        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(arr[0] > -1 ? arr[0] - 1 : 0);

        //while (curr < arr.length - 1) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                if (cur == n * n - 1) {
                    return stepCounter;
                }
                for (int next = cur + 1; next <= Math.min(cur + 6, n * n - 1); next++) {
                    int dest = arr[next] > -1 ? arr[next] - 1 : next;
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            stepCounter++;
        }
        return -1;
    }

    static int snakesAndLadders1(int[][] board) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = board.length - 1; i >= 0; i--) {
            if (count % 2 == 0) {
                sb.append("\n");
                for (int j = 0; j < board[0].length; j++) {
                    sb.append(board[i][j]).append(" ");
                }
            } else {
                sb.append("\n");
                for (int j = board[0].length - 1; j >= 0; j--) {
                    sb.append(board[i][j]).append(" ");
                }
            }
            count++;
        }
        System.out.println(sb);



        return 1;
    }
}
