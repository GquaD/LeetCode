package LeetCode.easy;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1436 {
    //https://leetcode.com/problems/destination-city/
    public static void main(String[] args) {
//        System.out.println(de);
    }

    //Runtime: 6 ms, faster than 22.31% of Java online submissions for Destination City.
    //Memory Usage: 43.7 MB, less than 61.78% of Java online submissions for Destination City.
    static String destCity(List<List<String>> paths) {
        //pair: position - appearances
        Map<String, PairMy> map = new HashMap<>();
        for (int i = 0; i < paths.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String temp = paths.get(i).get(j);
                if (map.containsKey(temp)) {
                    PairMy pair = map.get(temp);
                    pair.times++;
                    map.put(temp, pair);
                } else {
                    PairMy pair = new PairMy();
                    pair.times++;
                    pair.position = j;
                    map.put(temp, pair);
                }
            }
        }

        for (String key : map.keySet()) {
            PairMy pair = map.get(key);
            if (pair.position == 1 && pair.times == 1) {
                return key;
            }
        }
        return "";
    }

    static class PairMy {
        int position;
        int times;
    }
}
