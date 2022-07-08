package LeetCode;

import java.util.Arrays;

public class Problem733 {
    static boolean[][] visited;

    //https://leetcode.com/problems/flood-fill/submissions/
    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        floodFill(image, 1, 1, 2);
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }
    }

    //Runtime: 1 ms, faster than 90.26% of Java online submissions for Flood Fill.
    //Memory Usage: 48.4 MB, less than 22.62% of Java online submissions for Flood Fill.
    static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited = new boolean[image.length][image[0].length];
        fillRecursively(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private static boolean cellExist(int row, int col) {
        return (row <= visited.length - 1 && row >= 0) && (col <= visited[0].length - 1 && col >= 0);
    }

    static boolean changeColor(int[][] image, int tr, int tc,
                               int value, int color) {
        if (value == image[tr][tc]) {
            image[tr][tc] = color;
            return true;
        }
        return false;
    }

    private static void fillRecursively(int[][] image, int sr, int sc, int color, int value) {
        if (cellExist(sr, sc)) {
            if (visited[sr][sc] || image[sr][sc] != value) {
                return;
            } else {
                changeColor(image, sr, sc, value, color);
                visited[sr][sc] = true;
            }
        }

        if (cellExist(sr - 1, sc)) {
            fillRecursively(image, sr - 1, sc, color, value);
        }
        if (cellExist(sr, sc + 1)) {
            fillRecursively(image, sr, sc + 1, color, value);
        }
        if (cellExist(sr + 1, sc)) {
            fillRecursively(image, sr + 1, sc, color, value);
        }
        if (cellExist(sr, sc - 1)) {
            fillRecursively(image, sr, sc - 1, color, value);
        }
    }


}
