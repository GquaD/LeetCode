package LeetCode.medium;

import java.util.*;

public class Problem2300 {
    //https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairs(
                new int[]{5,1,3},
                new int[]{1,2,3,4,5},
                7
        )));
    }

    //https://leetcode.com/problems/successful-pairs-of-spells-and-potions/solutions/3368187/java-using-map/
    //Runtime
    //111 ms
    //Beats
    //15.70%
    //Memory
    //62.7 MB
    //Beats
    //33.47%
    static int[] successfulPairs(int[] spells, int[] potions, long success) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < potions.length; i++) {
            int times = (int) Math.ceil((1.0 * success) / potions[i]);
            if (map.containsKey(times)) {
                map.put(times, map.get(times) + 1);
            } else {
                map.put(times, 1);
            }
        }

        int sum = 0;
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int key : list) {
            sum += map.get(key);
            map.put(key, sum);
        }
        for (int i = 0; i < spells.length; i++) {
            int key = spells[i], idx = Collections.binarySearch(list, key);
            if (idx < 0) idx = -idx - 2;
            if (idx >= 0) spells[i] = map.get(list.get(idx));
            else spells[i] = 0;
        }
        return spells;
    }

    //20-25 min
    //Runtime
    //183 ms
    //Beats
    //7.85%
    //Memory
    //64.2 MB
    //Beats
    //5.79%
    static int[] successfulPairs1(int[] spells, int[] potions, long success) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < potions.length; i++) {
            int times = (int) Math.ceil((1.0 * success) / potions[i]);
            if (map.containsKey(times)) {
                map.put(times, map.get(times) + 1);
            } else {
                map.put(times, 1);
            }
        }

        int sum = 0;
        for (int key : map.keySet()) {
            sum += map.get(key);
            map.put(key, sum);
        }
        int[] arr = new int[spells.length];
        int[] keys = new int[map.keySet().size()];
        int c = 0;
        for (int key : map.keySet()) {
            keys[c++] = key;
        }
        for (int i = 0; i < spells.length; i++) {
            int key = spells[i], idx = Arrays.binarySearch(keys, key);
            if (idx < 0) idx = -idx - 2;
            if (idx >= 0) arr[i] = map.get(keys[idx]);
        }
        return arr;
    }
}
