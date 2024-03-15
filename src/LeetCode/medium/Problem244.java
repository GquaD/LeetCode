package LeetCode.medium;
import java.util.*;

public class Problem244 {
    //https://leetcode.com/problems/shortest-word-distance-ii/
    public static void main(String[] args) {

    }


}
//https://leetcode.com/problems/shortest-word-distance-ii/solutions/4879130/java-map-lists-of-indices/
//20-25min
//Runtime
//29
//ms
//Beats
//61.81%
//of users with Java
//Memory
//51.11
//MB
//Beats
//65.05%
//of users with Java
class WordDistance {
    //word -> list of indices
    Map<String, List<Integer>> map;

    public WordDistance(String[] d) {
        map = new HashMap<>();
        for (int i = 0; i < d.length; i++) {
            String w = d[i];
            List<Integer> l = map.get(w);
            if (l == null) {
                l = new ArrayList<>();
                map.put(w, l);
            }
            l.add(i);
        }
    }

    public int shortest(String a, String b) {
        List<Integer> la = map.get(a), lb = map.get(b);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < la.size(); i++) {
            int x = la.get(i), y = Collections.binarySearch(lb, x);
            if (y < 0) y = -y - 1;
            if (y == lb.size()) y--;
            if (y - 1 < 0) {
                res = Math.min(res, Math.abs(lb.get(y) - x));
            } else {
                res = Math.min(res, Math.min(Math.abs(lb.get(y) - x), Math.abs(lb.get(y - 1) - x)));
            }
        }

        return res = res == 0 ? 1 : res;
    }
}
