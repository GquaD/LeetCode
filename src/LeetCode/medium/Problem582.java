package LeetCode.medium;

import java.util.*;

public class Problem582 {
    //https://leetcode.com/problems/kill-process/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/kill-process/solutions/5016488/java-o-n-bfs-solution/
    //10min
    //Runtime
    //24
    //ms
    //Beats
    //80.73%
    //of users with Java
    //Memory
    //53.71
    //MB
    //Beats
    //51.16%
    //of users with Java
    static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int child = pid.get(i), parent = ppid.get(i);
            List<Integer> children = map.get(parent);
            if (children == null) {
                children = new ArrayList<>();
                map.put(parent, children);
            }
            children.add(child);
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(kill);

        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int process = q.poll();
                res.add(process);
                List<Integer> children = map.get(process);
                if (children != null) q.addAll(children);
            }
        }
        return res;
    }
}
