package LeetCode.medium;

import java.util.*;

public class Problem2316 {
    //https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/
    public static void main(String[] args) {

    }

    //nnnn with some my modifications
    //Runtime
    //65 ms
    //Beats
    //47.51%
    //Memory
    //125.5 MB
    //Beats
    //27.97%
    static List<List<Integer>> listGroups = new ArrayList<>();

    public long countPairs(int n, int[][] edges) {
        for (int i = 0; i < n; i++) listGroups.add(new ArrayList<>());
        for (int edge[] : edges) {
            listGroups.get(edge[0]).add(edge[1]);
            listGroups.get(edge[1]).add(edge[0]);
        }

        long res = 0, sum = n;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int curr = gogoDFS(i, visited, new int[1]);
                sum = sum - curr;
                res += curr * sum;
            }
        }
        return res;
    }

    private int gogoDFS(int curr, boolean[] visited, int[] count) {
        if (visited[curr]) return count[0];
        visited[curr] = true;
        count[0]++;
        for (int n : listGroups.get(curr)) {
            gogoDFS(n, visited, count);
        }
        return count[0];
    }


    //my solution based on solution for https://leetcode.com/problems/number-of-operations-to-make-network-connected/
    //Runtime
    //1294 ms
    //Beats
    //5.37%
    //Memory
    //125.4 MB
    //Beats
    //28.74%
    static long countPairs1(int n, int[][] edges) {
        if (edges.length == 0) {
            return ((1L + (n - 1L)) * (n - 1L)) / 2L;
        }
        List<List<Integer>> listAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) listAdj.add(new ArrayList<>());
        for (int[] conn : edges) {
            listAdj.get(conn[0]).add(conn[1]);
            listAdj.get(conn[1]).add(conn[0]);
        }
        boolean[] visited = new boolean[n];
        int groups = 0;
        Map<Integer, Integer> mapNodesNumber = new HashMap<>();
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                mapNodesNumber.put(groups, 0);
                goDFS(listAdj, i, visited, mapNodesNumber, groups);
                int count = mapNodesNumber.get(groups);

                groups++;
            }
        }
        ArrayList<Integer> amounts = new ArrayList<>(mapNodesNumber.values());
        for (int i = 0; i < amounts.size() - 1; i++) {
            for (int j = i + 1; j < amounts.size(); j++) {
                res += 1L * amounts.get(i) * amounts.get(j);
            }
        }
        return res;
    }

    private static void goDFS(List<List<Integer>> listAdj, int computer, boolean[] visited, Map<Integer, Integer> mapNodesNumber, int group) {
        if (visited[computer]) return;
        visited[computer] = true;

        mapNodesNumber.put(group, mapNodesNumber.get(group) + 1);

        for (int pc : listAdj.get(computer)) {
            goDFS(listAdj, pc, visited, mapNodesNumber, group);
        }
    }
}
