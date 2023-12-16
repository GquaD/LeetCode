package LeetCode.medium;
import java.util.*;

public class Problem210 {
    //https://leetcode.com/problems/course-schedule-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/course-schedule-ii/solutions/4412813/java-bfs-solution/
    //40 min and without IDE, only in text editor
    //Runtime
    //17 ms
    //Beats
    //10.3%
    //Memory
    //46.1 MB
    //Beats
    //6.94%
    static int[] findOrder(int num, int[][] p) {
        LinkedHashSet<Integer> list = new LinkedHashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> mapA = new HashMap<>();

        for (int[] n : p) {
            int a = n[0], b = n[1];
            Set<Integer> set = map.get(a);
            if (set == null) {
                set = new HashSet<>();
                map.put(a, set);
            }
            set.add(b);

            Set<Integer> setA = mapA.get(b);
            if (setA == null) {
                setA = new HashSet<>();
                mapA.put(b, setA);
            }
            setA.add(a);
        }

        for (int i = 0; i < num; i++) {
            if (!map.containsKey(i)) {
                list.add(i);
            }
        }

        if (list.size() > 0) {
            Queue<Integer> queue = new LinkedList<>();
            for (int k : list) {
                queue.offer(k);
            }
            Set<Integer> visited = new HashSet<>();
            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();

                    if (visited.contains(cur)) continue;
                    visited.add(cur);

                    Set<Integer> set = mapA.get(cur);
                    if (set == null) continue;

                    for (int to : set) {
                        if (map.containsKey(to)) {

                            Set<Integer> pre = map.get(to);
                            int counter = 0;

                            for (int tt : pre) {
                                if (list.contains(tt)) {
                                    counter++;
                                }
                            }

                            if (counter == pre.size()) {
                                list.add(to);
                                queue.add(to);
                            }
                        }
                    }
                }
            }
        } else {
            return new int[0];
        }

        if (list.size() == num) {
            int[] arr = new int[list.size()];
            int i = 0;
            for (int k : list) {
                arr[i++] = k;
            }
            return arr;
        }

        return new int[0];
    }
}
