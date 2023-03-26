package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2360 {
    //https://leetcode.com/problems/longest-cycle-in-a-graph/
    public static void main(String[] args) {
        //System.out.println(longestCycle(new int[]{}));
        System.out.println(longestCycle(new int[]{1,2,0,4,5,6,3,8,9,7}));
        System.out.println(longestCycle(new int[]{3, 3, 4, 2, 3}));
        System.out.println(longestCycle(new int[]{2, -1, 3, 1}));
    }

    //nnnn
    //Runtime
    //48 ms
    //Beats
    //64.9%
    //Memory
    //62.3 MB
    //Beats
    //65.64%
    static int longestCycle(int[] edges) {
        int res = -1;
        int[][] mem = new int[edges.length][2];
        Arrays.fill(mem, new int[]{-1,-1});

        for (int i = 0; i < edges.length; i++) {
            for (int j = i, dist = 0; j != -1; j = edges[j]) {
                int distI = mem[j][0], fromI = mem[j][1];
                if (distI == -1){
                    mem[j] = new int[]{dist++, i};
                } else {
                    if (fromI == i) res = Math.max(res, dist - distI);
                    break;
                }
            }
        }
        return res;
    }

    //TLE 63/76
    static List<List<Integer>> listGroups;

    static int longestCycle1(int[] edges) {
        listGroups = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i < n; i++) listGroups.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != -1) {
                listGroups.get(i).add(edges[i]);
            }
        }

        int max = -1, sum = n;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int[] mem = new int[]{-1}, count = new int[]{0};
            boolean[] startVisited = new boolean[1];
            goDFSFindCycle(i, visited, count, mem, startVisited);
            int currSize = count[0];
            if (max < currSize && mem[0] != -1) max = currSize;
            visited = new boolean[n];
        }
        return max;
    }

    private static void goDFSFindCycle(int curr, boolean[] visited, int[] count, int[] mem, boolean[] startVisited) {
        if (visited[curr]) {
            mem[0] = curr;
            count[0]++;
            return;
        }
        visited[curr] = true;
        for (int n : listGroups.get(curr)) {
            goDFSFindCycle(n, visited, count, mem, startVisited);
        }
        if (curr != mem[0] && !startVisited[0]) count[0]++;
        else if (curr == mem[0]) startVisited[0] = true;
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
