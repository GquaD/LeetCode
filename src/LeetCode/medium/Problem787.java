package LeetCode.medium;

import java.util.*;
import java.util.LinkedList;

public class Problem787 {
    //https://leetcode.com/problems/cheapest-flights-within-k-stops/
    public static void main(String[] args) {
        System.out.println(findCheapestPrice(5, new int[][]{{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}},
                2, 1, 1));
        System.out.println(findCheapestPrice(4, new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}},
                0, 3, 1));
    }

    //nnnn
    //Runtime
    //7 ms
    //Beats
    //58.6%
    //Memory
    //43.3 MB
    //Beats
    //65.13%
    static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] i : flights)
            adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] { i[1], i[2] });

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { src, 0 });
        int stops = 0;

        while (stops <= k && !q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int[] temp = q.poll();
                int node = temp[0];
                int distance = temp[1];

                if (!adj.containsKey(node))
                    continue;
                // Loop over neighbors of popped node.
                for (int[] e : adj.get(node)) {
                    int neighbour = e[0];
                    int price = e[1];
                    if (price + distance >= dist[neighbour])
                        continue;
                    dist[neighbour] = price + distance;
                    q.offer(new int[] { neighbour, dist[neighbour] });
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    //time limit exceeded on 28 / 52
    static int min;
    static int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        if (n == 1) return flights[0][2];
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] arr : flights) {
            int from = arr[0], to = arr[1], price = arr[2];
            Map<Integer, Integer> mapCur = map.computeIfAbsent(from, func -> new HashMap<>());
            mapCur.put(to, price);
        }
        if (map.get(src) == null) return -1;
        min = Integer.MAX_VALUE;
        goDFS(src, dst, 0, k, map, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static void goDFS(int src, int dst, int lvl, int k, Map<Integer, Map<Integer, Integer>> map, int price) {
        if (src == dst && lvl <= k + 1) {
            if (min > price) min = price;
            return;
        }
        if (lvl > k + 1) return;
        lvl++;
        Map<Integer, Integer> mapCur = map.get(src);
        for (int dstCur : mapCur.keySet()) {
            goDFS(dstCur, dst, lvl, k, map, price + mapCur.get(dstCur));
        }
    }


    static class NTreeNode {
        public char val;
        public List<NTreeNode> children;
        public int freq;
        int index;

        public NTreeNode() {}

        public NTreeNode(char _val, int idx) {
            val = _val;
            index = idx;
            children = new ArrayList<>();
        }

        public NTreeNode(char _val, List<NTreeNode> _children) {
            val = _val;
            children = _children;
        }
    }
}
