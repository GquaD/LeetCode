package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem187 {
    //https://leetcode.com/problems/repeated-dna-sequences/
    public static void main(String[] args) {
        LeetCodeUtils.printList(findRepeatedDnaSequences("AAAAAAAAAAA"));
        LeetCodeUtils.printList(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        LeetCodeUtils.printList(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }

    //https://leetcode.com/problems/repeated-dna-sequences/solutions/3368431/java-count-frequency-using-hashmap/
    //15min
    //Runtime
    //25 ms
    //Beats
    //31.39%
    //Memory
    //51.6 MB
    //Beats
    //21.83%
    static List<String> findRepeatedDnaSequences2(String s) {
        if (s.length() < 11) return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            if (map.containsKey(temp)) map.put(temp, map.get(temp) + 1);
            else map.put(temp, 1);
        }
        List<String> result = new ArrayList<>();
        for (String seq : map.keySet()) if (map.get(seq) > 1) result.add(seq);
        return result;
    }

    //nnnn
    //Runtime
    //17 ms
    //Beats
    //84.92%
    //Memory
    //50.9 MB
    //Beats
    //77.81%
    static List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 11) return new ArrayList<>();
        Set<String> set = new HashSet<>(), set2 = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            if (!set.add(temp)) {
                set2.add(temp);
            }
        }
        return new ArrayList<>(set2);
    }



    //TLE on 30/31
    static List<String> findRepeatedDnaSequences1(String s) {
        if (s.length() < 11) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            if (s.indexOf(temp,i + 1) != -1) {
                set.add(temp);
            }
        }
        return new ArrayList<>(set);
    }
}
