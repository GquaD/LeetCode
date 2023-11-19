package LeetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1711 {
    //https://leetcode.com/problems/count-good-meals/
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length / 2) arr[i] = 0;
            else arr[i] = 2;
        }
        System.out.println(countPairs(arr));
        for (int i = 0; i < arr.length; i++) arr[i] = 32;
        System.out.println(countPairs(arr));
        System.out.println(countPairs(new int[]{1, 3, 5, 7, 9}));
        System.out.println(countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
    }

    //https://leetcode.com/problems/count-good-meals/solutions/4306497/java-hashmap-hashset/
    //30-35min
    //Runtime
    //133 ms
    //Beats
    //85.71%
    //Memory
    //56.1 MB
    //Beats
    //30.95%
    static int countPairs(int[] deliciousness) {
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : deliciousness) map.put(n, map.getOrDefault(n, 0) + 1);
        int[] arrPow = new int[32];
        for (int i = 0; i < arrPow.length; i++) arrPow[i] = (int) Math.pow(2, i);
        Set<String> setUsed = new HashSet<>();
        for (int k : map.keySet()) {
            for (int i = 0; i < arrPow.length; i++) {
                int diff = arrPow[i] - k;
                if (k < 0) continue;
                Integer freq2 = map.get(diff);
                if (freq2 != null) {
                    String s = Math.min(k, diff) + "_" + Math.max(k, diff);
                    if (setUsed.contains(s)) continue;
                    setUsed.add(s);
                    int freq1 = map.get(k);
                    if (k == diff) res += ((freq1 - 1L) * freq1) / 2;
                    else res += 1L * freq1 * freq2;
                }
            }
        }
        return (int) (res % 1_000_000_007);
    }
}
