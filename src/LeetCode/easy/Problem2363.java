package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Problem2363 {
    //https://leetcode.com/problems/merge-similar-items/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/merge-similar-items/solutions/2693280/java-solution-using-treemap/
    //5 min
    //Runtime
    //19 ms
    //Beats
    //31%
    //Memory
    //54.7 MB
    //Beats
    //54.17%
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] i : items1) {
            if (map.containsKey(i[0])) {
                map.put(i[0], map.get(i[0]) + i[1]);
            } else {
                map.put(i[0], i[1]);
            }
        }
        for (int[] i : items2) {
            if (map.containsKey(i[0])) {
                map.put(i[0], map.get(i[0]) + i[1]);
            } else {
                map.put(i[0], i[1]);
            }
        }
        List<List<Integer>> list = new ArrayList<>(map.keySet().size());
        for (Integer key : map.keySet()) {
            List<Integer> l = new ArrayList<>(2);
            l.add(key);
            l.add(map.get(key));
            list.add(l);
        }
        return list;
    }
}
