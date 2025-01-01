package LeetCode.medium;

import java.util.*;

public class Problem737 {
    //https://leetcode.com/problems/sentence-similarity-ii
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/sentence-similarity-ii/solutions/6212547/java-bfs-solution-by-tbekpro-8lrg/
    //20min
    //Runtime
    //51
    //ms
    //Beats
    //53.65%
    //Analyze Complexity
    //Memory
    //46.44
    //MB
    //Beats
    //28.13%
    public boolean areSentencesSimilarTwo(String[] s1, String[] s2, List<List<String>> sim) {
        if (s1.length != s2.length)
            return false;
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> list : sim) {
            String a = list.get(0), b = list.get(1);
            Set<String> set = map.get(a);
            if (set == null) {
                set = new HashSet<>();
                map.put(a, set);
            }
            set.add(b);

            set = map.get(b);
            if (set == null) {
                set = new HashSet<>();
                map.put(b, set);
            }
            set.add(a);
        }

        Set<String> visited = new HashSet<>();
        for (int i = 0; i < s1.length; i++) {
            String a = s1[i], b = s2[i];
            if (!a.equals(b) && !bfs(a, b, map)) {
                return false;
            }
        }
        return true;
    }

    private boolean bfs(String a, String b, Map<String, Set<String>> map) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(a);

        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (visited.contains(cur)) continue;
                visited.add(cur);

                Set<String> set = map.get(cur);
                if (set != null) {
                    if (set.contains(b))
                        return true;
                    q.addAll(set);
                }
            }
        }
        return false;
    }
}
