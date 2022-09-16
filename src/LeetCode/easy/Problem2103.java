package LeetCode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem2103 {
    //https://leetcode.com/problems/rings-and-rods/
    public static void main(String[] args) {
        System.out.println(countPoints("B0B6G0R6R0R6G9"));
        System.out.println(countPoints("B0R0G0R9R0B0G0"));
        System.out.println(countPoints("G4"));
    }

    //Runtime: 2 ms, faster than 53.18% of Java online submissions for Rings and Rods.
    //Memory Usage: 40.6 MB, less than 84.79% of Java online submissions for Rings and Rods.
    static int countPoints(String rings) {
        if (rings.length() < 6) return 0;
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < rings.length(); i+=2) {
            int tempRod = Integer.parseInt(rings.charAt(i + 1) + "");
            map.get(tempRod).add(rings.charAt(i));
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key).size() == 3) {
                count++;
            }
        }
        return count;
    }
}
