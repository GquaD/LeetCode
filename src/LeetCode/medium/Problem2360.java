package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem2360 {
    //https://leetcode.com/problems/longest-cycle-in-a-graph/
    public static void main(String[] args) {
        System.out.println(longestCycle(new int[]{3, 3, 4, 2, 3}));
        System.out.println(longestCycle(new int[]{2, -1, 3, 1}));
    }

    static List<List<Integer>> listGroups;

    static int longestCycle(int[] edges) {
        listGroups = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i < n; i++) listGroups.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != -1) {
                listGroups.get(i).add(edges[i]);
                //listGroups.get(edges[i]).add(i);
            }
        }

        int max = -1, sum = n;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int[] mem = new int[]{-1};
            int currSize = gogoDFS(i, visited, new int[1], mem);
            if (max < currSize && mem[0] != -1) max = currSize;
            visited = new boolean[n];
        }
        return max;
    }

    private static int gogoDFS(int curr, boolean[] visited, int[] count, int[] mem) {
        if (visited[curr]) {
            mem[0] = curr;
            return count[0];
        }
        visited[curr] = true;
        for (int n : listGroups.get(curr)) {
            gogoDFS(n, visited, count, mem);
        }
        if (curr != mem[0]) count[0]++;
        return count[0];
    }

//    public long countPairs(int n, int[][] edges) {
//        for (int i = 0; i < n; i++) listGroups.add(new ArrayList<>());
//        for (int edge[] : edges) {
//            listGroups.get(edge[0]).add(edge[1]);
//            listGroups.get(edge[1]).add(edge[0]);
//        }
//
//        long res = 0, sum = n;
//        boolean[] visited = new boolean[n];
//        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                int curr = gogoDFS(i, visited, new int[1]);
//                sum = sum - curr;
//                res += curr * sum;
//            }
//        }
//        return res;
//    }
}
