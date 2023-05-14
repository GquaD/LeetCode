package LeetCode.easy;

public class Problem661 {
    //https://leetcode.com/problems/image-smoother/
    public static void main(String[] args) {

    }


    //10 min
    //Runtime
    //10 ms
    //Beats
    //22.91%
    //Memory
    //43.8 MB
    //Beats
    //33.48%
    static int[][] imageSmoother(int[][] img) {
        int[][] arr = new int[img.length][img[0].length];
        for (int y = 0; y < img.length; y++) {
            for (int x = 0; x < img[0].length; x++) {
                int count = 0, sum = 0;
                if (cellExists(y - 1, x - 1, img)) {
                    count++;
                    sum += img[y - 1][x - 1];
                }
                if (cellExists(y - 1, x, img)) {
                    count++;
                    sum += img[y - 1][x];
                }
                if (cellExists(y - 1, x + 1, img)) {
                    count++;
                    sum += img[y - 1][x + 1];
                }
                if (cellExists(y, x - 1, img)) {
                    count++;
                    sum += img[y][x - 1];
                }

                count++;
                sum += img[y][x];

                if (cellExists(y, x + 1, img)) {
                    count++;
                    sum += img[y][x + 1];
                }
                if (cellExists(y + 1, x - 1, img)) {
                    count++;
                    sum += img[y + 1][x - 1];
                }
                if (cellExists(y + 1, x, img)) {
                    count++;
                    sum += img[y + 1][x];
                }

                if (cellExists(y + 1, x + 1, img)) {
                    count++;
                    sum += img[y + 1][x + 1];
                }
                arr[y][x] = sum / count;
            }
        }
        return arr;
    }

    static boolean cellExists(int y, int x, int[][] grid) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }
}
