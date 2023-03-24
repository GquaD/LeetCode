package LeetCode.medium;

import java.util.*;

public class Problem1466 {
    //https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/
    public static void main(String[] args) {
        System.out.println(minReorder(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
    }

    //https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/solutions/3334277/java-using-2-hashmaps/
    //30 min
    //Runtime
    //159 ms
    //Beats
    //33.91%
    //Memory
    //65.5 MB
    //Beats
    //84.61%
    static int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> mapLeft = new HashMap<>();
        Map<Integer, List<Integer>> mapRight = new HashMap<>();
        for (int[] conn : connections) {
            int left = conn[0], right = conn[1];
            mapLeft.computeIfAbsent(left, k -> new ArrayList<>()).add(right);
            mapRight.computeIfAbsent(right, k -> new ArrayList<>()).add(left);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (!visited.add(curr)) continue;

            List<Integer> listChange = mapLeft.get(curr);
            if (listChange != null) {
                queue.addAll(listChange);
                for (int i = 0; i < listChange.size(); i++) {
                    if (!visited.contains(listChange.get(i))) count++;
                }
            }

            queue.addAll(mapRight.getOrDefault(curr, new ArrayList<>()));

        }
        return count;
    }
}
