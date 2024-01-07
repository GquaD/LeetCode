package LeetCode.medium;
import java.util.*;

public class Problem10033 {
    //https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/submissions/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/solutions/4524541/java-bfs-100-faster/
    //10min
    //Runtime
    //9 ms
    //Beats
    //100%
    //Memory
    //44.7 MB
    //Beats
    //50%
    static int minimumOperationsToMakeEqual(int x, int y) {
        if (x <= y) return y - x;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        int count = 0;
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                if (set.contains(cur)) continue;
                set.add(cur);

                if (cur == y) return count;
                queue.add(cur - 1);
                queue.add(cur + 1);
                if (cur % 11 == 0) queue.add(cur / 11);
                if (cur % 5 == 0) queue.add(cur / 5);
            }
            count++;
        }
        return 0;
    }
}
