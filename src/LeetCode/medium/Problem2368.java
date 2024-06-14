package LeetCode.medium;

import java.util.*;

public class Problem2368 {
    //https://leetcode.com/problems/reachable-nodes-with-restrictions/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/reachable-nodes-with-restrictions/solutions/5312469/java-bfs-solution/
    //10-15min
    //Runtime
    //140
    //ms
    //Beats
    //25.36%
    //Memory
    //112.64
    //MB
    //Beats
    //49.94%
    static int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e: edges) {
            int a = e[0], b = e[1];

            List<Integer> la = map.get(a);
            if (la == null) {
                la = new ArrayList<>();
                map.put(a, la);
            }
            la.add(b);

            List<Integer> lb = map.get(b);
            if (lb == null) {
                lb = new ArrayList<>();
                map.put(b, lb);
            }
            lb.add(a);
        }

        Set<Integer> setR = new HashSet<>();
        for (int r : restricted) setR.add(r);

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (visited.contains(cur) || setR.contains(cur)) {
                    continue;
                }
                visited.add(cur);
                List<Integer> list = map.get(cur);
                if (list != null) q.addAll(list);
            }
        }
        return visited.size();
    }
}
