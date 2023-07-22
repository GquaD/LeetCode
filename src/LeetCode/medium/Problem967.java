package LeetCode.medium;

import java.util.*;

public class Problem967 {
    //https://leetcode.com/problems/numbers-with-same-consecutive-differences/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numsSameConsecDiff(2, 1)));
        System.out.println(Arrays.toString(numsSameConsecDiff(3, 7)));
    }

    //https://leetcode.com/problems/numbers-with-same-consecutive-differences/solutions/3801648/java-hashset-backtracking-recursive-solution/
    //25-30 min
    //Runtime
    //5 ms
    //Beats
    //32.80%
    //Memory
    //42.2 MB
    //Beats
    //34.95%
    static int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            sb.append(i);
            generateNumbers(set, i, n, k, sb);
            sb.setLength(0);
        }
        int c = 0, arr[] = new int[set.size()];
        for (int num : set) arr[c++] = num;
        return arr;
    }

    static void generateNumbers(Set<Integer> set, int prev, int n, int k, StringBuilder sb) {
        if (sb.length() > n) return;

        if (sb.length() == n) {
            set.add(Integer.parseInt(sb.toString()));
            return;
        }

        if (prev - k >= 0) {
            sb.append(prev - k);
            generateNumbers(set, prev - k, n, k, sb);
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        if (prev + k <= 9) {
            sb.append(prev + k);
            generateNumbers(set, prev + k, n, k, sb);
            sb.replace(sb.length() - 1, sb.length(), "");
        }
    }
}
