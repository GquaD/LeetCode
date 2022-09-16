package LeetCode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem771 {
    //https://leetcode.com/problems/jewels-and-stones/
    public static void main(String[] args) {

    }

    //Runtime: 1 ms, faster than 98.04% of Java online submissions for Jewels and Stones.
    //Memory Usage: 40.8 MB, less than 89.39% of Java online submissions for Jewels and Stones.
    static int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        int sum = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                sum++;
            }
        }
        return sum;
    }


    //Runtime: 6 ms, faster than 7.19% of Java online submissions for Jewels and Stones.
    //Memory Usage: 42.4 MB, less than 46.34% of Java online submissions for Jewels and Stones.
    static int numJewelsInStones1(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < jewels.length(); i++) {
            map.put(jewels.charAt(i), 0);
        }

        for (int i = 0; i < stones.length(); i++) {
            char key = stones.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }
        }

        int sum = 0;
        for (Character c : map.keySet()) {
            sum += map.get(c);
        }
        return sum;
    }
}
