package LeetCode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Problem760 {
    //https://leetcode.com/problems/find-anagram-mappings/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-anagram-mappings/solutions/5050281/java-1ms-map-of-queues-solution/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //98.81%
    //of users with Java
    //Memory
    //42.08
    //MB
    //Beats
    //21.03%
    //of users with Java
    static int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int n = nums2[i];
            Queue<Integer> q = map.get(n);
            if (q == null) {
                q = new LinkedList<>();
                map.put(n, q);
            }
            q.offer(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            nums1[i] = map.get(nums1[i]).poll();
        }
        return nums1;
    }
}
