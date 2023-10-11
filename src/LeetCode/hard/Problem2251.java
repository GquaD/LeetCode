package LeetCode.hard;

import javafx.util.Pair;

import java.util.*;

public class Problem2251 {
    //https://leetcode.com/problems/number-of-flowers-in-full-bloom
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fullBloomFlowers(new int[][]{{19,37},{19,38},{19,35}}, new int[]{6,7,21,1,13,37,5,37,46,43})));
        System.out.println(Arrays.toString(fullBloomFlowers(new int[][]{{1,6},{3,7},{9,12},{4,13}}, new int[]{2,3,7,11})));
        System.out.println(Arrays.toString(fullBloomFlowers(new int[][]{{1,10},{3,3}}, new int[]{3,3,2})));
    }

    //https://leetcode.com/problems/number-of-flowers-in-full-bloom/solutions/4156929/java-o-nlogn-solution/
    //45-50min
    //Runtime
    //128 ms
    //Beats
    //11.54%
    //Memory
    //73.1 MB
    //Beats
    //33.85%
    static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int[] f : flowers) {
            list.add(new Pair<>(f[0], 1));
            list.add(new Pair<>(f[1] + 1, -1));
        }
        Collections.sort(list, (a, b) -> a.getKey() - b.getKey());
        Map<Integer, Integer> mapBloom = new TreeMap<>();
        for (Pair<Integer, Integer> p : list) {
            mapBloom.put(p.getKey(), mapBloom.getOrDefault(p.getKey(), 0) + p.getValue());
        }
        List<Pair<Integer, Integer>> listFinal = new ArrayList<>();
        int sum = 0;
        for (int key : mapBloom.keySet()) {
            sum += mapBloom.get(key);
            listFinal.add(new Pair<>(key, sum));
        }
        for (int i = 0; i < people.length; i++) {
            int day = people[i];
            int idx = Collections.binarySearch(listFinal, new Pair<>(day, 0), (a,b) -> a.getKey().compareTo(b.getKey()));
            if (idx >= 0) {
                people[i] = listFinal.get(idx).getValue();
            } else if (idx < 0) {
                idx = -idx - 1;
                if (idx == listFinal.size() || idx == 0) {
                    people[i] = 0;
                } else {
                    idx = Math.max(0, idx - 1);
                    people[i] = listFinal.get(idx).getValue();
                }
            }
        }
        return people;
    }
}
