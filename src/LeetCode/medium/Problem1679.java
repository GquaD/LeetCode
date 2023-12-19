package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1679 {
    //https://leetcode.com/problems/max-number-of-k-sum-pairs/
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3,1,3,4,3}, 6));
        System.out.println(maxOperations(new int[]{1,2,3,4}, 5));
    }

    //https://leetcode.com/problems/max-number-of-k-sum-pairs/solutions/4425310/java-o-n-hashmap/
    //15 min
    //Runtime
    //33 ms
    //Beats
    //41.24%
    //Memory
    //58.1 MB
    //Beats
    //12.83%
    static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        int count = 0;
        for (int key : map.keySet()) {
            int freq = map.get(key), key2 = k - key;
            if (freq == 0) continue;
            if (map.containsKey(key2)) {
                int freq2 = map.get(key2), min = Math.min(freq, freq2);
                if (key == key2) {
                    count += freq / 2;
                    map.put(key, 0);
                    continue;
                }
                count += min;
                if (freq >= freq2) {
                    map.put(key, Math.max(freq - min, 0));
                    map.put(key2, 0);
                } else {
                    map.put(key2, Math.max(freq2 - min, 0));
                    map.put(key, 0);
                }
            }
        }
        return count;
    }
}
