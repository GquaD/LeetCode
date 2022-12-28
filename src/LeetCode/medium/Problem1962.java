package LeetCode.medium;

import java.util.*;

public class Problem1962 {
    //https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/
    public static void main(String[] args) {
        System.out.println(minStoneSum(new int[]{4122, 9928, 3477, 9942}, 6)); //8768
        System.out.println(minStoneSum(new int[]{5, 4, 9}, 2));
    }

    //https://leetcode.com/problems/remove-stones-to-minimize-the-total/solutions/2961630/java-beats-100-memory/
    //30 min
    //Runtime
    //875 ms
    //Beats
    //46.52%
    //Memory
    //51 MB
    //Beats
    //100%
    static int minStoneSum(int[] piles, int k) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int key : piles) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        while (k > 0) {
            for (int key : map.keySet()) {
                int freq = map.get(key);
                if (freq == 1) {
                    map.remove(key);
                } else {
                    map.put(key, freq - 1);
                }
                key = (int) Math.round(key / 2.0);
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
                break;
            }
            k--;
        }

        int sum = 0;
        for (int key : map.keySet()) {
            sum += key * map.get(key);
        }

        return sum;
    }

    static int minStoneSum1(int[] piles, int k) {
        //Arrays.sort(piles);
        /*List<Integer> list = new ArrayList<>(piles.length);
        for (int i = 0; i < piles.length; i++) {
            list.add(piles[i]);
        }*/
        /*for (int i = piles.length - 1; i >= 0; i--) {
            int curr = piles[i], prev = i >= 1 ? piles[i - 1] : 0;
            if (curr >= prev && k > 0) {
                curr = (int) Math.round(curr / 2.0);
                k--;
            }
            int res = Arrays.binarySearch(piles, curr);
            if (res < 0) ;
        }*/
        return 42;
    }
}
