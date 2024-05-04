package LeetCode.medium;
import java.util.*;

public class Problem353 {

}

//https://leetcode.com/problems/design-snake-game/solutions/5111079/my-hero-java-solution/

//40min
//Runtime
//66
//ms
//Beats
//15.71%
//of users with Java
//Memory
//49.67
//MB
//Beats
//69.92%
//of users with Java
class SnakeGame {
    int cols, rows, row, col, size;
    LinkedHashSet<String> set;
    Queue<int[]> queue;
    public SnakeGame(int width, int height, int[][] food) {
        rows = height;
        cols = width;
        row = 0;
        col = 0;
        size = 0;

        set = new LinkedHashSet<>();
        set.add(row + "_" + col);

        queue = new LinkedList<>();
        for (int[] arr : food)
            queue.offer(arr);
    }

    public int move(String direction) {
        int rShift = 0, cShift = 0;
        if (direction.equals("U")) {
            rShift = -1;
        } else if (direction.equals("R")) {
            cShift = 1;
        } else if (direction.equals("D")) {
            rShift = 1;
        } else {
            cShift = -1;
        }
        row += rShift;
        col += cShift;

        if (cellExists(row, col, rows, cols)) {
            int[] f = queue.peek();
            if (f != null && f[0] == row && f[1] == col) {
                size++;
                queue.poll();
            }

            while (set.size() > size) {
                String first = "";
                for (String s : set) {
                    first = s;
                    break;
                }
                set.remove(first);
            }

            if (set.contains(row + "_" + col)) {
                return -1;
            }
            set.add(row + "_" + col);
        } else {
            return -1;
        }
        return size;
    }


    private boolean cellExists(int r, int c, int h, int w) {
        return r >= 0 && r < h && c >= 0 && c < w;
    }
}
