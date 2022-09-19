package LeetCode.medium;

import java.util.*;

public class Problem1338 {
    //https://leetcode.com/problems/reduce-array-size-to-the-half/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/reduce-array-size-to-the-half/discuss/2597986/Java-Solution-using-map
    //10 min
    //Runtime: 91 ms, faster than 57.50% of Java online submissions for Reduce Array Size to The Half.
    //Memory Usage: 83.7 MB, less than 71.92% of Java online submissions for Reduce Array Size to The Half.
    static int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : arr) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        List<Integer> freq = new ArrayList<>(map.values());
        Collections.sort(freq, Collections.reverseOrder());
        int target = arr.length, half = arr.length / 2;
        int count = 0;
        while (target > half) {
            target -= freq.get(count++);
        }
        return count;
    }
}
