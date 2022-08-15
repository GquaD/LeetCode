package LeetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1079 {
    //https://leetcode.com/problems/letter-tile-possibilities/
    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("AAABBC"));
        System.out.println(numTilePossibilities("V"));
    }

    //34 mins
    //Runtime: 59 ms, faster than 30.34% of Java online submissions for Letter Tile Possibilities.
    //Memory Usage: 55.3 MB, less than 14.94% of Java online submissions for Letter Tile Possibilities.
    static Set<String> cache;
    static int numTilePossibilities(String tiles) {
        cache = new HashSet<>();
        generateAllPossibleStrings1(tiles, "");
        return cache.size() - 1;
    }

    private static void generateAllPossibleStrings1(String tiles, String current) {
        if (cache.contains(current)) {
            return;
        }
        cache.add(current);
        for (int i = 0; i < tiles.length(); i++) {
            String tilesNext = tiles.substring(0, i) + tiles.substring(i + 1);
            String toAdd = current + tiles.charAt(i);
            generateAllPossibleStrings1(tilesNext, toAdd);
        }
    }

    //wrong
    static int numTilePossibilities1(String tiles) {
        cache = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tiles.length(); i++) {
            char key = tiles.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        generateAllPossibleStrings(tiles, "", map);
        return cache.size();
    }

    private static void generateAllPossibleStrings(String tiles, String current, Map<Character, Integer> map) {
        if (cache.contains(current)) {
            return;
        }
        cache.add(current);
        for (int i = 0; i < tiles.length(); i++) {
            char key = tiles.charAt(i);
            if (map.get(key) != null && map.get(key) != 0) {
                map.put(key, map.get(key) - 1);
                generateAllPossibleStrings(tiles, current + tiles.charAt(i), map);
            } else {
                continue;
            }
        }
    }
}
