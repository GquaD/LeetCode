package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem373 {
    //nnnn
    //Runtime
    //40
    //ms
    //Beats
    //29.43%
    //Memory
    //142.70
    //MB
    //Beats
    //16.60%
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[] { nums1[i] + nums2[0], i, 0 });
        }

        while (!pq.isEmpty() && result.size() < k) {
            int cur[] = pq.poll(), l = cur[1], r = cur[2];

            result.add(List.of(nums1[l], nums2[r]));
            if (r + 1 < nums2.length)
                pq.offer(new int[] { nums1[l] + nums2[r + 1], l, r + 1 });
        }
        return result;
    }
}
