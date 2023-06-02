package LeetCode.medium;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2101 {
    //https://leetcode.com/problems/detonate-the-maximum-bombs/
    public static void main(String[] args) {
        System.out.println(maximumDetonation(new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}}));
        System.out.println(maximumDetonation(new int[][]{{2,1,3}, {6,1,4}}));
    }

    //https://leetcode.com/problems/detonate-the-maximum-bombs/solutions/3589949/java-bfs-solution/
    //20 -25 min
    //Runtime
    //123 ms
    //Beats
    //55.50%
    //Memory
    //43.7 MB
    //Beats
    //17.35%
    static int maximumDetonation(int[][] bombs) {
        Arrays.sort(bombs, (o1, o2) -> o2[2] - o1[2]);
        int res = 0;
        for (int i = 0; i < bombs.length; i++) {
            int[][] copy = Arrays.copyOf(bombs, bombs.length);
            int count = 1;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(copy[i]);
            copy[i] = null;
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                int y = arr[1], x = arr[0], r = arr[2];
                for (int j = 0; j < copy.length; j++) {
                    int[] b = copy[j];
                    if (b == null) continue;
                    int y1 = b[1], x1 = b[0], r1 = b[2];
                    double dist = Math.sqrt(Math.pow(y - y1, 2) + Math.pow(x - x1, 2));
                    if (dist <= r) {
                        count++;
                        queue.offer(b);
                        copy[j] = null;
                    }
                }
            }
            res = Math.max(count, res);
        }
        return res;
    }
}
