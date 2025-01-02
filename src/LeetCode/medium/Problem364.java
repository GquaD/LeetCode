package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem364 {
    //https://leetcode.com/problems/nested-list-weight-sum-ii
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/nested-list-weight-sum-ii/solutions/6219389/java-recursive-solution-by-tbekpro-ztsf/
    //10-15min
    //Runtime
    //1
    //ms
    //Beats
    //48.89%
    //Analyze Complexity
    //Memory
    //41.41
    //MB
    //Beats
    //22.65%
    public int depthSumInverse(List<NestedInteger> nestedList) {
        //max depth, cur depth, cur value
        int[] max = new int[1];
        List<Pair> list = new ArrayList<>();
        for (NestedInteger n: nestedList) {
            addAllIntegers(n, list, 1, max);
        }
        int res = 0;
        for (Pair p : list) {
            res += (max[0] - p.depth + 1) * p.value;
        }
        return res;
    }

    private void addAllIntegers(NestedInteger n, List<Pair> list, int lvl, int[] max) {
        if (n.isInteger()) {
            max[0] = Math.max(max[0], ++lvl);
            list.add(new Pair(lvl, n.getInteger()));
            return;
        }

        for (NestedInteger t: n.getList()) {
            addAllIntegers(t, list, lvl + 1, max);
        }
    }

    class Pair {
        int depth, value;

        public Pair(int d, int v) {
            depth = d;
            value = v;
        }
    }
}
