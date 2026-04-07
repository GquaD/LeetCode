package LeetCode.easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class Problem2335 {
    //20min

    //Runtime
    //2
    //ms
    //Beats
    //58.69%
    //Memory
    //42.97
    //MB
    //Beats
    //66.31%
    public int fillCups(int[] a) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        if (a[0] > 0) pq.offer(a[0]);
        if (a[1] > 0) pq.offer(a[1]);
        if (a[2] > 0) pq.offer(a[2]);

        while (pq.size() > 1) {
            int b = pq.poll() - 1, c = pq.poll() - 1;
            if (b > 0) pq.offer(b);
            if (c > 0) pq.offer(c);
            result++;
        }

        return pq.size() > 0 ? result + pq.poll() : result;
    }
}
