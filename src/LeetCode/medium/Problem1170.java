package LeetCode.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Problem1170 {
    //https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numSmallerByFrequency(
                new String[]{"cbd"},
                new String[]{"zaaaz"}
        )));
        System.out.println(Arrays.toString(numSmallerByFrequency(
                new String[]{"bbb", "cc"},
                new String[]{"a", "aa", "aaa", "aaaa"}
        )));
    }

    //https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/solutions/3789685/java-using-arrays-and-treemap/
    //25-30 min
    //Runtime
    //Details
    //8ms
    //Beats 56.25%of users with Java
    //Memory
    //Details
    //43.65mb
    //Beats 93.75%of users with Java
    static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] arrQ = new int[queries.length], arrW = new int[words.length];
        for (int i = 0; i < queries.length; i++) arrQ[i] = countFreqOfSmallestChar(queries[i]);
        for (int i = 0; i < words.length; i++) arrW[i] = countFreqOfSmallestChar(words[i]);
        Map<Integer, Integer> map = new TreeMap<>();
        int prev = 0;
        for (int n : arrW)
            map.put(n, map.getOrDefault(n, 0) + 1);

        for (int key : map.keySet()) {
            map.put(key, map.getOrDefault(prev, 0) + map.get(key));
            prev = key;
        }

        for (int i = 0; i < arrQ.length; i++) {
            int n = arrQ[i], count = 0;
            for (int key : map.keySet()) {
                if (key <= n) count = map.get(key);
                else break;
            }
            arrQ[i] = arrW.length - count;
        }

        return arrQ;
    }

    static int countFreqOfSmallestChar(String s) {
        int count = 0;
        char c = 'z';
        for (int j = 0; j < s.length(); j++) {
            char t = s.charAt(j);
            if (t < c) {
                c = t;
                count = 1;
            } else if (t == c) {
                count++;
            }
        }
        return count;
    }
}
