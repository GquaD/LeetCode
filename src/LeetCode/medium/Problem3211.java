package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem3211 {
    //https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/solutions/5435583/java-100-faster-recursive-backtracking-solution/
    //5-10min
    //Runtime
    //5
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.78
    //MB
    //Beats
    //100.00%
    public List<String> validStrings(int n) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        generate(sb, 0, n, set);

        sb.setLength(0);
        sb.append(1);
        generate(sb, 1, n, set);
        return new ArrayList<>(set);
    }

    private void generate(StringBuilder sb, int last, int n, Set<String> set) {
        if (sb.length() == n) {
            set.add(sb.toString());
            return;
        }

        int len = sb.length();
        sb.append(1);
        generate(sb, 1, n, set);

        if (last == 1) {
            sb.setLength(len);
            sb.append(0);
            generate(sb, 0, n, set);
        }
    }
}
