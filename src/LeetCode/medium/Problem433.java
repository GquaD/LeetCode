package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem433 {
    //https://leetcode.com/problems/minimum-genetic-mutation

    //https://leetcode.com/problems/minimum-genetic-mutation/solutions/5460145/java-100-faster-0ms-recursive-solution/
    //15min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.22
    //MB
    //Beats
    //59.41%
    public int minMutation(String startGene, String endGene, String[] bank) {
        int[] res = new int[]{20};
        Set<String> set = new HashSet<>();
        goRecursive(startGene, endGene, bank, res, 0, set);
        return res[0] == 20 ? -1 : res[0];
    }

    private void goRecursive(String start, String end, String[] bank, int[] res, int step, Set<String> set) {
        if (start.equals(end)) {
            res[0] = Math.min(step, res[0]);
            return;
        }
        for (String s : bank) {
            if (goodMutation(start, s) && !set.contains(s)) {
                set.add(s);
                goRecursive(s, end, bank, res, step + 1, set);
                set.remove(s);
            }
        }
    }

    private boolean goodMutation(String a, String b) {
        int diff = 0;
        for (int i = 0; i < 8; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (diff >= 1) return false;
                diff++;
            }
        }
        return diff == 1;
    }
}
