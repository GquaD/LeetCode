package LeetCode.easy;

import java.util.*;

public class Problem1971 {
    //https://leetcode.com/problems/find-if-path-exists-in-graph/?envType=daily-question&envId=2024-04-21
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-if-path-exists-in-graph/solutions/5054959/java-hashmap-bfs-solution/
    //15min
    //Runtime
    //97
    //ms
    //Beats
    //64.84%
    //of users with Java
    //Memory
    //150.15
    //MB
    //Beats
    //46.56%
    //of users with Java
    boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : edges) {
            int u = arr[0], v = arr[1];
            List<Integer> listu = map.get(u);
            if (listu == null) {
                listu = new ArrayList<>();
                map.put(u, listu);
            }
            listu.add(v);

            List<Integer> listv = map.get(v);
            if (listv == null) {
                listv = new ArrayList<>();
                map.put(v, listv);
            }
            listv.add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        Set<Integer> visited = new HashSet<>();

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (visited.contains(cur)) continue;
                visited.add(cur);

                if (cur == destination) return true;
                List<Integer> list = map.get(cur);
                if (list != null) queue.addAll(list);
            }
        }
        return false;
    }
}
