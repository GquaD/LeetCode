package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem207 {
    //https://leetcode.com/problems/course-schedule/description/
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
    }

    //nnnn
    //Runtime
    //3 ms
    //Beats
    //95.24%
    //Memory
    //43.6 MB
    //Beats
    //91.60%
    static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> listAdj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) listAdj.add(new ArrayList<>());
        for (int[] arr : prerequisites) listAdj.get(arr[0]).add(arr[1]);
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) if (!dfs(i, listAdj, visited)) return false;
        return true;
    }

    private static boolean dfs(int i, List<List<Integer>> listAdj, int[] visited) {
        if (visited[i] == 1) return false;
        if (visited[i] == 2) return true;
        visited[i] = 1;

        List<Integer> adj = listAdj.get(i);
        for (int k : adj) if (!dfs(k, listAdj, visited)) return false;

        visited[i] = 2;
        return true;
    }

    private static void dfs1(int i, List<List<Integer>> listAdj, int[] visited, boolean[] res) {
        if (i >= listAdj.size()) return;
        if (!res[0] || visited[i] == 1) {
            res[0] = false;
            return;
        }

        visited[i] = 1;
        List<Integer> adj = listAdj.get(i);
        for (int j = 0; j < adj.size(); j++) {
            dfs1(adj.get(j), listAdj, visited, res);
            if (!res[0]) return;
        }
        visited[i] = 2;
    }
}
