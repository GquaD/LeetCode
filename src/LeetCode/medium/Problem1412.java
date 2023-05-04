package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1412 {
    //https://leetcode.com/problems/the-kth-factor-of-n/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/the-kth-factor-of-n/solutions/3483817/java-straightforward-solution-with-caching/
    //Runtime
    //1 ms
    //Beats
    //45.22%
    //Memory
    //40.1 MB
    //Beats
    //9.71%
    private static Map<Integer, List<Integer>> mapFactors;
    static int kthFactor(int n, int k) {
        if (mapFactors == null) mapFactors = new HashMap<>();
        List<Integer> factors;
        if (mapFactors.containsKey(n)) {
            factors = mapFactors.get(n);
        } else {
            factors = new ArrayList<>();
            for (int i = 1; i <= n / 2 + 1; i++) if (n % i == 0) factors.add(i);
            factors.add(n);
            mapFactors.put(n, factors);
        }
        return k <= factors.size() ? factors.get(k - 1) : -1;
    }
}
