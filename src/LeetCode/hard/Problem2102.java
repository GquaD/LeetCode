package LeetCode.hard;

import java.util.*;

public class Problem2102 {
    //https://leetcode.com/problems/sequentially-ordinal-rank-tracker/
    public static void main(String[] args) {

    }
}



//25 min
//Runtime
//1561 ms
//Beats
//5.17%
//Memory
//77.9 MB
//Beats
//5.17%
class SORTracker1 {

    TreeMap<Integer, TreeSet<String>> map;
    int calls;

    public SORTracker1() {
        map = new TreeMap<>(Comparator.reverseOrder());
        calls = 0;
    }

    public void add(String name, int score) {
        map.computeIfAbsent(score, k -> new TreeSet<>()).add(name);
    }

    public String get() {
        String res = "";
        int t = 0;
        outerloop:
        for (int k : map.keySet()) {
            TreeSet<String> set = map.get(k);
            if (calls < t + set.size()) {
                for (String s : set) {
                    if (t++ == calls) {
                        res = s;
                        break outerloop;
                    }
                }
            } else {
                t += set.size();
            }
        }
        calls++;
        return res;
    }
}
