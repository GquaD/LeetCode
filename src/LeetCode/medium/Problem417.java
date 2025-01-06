package LeetCode.medium;

import java.util.*;

public class Problem417 {
    //https://leetcode.com/problems/pacific-atlantic-water-flow/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/pacific-atlantic-water-flow/solutions/6237313/java-bfs-solution-by-tbekpro-69it/
    //25-30min
    //Runtime
    //55
    //ms
    //Beats
    //10.70%
    //Analyze Complexity
    //Memory
    //48.53
    //MB
    //Beats
    //6.96%
    public List<List<Integer>> pacificAtlantic(int[][] h) {
        //queue + bfs, record all for pacific into set of strings
        //queue + bfs, record all for atlantic into set of strings
        //find common strings and transform into arrays
        int rows = h.length, cols = h[0].length;
        Queue<String> q = new LinkedList<>();
        for (int c = 0; c < cols; c++) q.add(0 + "_" + c);
        for (int r = 1; r < rows; r++) q.add(r + "_" + 0);
        Set<String> pac = new HashSet<>(), atl = new HashSet<>();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (pac.contains(s)) continue;
                pac.add(s);

                String[] coord = s.split("_");
                int r = Integer.parseInt(coord[0]), c = Integer.parseInt(coord[1]);
                if (cellExists(r + 1, c, rows, cols) && h[r + 1][c] >= h[r][c]) {
                    q.offer((r + 1) + "_" + c);
                }
                if (cellExists(r, c + 1, rows, cols) && h[r][c + 1] >= h[r][c]) {
                    q.offer(r + "_" + (c + 1));
                }
                if (cellExists(r - 1, c, rows, cols) && h[r - 1][c] >= h[r][c]) {
                    q.offer((r - 1) + "_" + c);
                }
                if (cellExists(r, c - 1, rows, cols) && h[r][c - 1] >= h[r][c]) {
                    q.offer(r + "_" + (c - 1));
                }
            }
        }

        for (int c = 0; c < cols; c++) q.add((rows - 1) + "_" + c);
        for (int r = 0; r < rows - 1; r++) q.add(r + "_" + (cols - 1));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (atl.contains(s)) continue;
                atl.add(s);

                String[] coord = s.split("_");
                int r = Integer.parseInt(coord[0]), c = Integer.parseInt(coord[1]);
                if (cellExists(r - 1, c, rows, cols) && h[r - 1][c] >= h[r][c]) {
                    q.offer((r - 1) + "_" + c);
                }
                if (cellExists(r, c - 1, rows, cols) && h[r][c - 1] >= h[r][c]) {
                    q.offer(r + "_" + (c - 1));
                }
                if (cellExists(r + 1, c, rows, cols) && h[r + 1][c] >= h[r][c]) {
                    q.offer((r + 1) + "_" + c);
                }
                if (cellExists(r, c + 1, rows, cols) && h[r][c + 1] >= h[r][c]) {
                    q.offer(r + "_" + (c + 1));
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (String p: pac) {
            if (atl.contains(p)) {
                String[] coord = p.split("_");
                int r = Integer.parseInt(coord[0]), c = Integer.parseInt(coord[1]);
                List<Integer> l = new ArrayList<>();
                l.add(r);
                l.add(c);
                res.add(l);
            }
        }
        return res;
    }

    private boolean cellExists(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
