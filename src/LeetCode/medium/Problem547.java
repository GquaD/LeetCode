package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem547 {
    //https://leetcode.com/problems/number-of-provinces/
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1,1,0}, {1,1,0}, {0,0,1}}));
        System.out.println(findCircleNum(new int[][]{{1,0,0}, {0,1,0}, {0,0,1}}));
    }

    //https://leetcode.com/problems/number-of-provinces/solutions/3598385/java-dfs-from-3ms-to-1ms-solution/
    //20 min
    //Runtime
    //1 ms
    //Beats
    //98.95%
    //Memory
    //44.1 MB
    //Beats
    //23.74%
    static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }

    private static void dfs(int i, int[][] isConnected, boolean[] visited) {
        if (visited[i]) return;

        visited[i] = true;
        for (int j = 0; j < isConnected[i].length; j++) if (isConnected[i][j] == 1) dfs(j, isConnected, visited);
    }

    //
    //15-20 min
    //Runtime
    //3 ms
    //Beats
    //34.72%
    //Memory
    //44.7 MB
    //Beats
    //5.13%
    static int findCircleNum1(int[][] isConnected) {
        List<List<Integer>> listAdj = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            int[] province = isConnected[i];
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < province.length; j++) if (province[j] == 1) list.add(j);
            listAdj.add(list);
        }
        boolean visited[] = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                dfs1(i, listAdj, visited);
            }
        }
        return count;
    }

    private static void dfs1(int i, List<List<Integer>> listAdj, boolean[] visited) {
        if (visited[i]) return;

        visited[i] = true;
        List<Integer> list = listAdj.get(i);
        for (int n : list) dfs1(n, listAdj, visited);
    }
}
