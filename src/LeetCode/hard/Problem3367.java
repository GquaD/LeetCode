package LeetCode.hard;

import java.util.*;

public class Problem3367 {
    //2h
    //nnn
    //Runtime
    //193
    //ms
    //Beats
    //27.45%
    //Memory
    //314.27
    //MB
    //Beats
    //5.88%
    PriorityQueue<Long> pq = new PriorityQueue<>();
    public long maximizeSumOfWeights(int[][] edges, int k) {
        Map<Integer, List<Pair>> map = new HashMap<>();
        long sum = 0;
        for (int[] e: edges) {
            int a = e[0], b = e[1], weight = e[2];
            sum += weight;

            List<Pair> list = map.get(a);
            if (list == null) {
                list = new ArrayList();
                map.put(a, list);
            }
            list.add(new Pair(b, weight));

            list = map.get(b);
            if (list == null) {
                list = new ArrayList();
                map.put(b, list);
            }
            list.add(new Pair(a, weight));
        }

        long[] result = dfs(0, -1, map, k);
        return result[1];
    }

    private long[] dfs(int i, int pre, Map<Integer, List<Pair>> map, int k) {
        long res = 0;
        List<Long> diff = new ArrayList<>();

        List<Pair> edges = map.get(i);

        for (Pair p: edges) {
            if (p.node == pre) continue;

            long[] nodeResult = dfs(p.node, i, map, k);
            long v1 = nodeResult[0], v2 = nodeResult[1];

            res += v2;

            diff.add(Math.max(0, v1 + p.weight - v2));
        }

        long a = res + sum(largestElements(k - 1, diff)), b = res + sum(largestElements(k, diff));

        return new long[]{a, b};
    }

    private List<Long> largestElements(int k, List<Long> list) {
        pq.clear();
        for (long l: list) {
            pq.offer(l);
            if (pq.size() > k) pq.poll();
        }

        return new ArrayList<>(pq);
    }

    private long sum(List<Long> list) {
        long result = 0;
        for (long l: list) result += l;
        return result;
    }

    private static class Pair {
        int node, weight;

        public Pair(int n, int w) {
            node = n;
            weight = w;
        }
    }
}
