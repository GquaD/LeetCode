package LeetCode.medium;

import java.util.*;

public class Problem399 {
    //https://leetcode.com/problems/evaluate-division/description/
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("b");
        equations.add(l1);
        List<String> l2 = new ArrayList<>();
        l2.add("b");
        l2.add("c");
        equations.add(l2);
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> l3 = new ArrayList<>();
        l3.add("a");
        l3.add("c");
        queries.add(l3);
        List<String> l4 = new ArrayList<>();
        l4.add("b");
        l4.add("a");
        queries.add(l4);
        List<String> l5 = new ArrayList<>();
        l5.add("a");
        l5.add("e");
        queries.add(l5);
        List<String> l6 = new ArrayList<>();
        l6.add("a");
        l6.add("a");
        queries.add(l6);
        List<String> l7 = new ArrayList<>();
        l7.add("x");
        l7.add("x");
        queries.add(l7);
        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }

    //35-40 min
    //Runtime
    //1 ms
    //Beats
    //90.67%
    //Memory
    //41 MB
    //Beats
    //84.7%
    static double val = -1.0;
    static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            String one = list.get(0), two = list.get(1);
            if (!map.containsKey(one)) map.put(one, new HashMap<>());
            map.get(one).put(two, values[i]);
            if (!map.containsKey(two)) map.put(two, new HashMap<>());
            map.get(two).put(one, 1 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> list = queries.get(i);
            String one = list.get(0), two = list.get(1);
            if (map.containsKey(one) && map.get(one).containsKey(two)) {
                res[i] = map.get(one).get(two);
            } else {
                val = -1.0;
                Set<String> visited = new HashSet<>();
                goDFS(one, two, map, 1.0, visited);
                res[i] = val;
            }
        }
        return res;
    }

    private static void goDFS(String one, String two, Map<String, Map<String, Double>> map, double d, Set<String> visited) {
        if (visited.contains(one)) return;
        if (map.containsKey(one) && map.get(one).containsKey(two)) {
            val = map.get(one).get(two) * d;
            return;
        }
        visited.add(one);
        Map<String, Double> mapOne = map.get(one);
        if (mapOne == null) return;
        for (String key : mapOne.keySet()) {
            goDFS(key, two, map, d * mapOne.get(key), visited);
        }
    }
}
